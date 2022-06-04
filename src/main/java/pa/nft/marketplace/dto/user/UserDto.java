package pa.nft.marketplace.dto.user;

import pa.nft.marketplace.entities.user.User;

public class UserDto {
  
  private String name;
  private String username;
  private String phone;

  public UserDto() {}

  public UserDto(String name, String email, String phone) {
    this.name = name;
    this.username = email;
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

  public String getEmail() {
    return username;
  }

  public void setEmail(String email) {
    this.username = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
}
