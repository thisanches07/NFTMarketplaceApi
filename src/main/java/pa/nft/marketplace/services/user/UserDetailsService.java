package pa.nft.marketplace.services.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {

  UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
