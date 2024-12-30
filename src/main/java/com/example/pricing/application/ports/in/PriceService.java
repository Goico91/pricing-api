package com.example.pricing.application.ports.in;

import com.example.pricing.domain.model.Price;

import java.time.LocalDateTime;

/** Primary IN Port for Price entity */
public interface PriceService {

  /**
   * Method to get a specific price filtered by productId, brandId and date
   *
   * @param productId Long
   * @param brandId Long
   * @param applicationDate LocalDateTime
   * @return Price
   */
  Price getApplicablePrice(
      final Long productId, final Long brandId, final LocalDateTime applicationDate);
}
