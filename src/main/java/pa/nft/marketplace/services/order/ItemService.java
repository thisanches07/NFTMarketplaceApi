package pa.nft.marketplace.services.order;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.nft.marketplace.dto.order.ItemInsertDTO;
import pa.nft.marketplace.entities.nft.Nft;
import pa.nft.marketplace.entities.order.Item;
import pa.nft.marketplace.repositories.order.ItemRepository;
import pa.nft.marketplace.services.nft.NftService;

@Service
public class ItemService {
  
  @Autowired
  private ItemRepository itemRepository;

  @Autowired
  private NftService nftService;


  public List<Item> getItems(){
    return itemRepository.findAll();
  }

  public Item getItem(Long id){
    Optional<Item> op = itemRepository.findById(id);
    return op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found"));
  }

  public Item save(ItemInsertDTO itemInsertDTO) {
    Nft nft = nftService.getNft(itemInsertDTO.getNft_id());
    Item item = new Item();
    item.setNft(nft);
    item.setAmount(itemInsertDTO.getAmount());
    item.setQuantity(itemInsertDTO.getQuantity());
    return itemRepository.save(item);
  }

  public Item update(ItemInsertDTO itemInsertDTO, Long id){
    Item item = getItem(id);
    Nft nft = nftService.getNft(id);
    item.setNft(nft);
    item.setAmount(itemInsertDTO.getAmount());
    item.setQuantity(itemInsertDTO.getQuantity());
    item = itemRepository.save(item);
    return item;
  }

  public void delete(Long id){
    itemRepository.deleteById(id);
  }
}
