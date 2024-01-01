package org.shop.api.model.dto;

import lombok.Getter;
import lombok.Setter;
import org.shop.api.model.ShopItem;

@Getter
@Setter
public class ShopItemDTO {

    @Getter
    @Setter
    private String productIdentifier;

    @Getter
    @Setter
    private Integer amount;

    @Getter
    @Setter
    private Float price;

    public static ShopItemDTO convert(ShopItem shopItem) {
        ShopItemDTO shopItemDTO = new ShopItemDTO();
        shopItemDTO.setProductIdentifier(
                shopItem.getProductIdentifier());
        shopItemDTO.setAmount(shopItem.getAmount());
        shopItemDTO.setPrice(shopItem.getPrice());
        return shopItemDTO;
    }
}