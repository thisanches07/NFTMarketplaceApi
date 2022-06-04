package pa.nft.marketplace.infra.controllers.auth;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pa.nft.marketplace.entities.user.User;
import pa.nft.marketplace.infra.dto.auth.LoginDTO;
import pa.nft.marketplace.infra.dto.token.TokenDTO;
import pa.nft.marketplace.infra.service.auth.TokenService;
import pa.nft.marketplace.services.user.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {
  
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenService tokenService;

  @Autowired
  private UserService userService;

  @PostMapping("/sign")
  public ResponseEntity<TokenDTO> auth(@RequestBody @Valid LoginDTO loginDTO){
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

    Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    String token = tokenService.generateToken(authentication);

    TokenDTO tokenDTO = new TokenDTO();
    String prefix = "Bearer ";
    
    tokenDTO.setToken(prefix.concat(token));
    
    return ResponseEntity.ok().body(tokenDTO);
  }

   @PostMapping("/register")
  public ResponseEntity<TokenDTO> register(@RequestBody @Valid User user){
    userService.save(user);
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());

    Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    String prefix = "Bearer ";
    String token = tokenService.generateToken(authentication);

    TokenDTO tokenDTO = new TokenDTO();    
    tokenDTO.setToken(prefix.concat(token));

    return ResponseEntity.ok().body(tokenDTO);
  }
}
