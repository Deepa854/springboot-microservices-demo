package com.deepa.order_service.service;
import com.deepa.order_service.dto.ProductDTO;
import com.deepa.order_service.entity.Order;
import com.deepa.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestTemplate restTemplate;

    public Order createOrder(Order order) {
        String url = "http://localhost:8081/products/" + order.getProductId();
        ProductDTO product= restTemplate.getForObject(url, ProductDTO.class);

        if (product == null) {
            throw new RuntimeException("Product not found");
        }

        return orderRepository.save(order);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }
}

