package com.example.demo.DTO;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Builder
public record BoltResponseDTO(Long num, BigDecimal distance, BigDecimal temperature, Long date) {
}
