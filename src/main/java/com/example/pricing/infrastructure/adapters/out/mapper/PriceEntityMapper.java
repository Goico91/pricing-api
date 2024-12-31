package com.example.pricing.infrastructure.adapters.out.mapper;

import com.example.pricing.domain.model.Price;
import com.example.pricing.infrastructure.adapters.out.model.PriceEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceEntityMapper {
  PriceEntityMapper INSTANCE = Mappers.getMapper(PriceEntityMapper.class);

  Price toDomain(PriceEntity priceEntity);

  List<Price> toDomain(List<PriceEntity> priceEntities);
}
