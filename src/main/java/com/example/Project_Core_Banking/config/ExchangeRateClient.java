package com.example.Project_Core_Banking.config;

import com.example.Project_Core_Banking.dto.response.ExchangeRateApiRes;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeRateClient {

    private static final String API_KEY = "ef913a21905de5ae053a4f98";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final RestTemplate restTemplate = new RestTemplate();

    public double getRate(String from, String to) {
        String url = BASE_URL + API_KEY + "/pair/" + from + "/" + to;
        ExchangeRateApiRes res = restTemplate.getForObject(url, ExchangeRateApiRes.class);

        if (res != null && "success".equals(res.result())) {
            return res.conversionRate();
        } else {
            throw new RuntimeException("Không lấy được tỷ giá từ API.");
        }
    }
}