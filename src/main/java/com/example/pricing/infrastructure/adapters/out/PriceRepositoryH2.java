package com.example.pricing.infrastructure.adapters.out;

import com.example.pricing.application.ports.out.PriceRepository;
import com.example.pricing.domain.Price;
import com.example.pricing.infrastructure.adapters.out.adapter.PriceDataJpaRepository;
import com.example.pricing.infrastructure.adapters.out.mapper.PriceEntityMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PriceRepositoryH2 implements PriceRepository {

  private final PriceDataJpaRepository priceDataJpaRepository;

  public PriceRepositoryH2(final PriceDataJpaRepository priceDataJpaRepository) {
    this.priceDataJpaRepository = priceDataJpaRepository;
  }

  @Override
  public List<Price> findPricesByProductAndBrand(Long productId, Long brandId) {
    return PriceEntityMapper.toDomain(priceDataJpaRepository.findAll());
  }
}
