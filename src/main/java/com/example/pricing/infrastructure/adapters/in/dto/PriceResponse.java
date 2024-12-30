package com.example.pricing.infrastructure.adapters.in.dto;

import java.time.LocalDateTime;

public record PriceResponse(
    Long productId,
    Long brandId,
    Integer priceList,
    LocalDateTime startDate,
    LocalDateTime endDate,
    Double price) {}
