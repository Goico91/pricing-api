package com.example.pricing.infrastructure.adapters.in.mapper;

import com.example.pricing.domain.model.Price;
import com.example.pricing.infrastructure.adapters.in.dto.PriceResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceDtoMapper {
  PriceResponse toDto(final Price price);
}
