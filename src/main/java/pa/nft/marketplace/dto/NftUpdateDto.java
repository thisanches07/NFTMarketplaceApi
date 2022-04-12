package pa.nft.marketplace.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class NftUpdateDto {
    @NotEmpty(message = "A arte deve possuir um nome")
    private String name;
    @NotEmpty(message = "A arte deve possuir uma descrição")
    private String description;

    @NotNull(message = "A arte deve possuir um preço")
    private float price;

    @NotNull(message = "A arte deve possuir uma quantidade de estrelas")
    private Integer stars;

    @NotEmpty(message = "A arte deve possuir um link de imagem")
    private String img;

    @NotEmpty(message = "A arte deve possuir uma localidade")
    private String location;

    @NotNull(message = "A arte deve possuir uma data de criação")
    private LocalDateTime created_at;

    @NotNull(message = "A arte deve possuir uma data de atualização")
    private LocalDateTime updated_at;

    @NotNull(message = "A arte deve possuir um tipo de id")
    private int type_id;

    @NotNull(message = "É preciso informar se a arte é popular")
    private boolean is_popular;

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

    public boolean getIs_popular() {
        return is_popular;
    }

    public void setIs_popular(boolean is_popular) {
        this.is_popular = is_popular;
    }

}
