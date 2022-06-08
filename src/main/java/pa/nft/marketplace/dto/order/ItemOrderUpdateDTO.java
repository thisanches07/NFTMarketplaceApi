package pa.nft.marketplace.dto.order;

public class ItemOrderUpdateDTO {
  
  private Long id;

  public ItemOrderUpdateDTO(){}

  public ItemOrderUpdateDTO(Long id) {
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }
}
