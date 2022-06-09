package pa.nft.marketplace.dto.order;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class OrderUpdateDTO {

  @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
  private LocalDateTime date;

  public OrderUpdateDTO(){}

  public OrderUpdateDTO(LocalDateTime date) {
    this.date = date;
  }

  public LocalDateTime getDate() {
    return date;
  }

  public void setDate(LocalDateTime date) {
    this.date = date;
  }
}
