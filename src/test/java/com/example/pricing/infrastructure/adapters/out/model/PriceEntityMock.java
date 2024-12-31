package com.example.pricing.infrastructure.adapters.out.model;

import java.time.LocalDateTime;

public class PriceEntityMock {

  public static PriceEntity mockPrice() {
    return PriceEntity.builder()
        .priceId(1L)
        .brandId(1L)
        .startDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59))
        .endDate(LocalDateTime.of(2020, 12, 31, 23, 59, 59).plusDays(1L))
        .priceList(1)
        .productId(1L)
        .priority(1)
        .price(10.0)
        .currency("EUR")
        .build();
  }
}
