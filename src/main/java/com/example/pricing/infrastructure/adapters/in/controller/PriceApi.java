package com.example.pricing.infrastructure.adapters.in.controller;

import com.example.pricing.infrastructure.adapters.in.dto.PriceResponse;
import com.example.pricing.infrastructure.config.ConstantsUrl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Tag(name = "Pricing", description = "All endpoints related with Pricing")
@RequestMapping(ConstantsUrl.V1 + ConstantsUrl.PRICES)
public interface PriceApi {

  @Operation(summary = "Get endpoint to get a price for a specific product, brand and date")
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "Price to apply"),
        @ApiResponse(responseCode = "404", description = "Price Not Found", content = @Content)
      })
  @GetMapping
  ResponseEntity<PriceResponse> getApplicablePrice(
      @Parameter(example = "35455") @RequestParam final Long productId,
      @Parameter(example = "1") @RequestParam final Long brandId,
      @Parameter(example = "2020-06-14T00:00:00") @RequestParam final String applicationDate);
}
