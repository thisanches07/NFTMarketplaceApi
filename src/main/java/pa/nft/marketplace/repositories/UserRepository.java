package pa.nft.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pa.nft.marketplace.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
