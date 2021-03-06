package br.cin.ufpe.sdpos.mpback.models.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "ocorrencias")
public @Data class Ocorrencia {

    @Id
    private String id;
    private Localizacao localizacao;
    private Date dataHora;
    private String idDispositivo;
    private List<Notificacao> notificaoes;
    
}


