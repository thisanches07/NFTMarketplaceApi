package pa.nft.marketplace.infra.service.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import pa.nft.marketplace.entities.user.User;
import pa.nft.marketplace.repositories.user.UserRepository;

@Service
public class AuthenticationService implements UserDetailsService {
  
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> optional = userRepository.findByUsername(username);
    if(optional.isPresent()){
      return optional.get();
    }
    throw new UsernameNotFoundException("User not found");
  }
}
