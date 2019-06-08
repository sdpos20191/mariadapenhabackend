package br.cin.ufpe.sdpos.mpback.service;

import br.cin.ufpe.sdpos.mpback.config.RabbitConfig;
import br.cin.ufpe.sdpos.mpback.models.mongo.Notificacao;
import br.cin.ufpe.sdpos.mpback.models.mongo.Ocorrencia;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OcorrenciaMessageSender {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    public OcorrenciaMessageSender(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOcorrencia(Ocorrencia ocorrencia){
        try {
            String jsonObj = mapper.writeValueAsString(ocorrencia);
            Message message = MessageBuilder.withBody(jsonObj.getBytes()).setContentType(MessageProperties.CONTENT_TYPE_JSON).build();
            this.rabbitTemplate.convertAndSend(RabbitConfig.QUEUE_OCORRENCIAS, message);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}

