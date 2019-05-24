package br.cin.ufpe.sdpos.mpback.models.mongo;

import br.cin.ufpe.sdpos.mpback.models.common.Status;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "notificacoes")
@Data
public class Notificacao {
    @Id
    private String id;
    private Date dataHora;
    private Status status;

}
