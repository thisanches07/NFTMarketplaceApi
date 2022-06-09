package pa.nft.marketplace.controllers.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import pa.nft.marketplace.dto.order.ItemInsertDTO;
import pa.nft.marketplace.dto.order.ItemUpdateDTO;
import pa.nft.marketplace.entities.order.Item;
import pa.nft.marketplace.services.order.ItemService;

@RestController
@RequestMapping("/items")
public class ItemController {
  
  @Autowired
  private ItemService itemService;

  @GetMapping
  public ResponseEntity<List<Item>> getItems(){
    return ResponseEntity.ok().body(itemService.getItems());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Item> getItem(@PathVariable Long id){
    Item item = itemService.getItem(id);
    return ResponseEntity.ok().body(item); 
  }

  @PostMapping
  public ResponseEntity<Item> insert(@RequestBody ItemInsertDTO itemInsertDTO, HttpServletRequest request, UriComponentsBuilder builder){
    Item item = itemService.save(itemInsertDTO);
    UriComponents uriComponents = builder.path(request.getRequestURI()+"/"+item.getId()).build();
    return ResponseEntity.created(uriComponents.toUri()).build();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Item> update(@PathVariable Long id, @RequestBody ItemUpdateDTO itemUpdateDTO){
    Item item = itemService.update(itemUpdateDTO, id);
    return ResponseEntity.ok().body(item);
  }

  @DeleteMapping
  public ResponseEntity<Void> delete(@PathVariable Long id){
    itemService.delete(id);
    return ResponseEntity.noContent().build();
  }

}
