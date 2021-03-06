package pa.nft.marketplace.dto.user;

import pa.nft.marketplace.entities.user.User;

public class UserDto {
  
  private String name;
  private String username;
  private String phone;

  public UserDto() {}

  public UserDto(String name, String username, String phone) {
    this.name = name;
    this.username = username;
    this.phone = phone;
  }

  public UserDto(User user){
    this.name = user.getName();
    this.username = user.getUsername();
    this.phone = user.getPhone();
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
