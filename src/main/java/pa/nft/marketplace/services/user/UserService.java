package pa.nft.marketplace.services.user;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.nft.marketplace.entities.user.User;
import pa.nft.marketplace.repositories.user.UserRepository;

@Service
public class UserService {
  
  @Autowired
  private UserRepository userRepository;

  public List<User> getUsers(){
    List<User> users = userRepository.findAll();
    return users;
  }

  public User getUser(Long id){
    Optional<User> op = userRepository.findById(id);
    User user =  op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    return user;
  }

  public User save(User user){
      Optional<User> op = userRepository.findByUsername(user.getUsername());
      if(op.isPresent()){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists");
      }
      User us = new User(user);
      BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
      us.setPassword(bcrypt.encode(us.getPassword()));
      return userRepository.save(us);
  }

  public User update(Long id, User user){
    try {
      User us = userRepository.getOne(id);
      us.setName(user.getName());
      us.setUsername(user.getUsername());
      BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
      us.setPassword(bcrypt.encode(user.getPassword()));
      us.setPhone(user.getPhone());
      return userRepository.save(us);
    } catch (EntityNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }

  public void delete(Long id){
    try {
      User us = userRepository.getOne(id);
      userRepository.delete(us);
    } catch (EntityNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found");
    }
  }
}
