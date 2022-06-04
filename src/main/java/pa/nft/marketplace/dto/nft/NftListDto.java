package pa.nft.marketplace.dto.nft;

import java.util.ArrayList;
import java.util.List;

import pa.nft.marketplace.entities.nft.Nft;

public class NftListDto {
    private int total_size;
    private int type_id;
    private int offset;
    private List<NftDto> nfts;

    public NftListDto(int total_size, int type_id, List<Nft> nfts) {
        setTotal_size(nfts.size());
        setType_id(2);
        setOffset(0);
        List<NftDto> list = new ArrayList<>();
        nfts.forEach(nft -> list.add(new NftDto(nft)));
        setNfts(list);
    }

    public int getTotal_size() {
        return total_size;
    }

    public void setTotal_size(int total_size) {
        this.total_size = total_size;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public List<NftDto> getNfts() {
        return nfts;
    }

    public void setNfts(List<NftDto> nfts) {
        this.nfts = nfts;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

}
