package com.example.pricing.infrastructure.adapters.in.controller;

import com.example.pricing.application.ports.in.PriceService;
import com.example.pricing.domain.model.Price;
import com.example.pricing.domain.model.PriceMock;
import com.example.pricing.infrastructure.config.ConstantsUrl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

class PriceControllerTest {

  private MockMvc mockMvc;

  @Mock private PriceService priceService;

  private static final String PRICING_API_PATH = ConstantsUrl.V1 + ConstantsUrl.PRICES;
  private static final Long PRODUCT_ID = 1L;
  private static final Long BRAND_ID = 1L;
  private static final LocalDateTime APPLICATION_DATE = LocalDateTime.now();

  @BeforeEach
  void setMockMvc() {
    MockitoAnnotations.openMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(new PriceController(priceService)).build();
  }

  @Test
  void whenGetApplicablePriceWithCorrectData_shouldReturnPriceDetails() throws Exception {
    // Given
    final Price price = PriceMock.mockPrice();

    // When
    when(priceService.getApplicablePrice(anyLong(), anyLong(), any(LocalDateTime.class)))
        .thenReturn(price);

    final ResultActions result =
        mockMvc
            .perform(
                get(PRICING_API_PATH)
                    .param("productId", PRODUCT_ID.toString())
                    .param("brandId", BRAND_ID.toString())
                    .param("applicationDate", APPLICATION_DATE.toString())
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isNotEmpty())
            .andExpect(jsonPath("$.productId").value(PRODUCT_ID));

    // Then
    verify(priceService, times(1))
        .getApplicablePrice(anyLong(), anyLong(), any(LocalDateTime.class));
    assertEquals(result.andReturn().getResponse().getStatus(), HttpStatus.OK.value());
  }

  @Test
  void whenGetApplicablePriceWithMissingParams_shouldReturnBadRequest() throws Exception {
    // When & Then
    mockMvc
        .perform(get(PRICING_API_PATH).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }
}
