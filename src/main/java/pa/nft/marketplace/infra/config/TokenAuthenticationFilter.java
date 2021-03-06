package pa.nft.marketplace.infra.config;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import pa.nft.marketplace.entities.user.User;
import pa.nft.marketplace.infra.service.auth.TokenService;
import pa.nft.marketplace.repositories.user.UserRepository;

public class TokenAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private TokenService tokenService;

  public TokenAuthenticationFilter(TokenService tokenService, UserRepository userRepository){
    this.tokenService = tokenService;
    this.userRepository = userRepository;
  }
  
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    
    String tokenFromHeader = getTokenFromHeader(request);
    boolean tokenValid = tokenService.isTokenValid(tokenFromHeader);
    if(tokenValid){
      this.authenticate(tokenFromHeader);
    }
    
    filterChain.doFilter(request, response);
  }

  private void authenticate(String tokenFromHeader){
    Long id = tokenService.getTokenId(tokenFromHeader);

    Optional<User> optionalUser = userRepository.findById(id);
    
    if(optionalUser.isPresent()){
      User user = optionalUser.get();

      UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user, null, user.getRoles());
      SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }
  }

  private String getTokenFromHeader(HttpServletRequest request){
    String token = request.getHeader("Authorization");
    if(token == null || token.isEmpty() || !token.startsWith("Bearer ")){
      return null;
    }
    return token.substring(7, token.length());
  }
}
