package com.example.pricing.infrastructure.adapters.in.mapper;

import com.example.pricing.domain.model.Price;
import com.example.pricing.infrastructure.adapters.in.dto.PriceResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {
  PriceDtoMapper INSTANCE = Mappers.getMapper(PriceDtoMapper.class);

  PriceResponse toDto(final Price price);
}
