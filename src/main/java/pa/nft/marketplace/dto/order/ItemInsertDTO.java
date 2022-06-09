package pa.nft.marketplace.dto.order;

public class ItemInsertDTO {
  
  private Long nft_id;
  private float amount;
  private int quantity;

  public ItemInsertDTO(){}

  public ItemInsertDTO(Long nft_id, float amount, int quantity) {
    this.nft_id = nft_id;
    this.amount = amount;
    this.quantity = quantity;
  }

  public Long getNft_id() {
    return nft_id;
  }

  public void setNft_id(Long nft_id) {
    this.nft_id = nft_id;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  
}
