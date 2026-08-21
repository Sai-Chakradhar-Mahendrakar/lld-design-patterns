package com.lld.flyweightdesign.controller;

import com.lld.flyweightdesign.dto.CardOnboardingRequest;
import com.lld.flyweightdesign.dto.CardResponse;
import com.lld.flyweightdesign.factory.CardNetworkFlyweightFactory;
import com.lld.flyweightdesign.model.Card;
import com.lld.flyweightdesign.service.CardValidationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cards")
public class CardController {
    private final CardValidationService cardValidationService;
    private final CardNetworkFlyweightFactory cardNetworkFlyweightFactory;


    public CardController(
            CardValidationService cardValidationService,
            CardNetworkFlyweightFactory cardNetworkFlyweightFactory
    ) {
        this.cardValidationService = cardValidationService;
        this.cardNetworkFlyweightFactory = cardNetworkFlyweightFactory;
    }

    @PostMapping
    public ResponseEntity<CardResponse> onboard(@Valid @RequestBody CardOnboardingRequest request) {
        Card card = cardValidationService.onboard(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(CardResponse.from(card));
    }

    @GetMapping("/network-pool-size")
    public ResponseEntity<Integer> poolSize() {
        return ResponseEntity.ok(cardNetworkFlyweightFactory.poolSize());
    }
}
