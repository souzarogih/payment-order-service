package com.miriades.martkeplace.payment_order_service.service;

import com.miriades.martkeplace.payment_order_service.model.Token;
import com.miriades.martkeplace.payment_order_service.repository.TokenRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Log4j2
@Service
public class TokenService {

    @Autowired
    TokenRepository tokenRepository;

    private Token save(Token token){
//        log.info("Salvando dados do token: {}", token.getToken());
        return tokenRepository.save(token);
    }

    public Token create(Token token){
//        log.info("Criando o token {}", token.getToken());
        return save(token);
    }
}
