package pa.nft.marketplace.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.nft.marketplace.entities.User;
import pa.nft.marketplace.repositories.UserRepository;

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
    User us = userRepository.save(user);
    return us;
  }

  public User update(Long id, User user){
    try {
      User us = userRepository.getOne(id);
      us.setName(user.getName());
      us.setEmail(user.getEmail());
      us.setPassword(user.getPassword());
      us.setPhone(user.getPhone());
      us = userRepository.save(us);
      return us;
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
