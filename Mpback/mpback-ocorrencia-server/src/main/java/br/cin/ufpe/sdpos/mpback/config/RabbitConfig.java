package br.cin.ufpe.sdpos.mpback.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NOTIFICACOES = "notificacoes-queue";
    public static final String QUEUE_DEAD_NOTIFICACOES = "notificacoes-queue-dead";

    @Bean
    Queue ordersQueue() {
        return QueueBuilder.durable(QUEUE_NOTIFICACOES).build();
    }

    @Bean
    Queue deadLetterQueue() {
        return QueueBuilder.durable(QUEUE_DEAD_NOTIFICACOES).build();
    }

}
