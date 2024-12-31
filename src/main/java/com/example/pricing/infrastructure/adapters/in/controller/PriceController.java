package com.example.pricing.infrastructure.adapters.in.controller;

import com.example.pricing.application.ports.in.PriceService;
import com.example.pricing.infrastructure.adapters.in.dto.PriceResponse;
import com.example.pricing.infrastructure.adapters.in.mapper.PriceDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class PriceController implements PriceApi {

  private final PriceService priceService;

  @Override
  public ResponseEntity<PriceResponse> getApplicablePrice(
      final Long productId, final Long brandId, final String applicationDate) {
    return ResponseEntity.ok(
        PriceDtoMapper.INSTANCE.toDto(
            priceService.getApplicablePrice(
                productId, brandId, LocalDateTime.parse(applicationDate))));
  }
}
