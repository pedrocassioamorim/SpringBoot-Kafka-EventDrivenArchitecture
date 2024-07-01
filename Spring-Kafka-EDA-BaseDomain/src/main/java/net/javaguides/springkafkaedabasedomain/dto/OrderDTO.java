package net.javaguides.springkafkaedabasedomain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class OrderDTO {

    private Long id;

    private String name;

    private Integer quantity;

    private Double price;

}
