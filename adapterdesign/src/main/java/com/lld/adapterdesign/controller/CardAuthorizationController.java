package com.lld.adapterdesign.controller;

import com.lld.adapterdesign.request.CardAuthRequest;
import com.lld.adapterdesign.response.AuthorizationResult;
import com.lld.adapterdesign.service.CardAuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/card-auth")
public class CardAuthorizationController {
    private final CardAuthorizationService cardAuthorizationService;

    public CardAuthorizationController(CardAuthorizationService cardAuthorizationService) {
        this.cardAuthorizationService = cardAuthorizationService;
    }

    @PostMapping("/{network}")
    public ResponseEntity<AuthorizationResult> authorize(
            @PathVariable String network,
            @RequestBody CardAuthRequest requestDto) {

        CardAuthRequest request = new CardAuthRequest(
                requestDto.cardNumber(),
                requestDto.expiry(),
                requestDto.cvv(),
                requestDto.amount()
        );

        AuthorizationResult result = cardAuthorizationService.authorize(network, request);

        AuthorizationResult response = new AuthorizationResult(
                result.approved(),
                result.authCode(),
                result.approved() ? "APPROVED" : "DECLINED"
        );

        return ResponseEntity.status(result.approved() ? HttpStatus.OK : HttpStatus.PAYMENT_REQUIRED)
                .body(response);
    }
}
