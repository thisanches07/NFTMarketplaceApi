package pa.nft.marketplace.infra.dto.auth;

public class LoginTokenDTO {
  
  private String type;
  private String token;

  public LoginTokenDTO(String type, String token) {
    this.type = type;
    this.token = token;
  }

  public LoginTokenDTO(){}

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  
}
