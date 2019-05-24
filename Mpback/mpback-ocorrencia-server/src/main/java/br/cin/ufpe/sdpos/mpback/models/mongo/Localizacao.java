package br.cin.ufpe.sdpos.mpback.models.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "localizacoes")
@Data
public class Localizacao {

    @Id
    private String id;
    private long latitude;
    private long longitude;
    private Date dataHora;

}
