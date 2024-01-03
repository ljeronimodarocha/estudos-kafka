package org.shop.report.model.dto;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ShopItemDTO {

    private String productIdentifier;

    private Integer amount;

    private Float price;

}