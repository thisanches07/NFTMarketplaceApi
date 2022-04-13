package pa.nft.marketplace.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_NFT")
public class Nft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    private boolean is_popular;
    private boolean is_recommended;

    public Nft() {
    }

    public Nft(String name, String description, float price, Integer stars, String img, String location,
            LocalDateTime created_at, LocalDateTime updated_at, int type_id, boolean is_popular,
            boolean is_recommended) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stars = stars;
        this.img = img;
        this.location = location;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.type_id = type_id;
        this.is_popular = is_popular;
        this.is_recommended = is_recommended;
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

    public void setUpdated_at(LocalDateTime ipdated_at) {
        this.updated_at = ipdated_at;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public boolean isIs_popular() {
        return is_popular;
    }

    public void setIs_popular(boolean is_popular) {
        this.is_popular = is_popular;
    }

    public boolean isIs_recommended() {
        return is_recommended;
    }

    public void setIs_recommended(boolean is_recommended) {
        this.is_recommended = is_recommended;
    }

}
