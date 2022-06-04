package pa.nft.marketplace.entities.user;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "TB_USER")
public class User implements UserDetails {

  private static final long serialVersionUID = 1L;
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotNull(message = "The name cannot be null")
  private String name;
  
  @Email(message = "This value should be username")
  @NotNull(message = "The email cannot be null")
  @Column(unique = true)
  private String username;
  
  @NotNull(message = "The password cannot be null")
  private String password;
  
  @NotNull(message = "The phone cannot be null")
  private String phone;

  @ManyToMany(fetch = FetchType.EAGER)
  private Set<Role> roles;

  public User() {}

  public User(User user) {
    this.id = user.getId();
    this.name = user.getName();
    this.username = user.getUsername();
    this.password = user.getPassword();
    this.phone = user.getPhone();
  }

  public User(
    Long id,
    String name,
    String username,
    String password,
    String phone
  ) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
    this.phone = phone;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }
  

  public Set<Role> getRoles() {
    return roles;
  }

  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }

  public Collection<? extends GrantedAuthority> getAuthorities(){
    return this.roles;
  }
  
  public boolean isAccountNonExpired(){
    return true;
  }

  public boolean isAccountNonLocked(){
    return true;
  }

  public boolean isCredentialsNonExpired(){
    return true;
  }

  public boolean isEnabled() {
    return true;
  } 
}
