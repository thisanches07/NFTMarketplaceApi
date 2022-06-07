package pa.nft.marketplace.controllers.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import pa.nft.marketplace.dto.user.UserInfoDTO;
import pa.nft.marketplace.entities.user.User;
import pa.nft.marketplace.infra.service.auth.TokenService;
import pa.nft.marketplace.services.user.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
  
  @Autowired
  private UserService userService;

  @Autowired
  private TokenService tokenService;

  @GetMapping
  public ResponseEntity<List<User>> getUsers(){
    List<User> users = userService.getUsers();
    return ResponseEntity.ok().body(users);
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> getUser(@PathVariable Long id) {
    User user = userService.getUser(id);
    return ResponseEntity.ok().body(user);
  }

  @GetMapping("/info")
  public ResponseEntity<UserInfoDTO> getUserInfo(HttpServletRequest request) {
    String token = request.getHeader("Authorization");
    Long id = tokenService.getTokenId(token.substring(7, token.length()));
    UserInfoDTO userInfoDTO = new UserInfoDTO(userService.getUser(id));
    return ResponseEntity.ok().body(userInfoDTO);
  }

  @PostMapping
  public ResponseEntity<User> create(@Valid @RequestBody User us, HttpServletRequest request, UriComponentsBuilder builder) {
    User user = userService.save(us);
    UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+user.getId()).build();
    return ResponseEntity.created(uriComponents.toUri()).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<User> update(@PathVariable Long id,@Valid @RequestBody User user, HttpServletRequest request, UriComponentsBuilder builder){
    User us = userService.update(id, user);
    return ResponseEntity.ok().body(us);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id){
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}
