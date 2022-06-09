package pa.nft.marketplace.controllers.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import pa.nft.marketplace.dto.order.OrderDTO;
import pa.nft.marketplace.dto.order.OrderInsertDTO;
import pa.nft.marketplace.dto.order.OrderUpdateDTO;
import pa.nft.marketplace.entities.order.Order;
import pa.nft.marketplace.infra.service.auth.TokenService;
import pa.nft.marketplace.services.order.OrderService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/orders")
public class OrderController {
  
  @Autowired
  private OrderService orderService;

  @Autowired
  private TokenService tokenService;

  @GetMapping
  public ResponseEntity<List<OrderDTO>> getOrders(HttpServletRequest request){
    String token = getTokenFromHeader(request);
    Long user_id = tokenService.getTokenId(token);
    return ResponseEntity.ok().body(orderService.getOrders(user_id));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Order> getOrder(@PathVariable Long id){
    Order order = orderService.getOrder(id);
    return ResponseEntity.ok().body(order);
  }

  @PostMapping
  public ResponseEntity<Order> insert(@RequestBody OrderInsertDTO orderInsertDTO, HttpServletRequest request, UriComponentsBuilder builder) {
      Order order = orderService.save(orderInsertDTO);
      System.out.println("test - " + order.toString());
      UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+order.getId()).build();
      return ResponseEntity.created(uriComponents.toUri()).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Order> update(@PathVariable Long id, @RequestBody OrderUpdateDTO order){
      Order ord = orderService.update(order, id);
      return ResponseEntity.ok().body(ord);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
      orderService.delete(id);
      return ResponseEntity.noContent().build();
  }

  private String getTokenFromHeader(HttpServletRequest request){
    String token = request.getHeader("Authorization");
    if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
      return null;
    }
    return token.substring(7, token.length());
  }
}
