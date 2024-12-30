package com.example.pricing.infrastructure.adapters.out.mapper;

import com.example.pricing.domain.model.Price;
import com.example.pricing.infrastructure.adapters.in.dto.PriceResponse;
import com.example.pricing.infrastructure.adapters.out.model.PriceEntity;
import org.junit.jupiter.api.Test;
import org.mapstruct.factory.Mappers;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PriceEntityMapperTest {

  private final PriceEntityMapper priceEntityMapper = Mappers.getMapper(PriceEntityMapper.class);

  @Test
  void shouldMapEntityToDomain() {
    // Given
    final PriceEntity priceEntity =
        new PriceEntity(
            1L, 1L, LocalDateTime.now(), LocalDateTime.now().plusDays(1L), 1, 1L, 1, 1.1, "EUR");

    // When
    final List<Price> prices = priceEntityMapper.toDomain(Collections.singletonList(priceEntity));

    // Then
    assertEquals(prices.get(0).priceId(), priceEntity.getPriceId());
    assertEquals(prices.get(0).brandId(), priceEntity.getBrandId());
    assertEquals(prices.get(0).startDate(), priceEntity.getStartDate());
    assertEquals(prices.get(0).endDate(), priceEntity.getEndDate());
    assertEquals(prices.get(0).priceList(), priceEntity.getPriceList());
    assertEquals(prices.get(0).productId(), priceEntity.getProductId());
    assertEquals(prices.get(0).priority(), priceEntity.getPriority());
    assertEquals(prices.get(0).price(), priceEntity.getPrice());
    assertEquals(prices.get(0).currency(), priceEntity.getCurrency());
  }
}
