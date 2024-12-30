package com.example.pricing.application.ports.out;

import com.example.pricing.domain.Price;

import java.time.LocalDateTime;
import java.util.List;

/** Secondary OUT Port for Price repository */
public interface PriceRepository {

  /**
   * Find prices from repository filtered by productId, brandId and date
   *
   * @param productId Long
   * @param brandId Long
   * @param applicationDate LocalDateTime
   * @return {@code List<Price>} list of filtered prices
   */
  List<Price> findApplicablePrices(
      final Long productId, final Long brandId, final LocalDateTime applicationDate);
}
