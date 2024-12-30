package com.example.pricing.application.services;

import com.example.pricing.application.ports.in.PriceService;
import com.example.pricing.application.ports.out.PriceRepository;
import com.example.pricing.domain.Price;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;

@Service
@AllArgsConstructor
public class PriceServiceImpl implements PriceService {

  private PriceRepository priceRepository;

  @Override
  public Price getApplicablePrice(
      final Long productId, final Long brandId, final LocalDateTime applicationDate) {
    return priceRepository.findPricesByProductAndBrand(productId, brandId).stream()
        .filter(
            price ->
                applicationDate.isAfter(price.startDate())
                    && applicationDate.isBefore(price.endDate()))
        .max(Comparator.comparingInt(Price::priority))
        .orElse(null);
  }
}
