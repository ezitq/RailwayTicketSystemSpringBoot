package com.bohdan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import com.bohdan.entity.ComfortType; // Твій Enum
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Іммутабельна конфігурація для тарифів системи бронювання.
 */
@ConfigurationProperties(prefix = "train.tariffs")
public record TariffProperties(
        BigDecimal baseRate,
        Map<ComfortType, BigDecimal> multipliers
) {}