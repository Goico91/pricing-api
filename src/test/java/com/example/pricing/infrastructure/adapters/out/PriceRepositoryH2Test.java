package com.example.pricing.infrastructure.adapters.out;

import com.example.pricing.domain.model.Price;
import com.example.pricing.domain.model.PriceMock;
import com.example.pricing.infrastructure.adapters.out.adapter.PriceDataJpaRepository;
import com.example.pricing.infrastructure.adapters.out.model.PriceEntity;
import com.example.pricing.infrastructure.adapters.out.model.PriceEntityMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

class PriceRepositoryH2Test {

  private static final Long PRODUCT_ID = 1L;
  private static final Long BRAND_ID = 1L;
  private static final LocalDateTime APPLICATION_DATE = LocalDateTime.now();

  @Mock private PriceDataJpaRepository priceDataJpaRepository;
  @InjectMocks private PriceRepositoryH2 priceRepositoryH2;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void whenFindApplicablePricesWithExistingPrice_shouldReturnApplicablePrices() {
    // Given
    final List<PriceEntity> priceEntities = List.of(PriceEntityMock.mockPrice());
    final List<Price> prices = List.of(PriceMock.mockPrice());

    when(priceDataJpaRepository.findApplicablePrices(
            anyLong(), anyLong(), any(LocalDateTime.class)))
        .thenReturn(priceEntities);

    // When
    final List<Price> result =
        priceRepositoryH2.findApplicablePrices(PRODUCT_ID, BRAND_ID, APPLICATION_DATE);

    // Then
    assertNotNull(result);
    assertEquals(prices.size(), result.size());
    assertEquals(prices.get(0), result.get(0));
    verify(priceDataJpaRepository, times(1))
        .findApplicablePrices(anyLong(), anyLong(), any(LocalDateTime.class));
  }

  @Test
  void whenFindApplicablePricesWithNotFoundPrice_shouldReturnEmptyList() {
    // Given
    when(priceDataJpaRepository.findApplicablePrices(
            anyLong(), anyLong(), any(LocalDateTime.class)))
        .thenReturn(List.of());

    // When
    final List<Price> result =
        priceRepositoryH2.findApplicablePrices(PRODUCT_ID, BRAND_ID, APPLICATION_DATE);

    // Then
    assertNotNull(result);
    assertTrue(result.isEmpty());
    verify(priceDataJpaRepository, times(1))
        .findApplicablePrices(anyLong(), anyLong(), any(LocalDateTime.class));
  }
}
