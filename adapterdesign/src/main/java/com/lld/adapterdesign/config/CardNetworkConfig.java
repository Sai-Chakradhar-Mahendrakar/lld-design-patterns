package com.lld.adapterdesign.config;

import com.lld.adapterdesign.client.RupayClient;
import com.lld.adapterdesign.client.VisaNetSdkClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CardNetworkConfig {
    @Bean
    public VisaNetSdkClient visaNetSdkClient() {
        return new VisaNetSdkClient();
    }

    @Bean
    public RupayClient rupayClient() {
        return new RupayClient();
    }
}
