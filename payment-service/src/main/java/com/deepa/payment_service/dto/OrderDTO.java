package com.deepa.payment_service.dto;
import lombok.Data;

@Data
public class OrderDTO {
    private long id;
   // private Long orderId;
    private  long productId;
    private int quality;
}
