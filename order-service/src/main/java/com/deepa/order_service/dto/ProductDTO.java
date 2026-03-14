package com.deepa.order_service.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private long id;
    private String name;
    private double price;
    private int quantity;


}
