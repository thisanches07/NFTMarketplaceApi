package pa.nft.marketplace.entities.order;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import pa.nft.marketplace.entities.user.User;

@Entity
@Table(name = "TB_ORDER")
public class Order implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "USER_ID")
  private User user;

  private LocalDateTime date;

  @OneToMany(cascade = CascadeType.ALL)
  @JoinColumn(name = "ORDER_ID")
  private List<Item> items = new ArrayList<>();

  public Order(){}

  public Order(Long id, User user, LocalDateTime date, List<Item> items) {
    this.id = id;
    this.user = user;
    this.date = date;
    this.items = items;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LocalDateTime getDate(){
    return date;
  }

  public void setDate(LocalDateTime date){
    this.date = date;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }
}
