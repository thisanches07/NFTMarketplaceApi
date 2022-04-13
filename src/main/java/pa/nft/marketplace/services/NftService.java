package pa.nft.marketplace.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import pa.nft.marketplace.dto.NftDto;
import pa.nft.marketplace.dto.NftListDto;
import pa.nft.marketplace.dto.NftUpdateDto;
import pa.nft.marketplace.entities.Nft;
import pa.nft.marketplace.repositories.NftRepository;

@Service
public class NftService {

    @Autowired
    NftRepository nftRepository;

    public List<Nft> getNfts() {
        return nftRepository.findAll();
    }

    public NftDto insertNft(Nft nft) {
        nftRepository.save(nft);
        return new NftDto(nft);
    }

    public NftListDto getPopularNfts() {

        List<Nft> list = nftRepository.findByPopular();
        return new NftListDto(list.size(), 2, list);
    }

    public NftDto update(@Valid NftUpdateDto nftUpdateDto, long id) {
        try {
            Nft nft = nftRepository.getOne(id);
            nft.setName(nftUpdateDto.getName());
            nft.setDescription(nftUpdateDto.getDescription());
            nft.setPrice(nftUpdateDto.getPrice());
            nft.setStars(nftUpdateDto.getStars());
            nft.setImg(nftUpdateDto.getImg());
            nft.setLocation(nftUpdateDto.getLocation());
            nft.setCreated_at(nftUpdateDto.getCreated_at());
            nft.setUpdated_at(nftUpdateDto.getUpdated_at());
            nft.setType_id(nftUpdateDto.getType_id());
            nft.setIs_popular(nftUpdateDto.getIs_popular());
            nftRepository.save(nft);
            return new NftDto(nft);
        } catch (EntityNotFoundException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Nft not found");
        }
    }

    public NftDto getNftById(long id) {
        Optional<Nft> op = nftRepository.findById(id);
        Nft nft = op.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Nft não está cadastrada!"));
        return new NftDto(nft);
    }

    public NftListDto getRecommendedNfts() {
        List<Nft> list = nftRepository.findByRecommendation();
        return new NftListDto(list.size(), 2, list);
    }
}
