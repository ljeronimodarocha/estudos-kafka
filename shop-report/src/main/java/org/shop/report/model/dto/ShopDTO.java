package org.shop.report.model.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ShopDTO {
    @Getter
    @Setter
    private String identifier;

    @Getter
    @Setter
    private String status;
}