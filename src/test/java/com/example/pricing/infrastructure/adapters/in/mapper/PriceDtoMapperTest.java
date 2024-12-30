package com.example.pricing.infrastructure.adapters.in.mapper;

import com.example.pricing.domain.model.Price;
import com.example.pricing.infrastructure.adapters.in.dto.PriceResponse;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceDtoMapperTest {

  private final PriceDtoMapper priceDtoMapper = Mappers.getMapper(PriceDtoMapper.class);

  @Test
  void shouldMapDomainToDto() {
    // Given
    final Price price =
        new Price(
            1L, 1L, LocalDateTime.now(), LocalDateTime.now().plusDays(1L), 1, 1L, 1, 1.1, "EUR");

    // When
    final PriceResponse priceResponse = priceDtoMapper.toDto(price);

    // Then
    assertEquals(price.productId(), priceResponse.productId());
    assertEquals(price.brandId(), priceResponse.brandId());
    assertEquals(price.priceList(), priceResponse.priceList());
    assertEquals(price.price(), priceResponse.price());
  }
}
