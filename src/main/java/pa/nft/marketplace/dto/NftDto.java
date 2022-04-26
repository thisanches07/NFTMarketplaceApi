package pa.nft.marketplace.dto;

import java.time.LocalDateTime;

import pa.nft.marketplace.entities.Nft;

public class NftDto {
    private Long id;
    private String name;
    private String description;
    private float price;
    private Integer stars;
    private String img;
    private String location;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;
    private int type_id;

    public NftDto() {
    }

    public NftDto(Nft nft) {
        this.id = nft.getId();
        this.name = nft.getName();
        this.description = nft.getDescription();
        this.price = nft.getPrice();
        this.stars = nft.getStars();
        this.img = nft.getImg();
        this.location = nft.getLocation();
        this.created_at = nft.getCreated_at();
        this.updated_at = nft.getUpdated_at();
        this.type_id = nft.getType_id();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

}
