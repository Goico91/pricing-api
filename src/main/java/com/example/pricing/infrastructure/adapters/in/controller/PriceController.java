package com.example.pricing.infrastructure.adapters.in.controller;

import com.example.pricing.application.ports.in.PriceService;
import com.example.pricing.domain.Price;
import com.example.pricing.infrastructure.adapters.in.dto.PriceResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class PriceController implements PriceApi {

  private PriceService priceService;

  @Override
  public ResponseEntity<PriceResponse> getPrice(
      final Long productId, final Long brandId, final String applicationDate) {
    final LocalDateTime date = LocalDateTime.parse(applicationDate);
    final Price price = priceService.getApplicablePrice(productId, brandId, date);
    return ResponseEntity.ok(
        new PriceResponse(
            price.productId(),
            price.brandId(),
            price.priceList(),
            price.startDate(),
            price.endDate(),
            price.price()));
  }
}
