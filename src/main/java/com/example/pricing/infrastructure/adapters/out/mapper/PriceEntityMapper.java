package com.example.pricing.infrastructure.adapters.out.mapper;

import com.example.pricing.domain.model.Price;
import com.example.pricing.infrastructure.adapters.out.model.PriceEntity;

import java.util.List;

public class PriceEntityMapper {

  public static Price toDomain(PriceEntity priceEntity) {
    return new Price(
        priceEntity.getPriceId(),
        priceEntity.getBrandId(),
        priceEntity.getStartDate(),
        priceEntity.getEndDate(),
        priceEntity.getPriceList(),
        priceEntity.getProductId(),
        priceEntity.getPriority(),
        priceEntity.getPrice(),
        priceEntity.getCurrency());
  }

  public static List<Price> toDomain(List<PriceEntity> priceEntities) {
    return priceEntities.stream().map(PriceEntityMapper::toDomain).toList();
  }
}
