package org.shop.api.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.shop.api.model.Shop;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ShopDTO {

    @Getter
    @Setter
    private String identifier;

    @Getter
    @Setter
    private LocalDate dateShop;

    @Getter
    @Setter
    private String status;

    @Getter
    @Setter
    private List<ShopItemDTO> items = new ArrayList<>();
    public static ShopDTO convert(Shop shop) {
        ShopDTO shopDTO = new ShopDTO();
        shopDTO.setIdentifier(shop.getIdentifier());
        shopDTO.setDateShop(shop.getDateShop());
        shopDTO.setStatus(shop.getStatus());
        shopDTO.setItems(shop
                .getItems()
                .stream()
                .map(ShopItemDTO::convert)
                .collect(Collectors.toList()));
        return shopDTO;
    }
}