package com.lld.prototypedesign.controller;

import com.lld.prototypedesign.prototype.impl.CardConfig;
import com.lld.prototypedesign.service.CardConfigService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardConfigController {
    private final CardConfigService cardConfigService;

    public CardConfigController(CardConfigService cardConfigService) {
        this.cardConfigService = cardConfigService;
    }

    @GetMapping("/types")
    public List<String> listAvailableCardTypes() {
        return cardConfigService.listAvailableTypes();
    }

    @GetMapping("/issue/{cardType}")
    public CardConfig issueCard(@PathVariable String cardType,
                                @RequestParam(required = false) Boolean contactless) {
        return cardConfigService.issueCard(cardType, contactless);
    }
}
