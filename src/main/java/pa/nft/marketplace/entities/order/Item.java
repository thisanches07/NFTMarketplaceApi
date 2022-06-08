package pa.nft.marketplace.entities.order;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import pa.nft.marketplace.entities.nft.Nft;

@Entity
@Table(name = "TB_ITEM")
public class Item implements Serializable {
  
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @ManyToOne
  @JoinColumn(name = "NFT_ID")
  private Nft nft;
  
  private float amount;
  
  private int quantity;

  public Item(){}

  public Item(Long id, Nft nft, float amount, int quantity) {
    this.id = id;
    this.nft = nft;
    this.amount = amount;
    this.quantity = quantity;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Nft getNft() {
    return nft;
  }

  public void setNft(Nft nft) {
    this.nft = nft;
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
