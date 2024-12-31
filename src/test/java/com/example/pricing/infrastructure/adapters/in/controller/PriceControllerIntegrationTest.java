package com.example.pricing.infrastructure.adapters.in.controller;

import com.example.pricing.infrastructure.config.ConstantsUrl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PriceControllerIntegrationTest {

  private static final String PRICING_API_PATH = ConstantsUrl.V1 + ConstantsUrl.PRICES;
  private static final Long PRODUCT_ID = 35455L;
  private static final Long BRAND_ID = 1L;

  @Autowired private MockMvc mockMvc;

  /** Test for case Test 1: petición a las 10:00 del día 14 del producto 35455 para la brand 1 */
  @Test
  public void testCase1_GetApplicablePrice() throws Exception {
    // When & Then
    mockMvc
        .perform(
            get(PRICING_API_PATH)
                .param("productId", PRODUCT_ID.toString())
                .param("brandId", BRAND_ID.toString())
                .param("applicationDate", "2020-06-14T10:00:00")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty())
        .andExpect(jsonPath("$.productId").value(PRODUCT_ID.toString()))
        .andExpect(jsonPath("$.brandId").value(BRAND_ID.toString()))
        .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
        .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
        .andExpect(jsonPath("$.price").value(35.5));
  }

  /** Test for case Test 2: petición a las 16:00 del día 14 del producto 35455 para la brand 1 */
  @Test
  public void testCase2_GetApplicablePrice() throws Exception {
    // When & Then
    mockMvc
        .perform(
            get(PRICING_API_PATH)
                .param("productId", PRODUCT_ID.toString())
                .param("brandId", BRAND_ID.toString())
                .param("applicationDate", "2020-06-14T16:00:00")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty())
        .andExpect(jsonPath("$.productId").value(PRODUCT_ID.toString()))
        .andExpect(jsonPath("$.brandId").value(BRAND_ID.toString()))
        .andExpect(jsonPath("$.startDate").value("2020-06-14T15:00:00"))
        .andExpect(jsonPath("$.endDate").value("2020-06-14T18:30:00"))
        .andExpect(jsonPath("$.price").value(25.45));
  }

  /** Test for case Test 3: petición a las 21:00 del día 14 del producto 35455 para la brand 1 */
  @Test
  public void testCase3_GetApplicablePrice() throws Exception {
    // When & Then
    mockMvc
        .perform(
            get(PRICING_API_PATH)
                .param("productId", PRODUCT_ID.toString())
                .param("brandId", BRAND_ID.toString())
                .param("applicationDate", "2020-06-14T21:00:00")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty())
        .andExpect(jsonPath("$.productId").value(PRODUCT_ID.toString()))
        .andExpect(jsonPath("$.brandId").value(BRAND_ID.toString()))
        .andExpect(jsonPath("$.startDate").value("2020-06-14T00:00:00"))
        .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
        .andExpect(jsonPath("$.price").value(35.5));
  }

  /** Test for case Test 4: petición a las 10:00 del día 15 del producto 35455 para la brand 1 */
  @Test
  public void testCase4_GetApplicablePrice() throws Exception {
    // When & Then
    mockMvc
        .perform(
            get(PRICING_API_PATH)
                .param("productId", PRODUCT_ID.toString())
                .param("brandId", BRAND_ID.toString())
                .param("applicationDate", "2020-06-15T10:00:00")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty())
        .andExpect(jsonPath("$.productId").value(PRODUCT_ID.toString()))
        .andExpect(jsonPath("$.brandId").value(BRAND_ID.toString()))
        .andExpect(jsonPath("$.startDate").value("2020-06-15T00:00:00"))
        .andExpect(jsonPath("$.endDate").value("2020-06-15T11:00:00"))
        .andExpect(jsonPath("$.price").value(30.5));
  }

  /** Test for case Test 5: petición a las 21:00 del día 16 del producto 35455 para la brand 1 */
  @Test
  public void testCase5_GetApplicablePrice() throws Exception {
    // When & Then
    mockMvc
        .perform(
            get(PRICING_API_PATH)
                .param("productId", PRODUCT_ID.toString())
                .param("brandId", BRAND_ID.toString())
                .param("applicationDate", "2020-06-16T21:00:00")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$").isNotEmpty())
        .andExpect(jsonPath("$.productId").value(PRODUCT_ID.toString()))
        .andExpect(jsonPath("$.brandId").value(BRAND_ID.toString()))
        .andExpect(jsonPath("$.startDate").value("2020-06-15T16:00:00"))
        .andExpect(jsonPath("$.endDate").value("2020-12-31T23:59:59"))
        .andExpect(jsonPath("$.price").value(38.95));
  }

  /** Test for case Para precios que no existen */
  @Test
  public void testPriceNotFound() throws Exception {
    // Given
    long productId = 999L;

    // When & Then
    mockMvc
        .perform(
            get(PRICING_API_PATH)
                .param("productId", Long.toString(productId))
                .param("brandId", BRAND_ID.toString())
                .param("applicationDate", "2020-06-16T21:00:00")
                .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isNotFound());
  }
}
