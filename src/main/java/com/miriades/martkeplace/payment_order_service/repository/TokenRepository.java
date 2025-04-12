package com.miriades.martkeplace.payment_order_service.repository;

import com.miriades.martkeplace.payment_order_service.model.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends MongoRepository<Token, String> {
}
