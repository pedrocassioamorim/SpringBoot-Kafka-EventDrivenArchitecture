package net.javaguides.springkafkaeda.controller;

import net.javaguides.springkafkaeda.kafka.OrderProducer;
import net.javaguides.springkafkaedabasedomain.dto.OrderDTO;
import net.javaguides.springkafkaedabasedomain.dto.OrderEventDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController @RequestMapping("/api/v1")
public class OrderController {

    private OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping("/orders")
    public String placeOrder(@RequestBody OrderDTO orderDTO){
        orderDTO.setOrderId(UUID.randomUUID().toString());
        OrderEventDTO orderEventDTO = new OrderEventDTO();
        orderEventDTO.setStatus("PENDING");
        orderEventDTO.setMessage("Order Status is in pending state");
        orderEventDTO.setOrderDTO(orderDTO);

        orderProducer.sendMessage(orderEventDTO);
        return "Order placed successfully";
    }

}
