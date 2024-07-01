package net.javaguides.springkafkaedastockservice.kafka;

import net.javaguides.springkafkaedabasedomain.dto.OrderEventDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @KafkaListener(topics = "${spring.kafka.template.default-topic}",
            groupId = "${spring.kafka.consumer.group-id}")
    public void consume(OrderEventDTO eventDTO){
        LOGGER.info(String.format("Order Event Received in STOCK Service => %s", eventDTO.toString()));
        // Save the Order Event data into the database:


    }

}
