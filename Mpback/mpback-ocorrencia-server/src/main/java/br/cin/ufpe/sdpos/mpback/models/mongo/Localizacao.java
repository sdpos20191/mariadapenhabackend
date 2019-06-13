package br.cin.ufpe.sdpos.mpback.models.mongo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document(collection = "localizacoes")
@Data
public class Localizacao {

    @Id
    private String id;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Date dataHora;

}
