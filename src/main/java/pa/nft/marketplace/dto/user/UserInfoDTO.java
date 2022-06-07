package pa.nft.marketplace.dto.user;

import pa.nft.marketplace.entities.user.User;

public class UserInfoDTO {
  
  private Long id;
  private String name;
  private String username;
  private String phone;

  public UserInfoDTO() {}

  public UserInfoDTO(Long id, String name, String username, String phone) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.phone = phone;
  }

  public UserInfoDTO(User user){
    this.id = user.getId();
    this.name = user.getName();
    this.username = user.getUsername();
    this.phone = user.getPhone();
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

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
