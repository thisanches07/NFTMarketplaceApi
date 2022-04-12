package pa.nft.marketplace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pa.nft.marketplace.entities.Nft;

import java.util.List;

@Repository
public interface NftRepository extends JpaRepository<Nft, Long> {
    List<Nft> findByIdIn(List<Long> ids);

    @Query("SELECT n FROM Nft n " +
            "WHERE" +
            "(n.is_popular = true)")
    List<Nft> findByPopular();
}
