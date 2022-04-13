package pa.nft.marketplace.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pa.nft.marketplace.dto.NftDto;
import pa.nft.marketplace.dto.NftListDto;
import pa.nft.marketplace.dto.NftUpdateDto;
import pa.nft.marketplace.entities.Nft;
import pa.nft.marketplace.services.NftService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/nfts")
public class NftController {
  @Autowired
  NftService nftService;

  @GetMapping
  public ResponseEntity<?> getNfts() {
    List<Nft> list = nftService.getNfts();
    return ResponseEntity.ok(list);
  }

  @GetMapping("/{id}")
  public ResponseEntity<NftDto> getEventById(@PathVariable long id) {
    NftDto dto = nftService.getNftById(id);
    return ResponseEntity.ok(dto);
  }

  @PostMapping
  public ResponseEntity<?> postNft(@RequestBody Nft nft) {
    NftDto dto = nftService.insertNft(nft);
    return ResponseEntity.ok(dto);
  }

  @GetMapping("/popular")
  public ResponseEntity<?> getPopularNfts() {
    NftListDto response = nftService.getPopularNfts();
    return ResponseEntity.ok(response);
  }

  @GetMapping("/recommended")
  public ResponseEntity<?> getRecommendedNfts() {
    NftListDto response = nftService.getRecommendedNfts();
    return ResponseEntity.ok(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<?> update(@RequestBody NftUpdateDto nftUpdateDto,
      @PathVariable long id) {
    NftDto nft = nftService.update(nftUpdateDto, id);
    return ResponseEntity.ok(nft);
  }

}
