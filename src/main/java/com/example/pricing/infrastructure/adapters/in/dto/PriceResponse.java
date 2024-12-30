package com.example.pricing.infrastructure.adapters.in.dto;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

public record PriceResponse(
    @Schema(example = "35455") Long productId,
    @Schema(example = "1") Long brandId,
    @Schema(example = "1") Integer priceList,
    @Schema(example = "2020-06-14T00:00:00") LocalDateTime startDate,
    @Schema(example = "2020-06-14T00:00:00") LocalDateTime endDate,
    @Schema(example = "35.5") Double price) {}
