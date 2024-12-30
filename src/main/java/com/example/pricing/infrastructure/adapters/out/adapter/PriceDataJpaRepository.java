package com.example.pricing.infrastructure.adapters.out.adapter;

import com.example.pricing.infrastructure.adapters.out.model.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceDataJpaRepository extends JpaRepository<PriceEntity, Long> {

  @Query(
      """
        SELECT p FROM PriceEntity p
         WHERE p.productId = :productId
           AND p.brandId = :brandId
           AND :applicationDate BETWEEN p.startDate AND p.endDate
         ORDER BY p.priority DESC
    """)
  List<PriceEntity> findApplicablePrices(
      @Param("productId") Long productId,
      @Param("brandId") Long brandId,
      @Param("applicationDate") LocalDateTime applicationDate);
}
