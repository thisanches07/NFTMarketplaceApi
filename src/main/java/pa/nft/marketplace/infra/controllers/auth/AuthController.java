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

import pa.nft.marketplace.infra.dto.auth.LoginDTO;
import pa.nft.marketplace.infra.dto.auth.LoginTokenDTO;
import pa.nft.marketplace.infra.service.auth.TokenService;

@RestController
@RequestMapping("/auth")
public class AuthController {
  
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private TokenService tokenService;

  @PostMapping
  public ResponseEntity<LoginTokenDTO> auth(@RequestBody @Valid LoginDTO loginDTO){
    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

    Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

    String token = tokenService.generateToken(authentication);

    LoginTokenDTO loginTokenDTO = new LoginTokenDTO();
    loginTokenDTO.setType("Bearer");
    loginTokenDTO.setToken(token);
    
    return ResponseEntity.ok(loginTokenDTO);
  }
}
