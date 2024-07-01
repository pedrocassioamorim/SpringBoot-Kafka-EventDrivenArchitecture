package net.javaguides.springkafkaedabasedomain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderEventDTO {

    private String message;

    private String status;

    private OrderDTO orderDTO;
}
