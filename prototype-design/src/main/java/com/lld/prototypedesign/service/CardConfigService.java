package com.lld.prototypedesign.service;

import com.lld.prototypedesign.factory.CardPrototypeRegistry;
import com.lld.prototypedesign.prototype.impl.CardConfig;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardConfigService {
    private final CardPrototypeRegistry registry;

    public CardConfigService(CardPrototypeRegistry registry) {
        this.registry = registry;
    }

    public CardConfig issueCard(String cardType, Boolean contactlessEnabled) {
        CardConfig card = registry.getClone(cardType);
        if (contactlessEnabled != null) {
            card.setContactlessEnabled(contactlessEnabled);
        }
        return card;
    }

    public List<String> listAvailableTypes() {
        return registry.availableCardTypes();
    }
}
