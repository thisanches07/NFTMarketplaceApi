package pa.nft.marketplace.repositories.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pa.nft.marketplace.entities.order.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {}
