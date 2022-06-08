package pa.nft.marketplace.dto.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import pa.nft.marketplace.dto.user.UserInfoDTO;
import pa.nft.marketplace.entities.order.Item;
import pa.nft.marketplace.entities.order.Order;

public class OrderDTO {
  
  private Long id;

  private UserInfoDTO user;

  private LocalDateTime date;

  private List<Item> items = new ArrayList<>();

  public OrderDTO(){}

  public OrderDTO(Long id, UserInfoDTO user, LocalDateTime date, List<Item> items) {
    this.id = id;
    this.user = user;
    this.date = date;
    this.items = items;
  }

  public OrderDTO(Order order){
    this.id = order.getId();
    this.date = order.getDate();
    this.user = new UserInfoDTO(order.getUser());
    this.items = order.getItems();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserInfoDTO getUser() {
    return user;
  }

  public void setUser(UserInfoDTO user) {
    this.user = user;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  
}
