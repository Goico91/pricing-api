package com.example.pricing.infrastructure.adapters.in.mapper;

import com.example.pricing.domain.model.Price;
import com.example.pricing.domain.model.PriceMock;
import com.example.pricing.infrastructure.adapters.in.dto.PriceResponse;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PriceDtoMapperTest {

  private final PriceDtoMapper priceDtoMapper = Mappers.getMapper(PriceDtoMapper.class);

  @Test
  void shouldMapDomainToDto() {
    // Given
    final Price price = PriceMock.mockPrice();

    // When
    final PriceResponse priceResponse = priceDtoMapper.toDto(price);

    // Then
    assertEquals(price.productId(), priceResponse.productId());
    assertEquals(price.brandId(), priceResponse.brandId());
    assertEquals(price.priceList(), priceResponse.priceList());
    assertEquals(price.price(), priceResponse.price());
  }
}
