package org.shop.api.model;

import lombok.Getter;
import lombok.Setter;
import org.shop.api.model.dto.ShopDTO;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String identifier;

    private String status;

    @Column(name = "date_shop")
    private LocalDate dateShop;

    @Column(name = "buyer_identifier")
    private String buyerIdentifier;

    @OneToMany(fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            mappedBy = "shop")
    private List<ShopItem> items;public static Shop convert(ShopDTO shopDTO) {
        Shop shop = new Shop();
        shop.setIdentifier(shopDTO.getIdentifier());
        shop.setStatus(shopDTO.getStatus());
        shop.setDateShop(shopDTO.getDateShop());
        shop.setBuyerIdentifier(shopDTO.getBuyerIdentifier());
        shop.setItems(shopDTO
                .getItems()
                .stream()
                .map(ShopItem::convert)
                .collect(Collectors.toList()));
        return shop;
    }
}
