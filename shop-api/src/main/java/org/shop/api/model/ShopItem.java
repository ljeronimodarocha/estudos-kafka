package org.shop.api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.shop.api.model.dto.ShopItemDTO;


@Getter
@Setter
@Entity(name = "shop_item")
public class ShopItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = "product_identifier")
    private String productIdentifier;

    @Getter
    @Setter
    private Integer amount;

    @Getter
    @Setter
    private Float price;

    @Getter
    @Setter
    @ManyToOne
    @JoinColumn(name = "shop_id")
    private Shop shop;
    public static ShopItem convert(ShopItemDTO shopItemDTO) {
        ShopItem shopItem = new ShopItem();
        shopItem.setProductIdentifier(
                shopItemDTO.getProductIdentifier());
        shopItem.setAmount(shopItemDTO.getAmount());
        shopItem.setPrice(shopItemDTO.getPrice());return shopItem;
    }
}
