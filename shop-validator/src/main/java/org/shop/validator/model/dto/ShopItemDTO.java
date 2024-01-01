package org.shop.validator.model.dto;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
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

}