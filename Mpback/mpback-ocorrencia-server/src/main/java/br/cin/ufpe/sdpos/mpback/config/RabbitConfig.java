package br.cin.ufpe.sdpos.mpback.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String QUEUE_NOTIFICACOES = "notificacoes-queue";
    public static final String QUEUE_DEAD_NOTIFICACOES = "notificacoes-queue-dead";
    public static final String QUEUE_OCORRENCIAS = "ocorrencias-queue";
    public static final String QUEUE_DEAD_OCORRENCIAS = "ocorrencias-queue-dead";

    @Bean
    Queue notificaoesQueue() {
        return QueueBuilder.durable(QUEUE_NOTIFICACOES).build();
    }

    @Bean
    Queue deadNotificaoesQueue() {
        return QueueBuilder.durable(QUEUE_DEAD_NOTIFICACOES).build();
    }

    @Bean
    Queue ocorrenciasQueue() {
        return QueueBuilder.durable(QUEUE_OCORRENCIAS).build();
    }

    @Bean
    Queue deadOcorrenciasQueue() {
        return QueueBuilder.durable(QUEUE_DEAD_OCORRENCIAS).build();
    }

}
