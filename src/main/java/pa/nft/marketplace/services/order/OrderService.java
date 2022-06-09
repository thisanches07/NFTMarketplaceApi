package pa.nft.marketplace.services.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.nft.marketplace.dto.order.OrderDTO;
import pa.nft.marketplace.dto.order.OrderInsertDTO;
import pa.nft.marketplace.dto.order.OrderUpdateDTO;
import pa.nft.marketplace.entities.order.Item;
import pa.nft.marketplace.entities.order.Order;
import pa.nft.marketplace.entities.user.User;
import pa.nft.marketplace.repositories.order.OrderRepository;
import pa.nft.marketplace.services.user.UserService;

@Service
public class OrderService {
  
  @Autowired
  private OrderRepository orderRepository;

  @Autowired
  private ItemService itemService;

  @Autowired
  private UserService userService;

  public List<OrderDTO> getOrders(Long userId){
    List<Order> orders = orderRepository.findAllWhereUserId(userId);
    List<OrderDTO> orderDTOs = new ArrayList<>();
    orders.forEach((e) -> orderDTOs.add(new OrderDTO(e)));
    return orderDTOs;
  }

  public Order getOrder(Long id){
    Optional<Order> op = orderRepository.findById(id);
    return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
  }

  public Order save(OrderInsertDTO orderInsertDTO){
    Order order = new Order();
    User user = userService.getUser(orderInsertDTO.getUser_id());
    List<Item> items = new ArrayList<>();
    orderInsertDTO.getItems().forEach((e) -> items.add(itemService.save(e)));
    order.setUser(user);
    order.setDate(orderInsertDTO.getDate());
    order.setItems(items);
    Order ord = orderRepository.save(order);
    return ord;
  }

  public Order update(OrderUpdateDTO orderUpdateDTO, Long id){
    Optional<Order> op = orderRepository.findById(id);
    Order ord = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    ord.setDate(orderUpdateDTO.getDate());
    return orderRepository.save(ord);
  }

  public void delete(Long id){
    Optional<Order> op = orderRepository.findById(id);
    op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    orderRepository.delete(op.get());
  }
}
