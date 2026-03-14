package com.deepa.payment_service.service;

import com.deepa.payment_service.dto.OrderDTO;
import com.deepa.payment_service.entity.Payment;
import com.deepa.payment_service.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final RestTemplate restTemplate;

    public Payment makePayment(Payment payment) {

        String url = "http://localhost:8082/orders/" + payment.getOrderId();

        OrderDTO order = restTemplate.getForObject(url, OrderDTO.class);

        if(order == null){
            throw new RuntimeException("Order not found");
        }

        payment.setStatus("SUCCESS");

        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }
}