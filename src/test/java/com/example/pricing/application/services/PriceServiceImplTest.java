package com.example.pricing.application.services;

import com.example.pricing.application.ports.out.PriceRepository;
import com.example.pricing.domain.exception.PriceNotFoundException;
import com.example.pricing.domain.model.Price;
import com.example.pricing.domain.model.PriceMock;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

class PriceServiceImplTest {

  private static final Long PRODUCT_ID = 1L;
  private static final Long BRAND_ID = 1L;
  private static final LocalDateTime APPLICATION_DATE = LocalDateTime.now();

  @Mock private PriceRepository priceRepository;
  @InjectMocks private PriceServiceImpl priceService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void whenGetApplicablePriceWithCorrectData_shouldReturnPrice() {
    // Given
    final Price price = PriceMock.mockPrice();

    when(priceRepository.findApplicablePrices(anyLong(), anyLong(), any(LocalDateTime.class)))
        .thenReturn(List.of(price));

    // When
    final Price result = priceService.getApplicablePrice(PRODUCT_ID, BRAND_ID, APPLICATION_DATE);

    // Then
    verify(priceRepository, times(1))
        .findApplicablePrices(anyLong(), anyLong(), any(LocalDateTime.class));
    assertNotNull(result);
    assertEquals(price.productId(), result.productId());
  }

  @Test
  void whenGetApplicablePriceWithNotFoundProduct_shouldThrowPriceNotFoundException() {
    // Given
    when(priceRepository.findApplicablePrices(anyLong(), anyLong(), any(LocalDateTime.class)))
        .thenReturn(new ArrayList<>());

    // When
    final PriceNotFoundException exception =
        assertThrows(
            PriceNotFoundException.class,
            () -> priceService.getApplicablePrice(PRODUCT_ID, BRAND_ID, APPLICATION_DATE));

    // Then
    verify(priceRepository, times(1))
        .findApplicablePrices(anyLong(), anyLong(), any(LocalDateTime.class));
    assertEquals("Price not found for productId: " + PRODUCT_ID, exception.getMessage());
  }
}
