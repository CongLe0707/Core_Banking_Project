package com.example.Project_Core_Banking.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ExchangeRateApiRes (
        @JsonProperty("result") String result,
        @JsonProperty("base_code") String baseCode,
        @JsonProperty("target_code") String targetCode,
        @JsonProperty("conversion_rate") double conversionRate
) {
}
