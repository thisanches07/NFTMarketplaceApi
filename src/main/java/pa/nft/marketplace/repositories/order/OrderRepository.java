package pa.nft.marketplace.repositories.order;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pa.nft.marketplace.entities.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  
  @Query("SELECT o FROM Order o WHERE o.user_id = ?1")
  List<Order> findAllWhereUserId(Long user_id);
}
