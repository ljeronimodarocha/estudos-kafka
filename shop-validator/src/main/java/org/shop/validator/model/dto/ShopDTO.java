package org.shop.validator.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShopDTO {

    private String identifier;

    private LocalDate dateShop;

    private String status;

    private String buyerIdentifier;

    private List<ShopItemDTO> items = new ArrayList<>();
}