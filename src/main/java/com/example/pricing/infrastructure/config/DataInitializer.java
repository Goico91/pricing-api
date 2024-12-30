package com.example.pricing.infrastructure.config;

import com.example.pricing.infrastructure.adapters.out.adapter.PriceDataJpaRepository;
import com.example.pricing.infrastructure.adapters.out.model.PriceEntity;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DataInitializer {

  @Bean
  CommandLineRunner initData(PriceDataJpaRepository repository) {
    return args -> {
      final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

      repository.save(
          PriceEntity.builder()
              .brandId(1L)
              .startDate(LocalDateTime.parse("2020-06-14 00:00:00", formatter))
              .endDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter))
              .priceList(1)
              .productId(35455L)
              .priority(0)
              .price(35.50)
              .currency("EUR")
              .build());

      repository.save(
          PriceEntity.builder()
              .brandId(1L)
              .startDate(LocalDateTime.parse("2020-06-14 15:00:00", formatter))
              .endDate(LocalDateTime.parse("2020-06-14 18:30:00", formatter))
              .priceList(2)
              .productId(35455L)
              .priority(1)
              .price(25.45)
              .currency("EUR")
              .build());

      repository.save(
          PriceEntity.builder()
              .brandId(1L)
              .startDate(LocalDateTime.parse("2020-06-15 00:00:00", formatter))
              .endDate(LocalDateTime.parse("2020-06-15 11:00:00", formatter))
              .priceList(3)
              .productId(35455L)
              .priority(1)
              .price(30.50)
              .currency("EUR")
              .build());

      repository.save(
          PriceEntity.builder()
              .brandId(1L)
              .startDate(LocalDateTime.parse("2020-06-15 16:00:00", formatter))
              .endDate(LocalDateTime.parse("2020-12-31 23:59:59", formatter))
              .priceList(4)
              .productId(35455L)
              .priority(1)
              .price(38.95)
              .currency("EUR")
              .build());
    };
  }
}
