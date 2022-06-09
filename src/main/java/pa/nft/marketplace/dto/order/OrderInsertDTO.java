package pa.nft.marketplace.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderInsertDTO {
  
  private Long user_id;
  
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime date;
  
  private List<ItemInsertDTO> items;

  public OrderInsertDTO(){}

  public OrderInsertDTO(Long user_id, LocalDateTime date, List<ItemInsertDTO> items) {
    this.user_id = user_id;
    this.date = date;
    this.items = items;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public LocalDateTime getDate(){
    return date;
  }

  public void setDate(LocalDateTime date){
    this.date = date;
  }

  public List<ItemInsertDTO> getItems() {
    return items;
  }

  public void setItems(List<ItemInsertDTO> items) {
    this.items = items;
  }
}
