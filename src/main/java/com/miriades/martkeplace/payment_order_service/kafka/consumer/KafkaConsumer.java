package com.miriades.martkeplace.payment_order_service.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.miriades.martkeplace.payment_order_service.dto.CreatePaymentRequestDTO;
import com.miriades.martkeplace.payment_order_service.dto.CreatePaymentResponseDTO;
import com.miriades.martkeplace.payment_order_service.kafka.producer.KafkaProducer;
import com.miriades.martkeplace.payment_order_service.model.Order;
import com.miriades.martkeplace.payment_order_service.model.Token;
import com.miriades.martkeplace.payment_order_service.service.TokenService;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Log4j2
@Service
public class KafkaConsumer {

    private final ObjectMapper objectMapper;
    private final KafkaProducer responseProducer;

    private final TokenService tokenService;

    public KafkaConsumer(ObjectMapper objectMapper, KafkaProducer responseProducer, TokenService tokenService) {
        this.objectMapper = objectMapper;
        this.responseProducer = responseProducer;
        this.tokenService = tokenService;
    }

    @KafkaListener(topics = "${topic.create-payment-request}", groupId = "payment-request-group")
    public void consume(ConsumerRecord<String, String> record) {
//        log.info("");
        try {
            CreatePaymentRequestDTO request = objectMapper.readValue(record.value(), CreatePaymentRequestDTO.class);
            System.out.println("Processando pagamento: " + request.getData());

            // Simula processamento e cria resposta
            CreatePaymentResponseDTO response = new CreatePaymentResponseDTO();
            response.setCorrelationId(request.getCorrelationId());
            response.setResult("Pagamento processado com sucesso!");

            try {
                Thread.sleep(7000); // Pausa por 15 segundos (15.000 milissegundos)
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Restaura o status de interrupção
                // Lide com a interrupção conforme necessário
            }

            Order order = objectMapper.readValue(request.getData(), Order.class);

            tokenService.create(
                    new Token(
                            order.getCardToken(),
                            LocalDateTime.now(),
                            LocalDateTime.now()));

            responseProducer.send(response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
