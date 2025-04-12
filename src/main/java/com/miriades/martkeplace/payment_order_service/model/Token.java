package com.miriades.martkeplace.payment_order_service.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "tokens")
public class Token {
    private String token;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Token(String token, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.token = token;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Token() {

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
