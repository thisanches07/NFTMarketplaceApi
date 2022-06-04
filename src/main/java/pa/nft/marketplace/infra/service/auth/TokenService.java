package pa.nft.marketplace.infra.service.auth;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import pa.nft.marketplace.entities.user.User;

@Service
public class TokenService {
  
  @Value("${jwt.expiration}")
  private String expiration;

  @Value("${jwt.secret}")
  private String secret;

  public String generateToken(Authentication authentication){
    User user = (User) authentication.getPrincipal();

    Date now = new Date();
    Date exp = new Date(now.getTime() + Long.parseLong(expiration));

    return Jwts.builder().setIssuer("NFTMarketplaceApi")
                          .setSubject(user.getId().toString())
                          .setIssuedAt(new Date())
                          .setExpiration(exp)
                          .signWith(SignatureAlgorithm.HS256, secret).compact();
  }

  public Boolean isTokenValid(String token){
    try {
      Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
      return true;
    } catch (Exception e){
      return false;
    }
  }

  public Long getTokenId(String token){
    Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
    return Long.valueOf(body.getSubject());
  }
}
