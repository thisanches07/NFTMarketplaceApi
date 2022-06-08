package pa.nft.marketplace.dto.order;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderInsertDTO {
  
  private Long user_id;

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime date;

  public OrderInsertDTO(){}

  public OrderInsertDTO(Long user_id, LocalDateTime date) {
    this.user_id = user_id;
    this.date = date;
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
}
