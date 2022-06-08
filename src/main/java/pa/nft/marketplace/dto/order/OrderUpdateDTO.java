package pa.nft.marketplace.dto.order;

import java.util.List;

public class OrderUpdateDTO {

  private List<ItemOrderUpdateDTO> items;

  public OrderUpdateDTO(){}

  public OrderUpdateDTO(List<ItemOrderUpdateDTO> items) {
    this.items = items;
  }

  public List<ItemOrderUpdateDTO> getItems() {
    return items;
  }

  public void setItems(List<ItemOrderUpdateDTO> items) {
    this.items = items;
  }  
}
