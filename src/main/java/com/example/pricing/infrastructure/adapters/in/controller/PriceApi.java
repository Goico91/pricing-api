package com.example.pricing.infrastructure.adapters.in.controller;

import com.example.pricing.infrastructure.adapters.in.dto.PriceResponse;
import com.example.pricing.infrastructure.config.ConstantsUrl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(ConstantsUrl.V1 + ConstantsUrl.PRICES)
public interface PriceApi {

  @GetMapping
  ResponseEntity<PriceResponse> getPrice(
      @RequestParam final Long productId,
      @RequestParam final Long brandId,
      @RequestParam final String applicationDate);
}
