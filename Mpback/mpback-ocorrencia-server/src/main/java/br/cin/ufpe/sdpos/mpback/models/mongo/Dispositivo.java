package br.cin.ufpe.sdpos.mpback.models.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "dispositivos")
@Data
public class Dispositivo {

    @Id
    private String id;
    private Date dataCadastro;
    private Localizacao atual;
    private List<Notificacao> notificacoes;

}
