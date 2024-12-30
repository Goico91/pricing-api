package com.example.pricing.application.services;

import com.example.pricing.application.ports.in.PriceService;
import com.example.pricing.application.ports.out.PriceRepository;
import com.example.pricing.domain.exception.PriceNotFoundException;
import com.example.pricing.domain.model.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

  private PriceRepository priceRepository;

  @Override
  public Price getApplicablePrice(
      final Long productId, final Long brandId, final LocalDateTime applicationDate) {
    return priceRepository.findApplicablePrices(productId, brandId, applicationDate).stream()
        .findFirst()
        .orElseThrow(
            () -> new PriceNotFoundException("Price not found for productId: " + productId));
  }
}
