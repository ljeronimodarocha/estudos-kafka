package org.shop.report.controller;

import lombok.RequiredArgsConstructor;
import org.shop.report.model.dto.ShopReportDTO;
import org.shop.report.repository.ReportRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/shop_report")
@RequiredArgsConstructor
public class ShopController {
    private final ReportRepository reportRepository;

    @GetMapping
    public List<ShopReportDTO> getShopReport() {
        return reportRepository.findAll()
                .stream()
                .map(ShopReportDTO::convert)
                .collect(Collectors.toList());
    }
}