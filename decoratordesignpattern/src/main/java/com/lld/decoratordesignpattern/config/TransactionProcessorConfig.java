package com.lld.decoratordesignpattern.config;

import com.lld.decoratordesignpattern.processor.CardTransactionProcessor;
import com.lld.decoratordesignpattern.decorator.impl.FraudCheckDecorator;
import com.lld.decoratordesignpattern.decorator.impl.LoggingDecorator;
import com.lld.decoratordesignpattern.decorator.impl.RateLimitingDecorator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class TransactionProcessorConfig {
    @Bean
    @Primary
    public CardTransactionProcessor decoratedTransactionProcessor(
            @Qualifier("baseTransactionProcessor") CardTransactionProcessor base
    ) {
        CardTransactionProcessor withFraudCheck = new FraudCheckDecorator(base);
        CardTransactionProcessor withLogging = new LoggingDecorator(withFraudCheck);
        return new RateLimitingDecorator(withLogging);
    }
}
