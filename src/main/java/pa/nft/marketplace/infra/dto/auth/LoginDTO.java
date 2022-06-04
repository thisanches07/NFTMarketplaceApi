package pa.nft.marketplace.infra.dto.auth;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import pa.nft.marketplace.entities.user.User;

public class LoginDTO {
  
  @Email(message = "This value should be email")
  @NotNull(message = "The email cannot be null")
  private String username;
  
  @NotNull(message = "The password cannot be null")
  private String password;

  public LoginDTO(String username, String password) {
    this.username = username;
    this.password = password;
  }

  public LoginDTO() {}

  public LoginDTO(User user){
    this.username = user.getUsername();
    this.password = user.getPassword();
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  
}
