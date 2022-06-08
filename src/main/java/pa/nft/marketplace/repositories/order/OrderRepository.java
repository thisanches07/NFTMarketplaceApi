package pa.nft.marketplace.repositories.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pa.nft.marketplace.entities.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
  
}
