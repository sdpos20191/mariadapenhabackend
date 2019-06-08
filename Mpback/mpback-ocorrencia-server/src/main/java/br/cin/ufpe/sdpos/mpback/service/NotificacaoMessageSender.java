package br.cin.ufpe.sdpos.mpback.service;

import br.cin.ufpe.sdpos.mpback.config.RabbitConfig;
import br.cin.ufpe.sdpos.mpback.models.mongo.Notificacao;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificacaoMessageSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public NotificacaoMessageSender(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendNotificacao(Notificacao notificacao){
        try {
            String jsonObj = mapper.writeValueAsString(notificacao);
            Message message = MessageBuilder.withBody(jsonObj.getBytes()).setContentType(MessageProperties.CONTENT_TYPE_JSON).build();
            this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_NOTIFICACOES, notificacao);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}

