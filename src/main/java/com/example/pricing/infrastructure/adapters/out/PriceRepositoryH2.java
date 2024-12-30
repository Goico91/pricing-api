package com.example.pricing.infrastructure.adapters.out;

import com.example.pricing.application.ports.out.PriceRepository;
import com.example.pricing.domain.Price;
import com.example.pricing.infrastructure.adapters.out.adapter.PriceDataJpaRepository;
import com.example.pricing.infrastructure.adapters.out.mapper.PriceEntityMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class PriceRepositoryH2 implements PriceRepository {

  private final PriceDataJpaRepository priceDataJpaRepository;

  @Override
  public List<Price> findApplicablePrices(
      final Long productId, final Long brandId, final LocalDateTime applicationDate) {
    return PriceEntityMapper.toDomain(
        priceDataJpaRepository.findApplicablePrices(productId, brandId, applicationDate));
  }
}
