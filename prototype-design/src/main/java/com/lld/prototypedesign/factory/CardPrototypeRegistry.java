package com.lld.prototypedesign.factory;

import com.lld.prototypedesign.exception.PrototypeNotFoundException;
import com.lld.prototypedesign.prototype.CardLimits;
import com.lld.prototypedesign.prototype.impl.CardConfig;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class CardPrototypeRegistry {
    private final Map<String, CardConfig> prototypes = new ConcurrentHashMap<>();

    public void register(CardConfig prototype) {
        prototypes.put(prototype.getCardType(), prototype);
    }

    @PostConstruct
    public void loadDefaultPrototypes() {
        register(new CardConfig(
                "STANDARD", "INR", true,
                new CardLimits(25_000, 50_000, 10),
                List.of("GROCERY", "FUEL", "UTILITIES")
        ));

        register(new CardConfig(
                "PREMIUM", "INR", true,
                new CardLimits(100_000, 300_000, 25),
                List.of("GROCERY", "FUEL", "UTILITIES", "TRAVEL", "DINING")
        ));

        register(new CardConfig(
                "CORPORATE", "USD", false,
                new CardLimits(500_000, 1_000_000, 50),
                Arrays.asList("TRAVEL", "DINING", "OFFICE_SUPPLIES", "SOFTWARE")
        ));
    }

    public CardConfig getClone(String cardType) {
        CardConfig prototype = prototypes.get(cardType);
        if (prototype == null) {
            throw new PrototypeNotFoundException(cardType);
        }
        return prototype.cloneCard();
    }

    public List<String> availableCardTypes() {
        return List.copyOf(prototypes.keySet());
    }
}
