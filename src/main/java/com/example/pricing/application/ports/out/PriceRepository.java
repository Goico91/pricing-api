package com.example.pricing.application.ports.out;

import com.example.pricing.domain.Price;

import java.util.List;

/** Secondary OUT Port for Price repository */
public interface PriceRepository {

  /**
   * Find prices from repository filtered by productId and brandId
   *
   * @param productId long
   * @param brandId long
   * @return {@code List<Price>} list of filtered prices
   */
  List<Price> findPricesByProductAndBrand(Long productId, Long brandId);
}
