package br.cin.ufpe.sdpos.mpback.models.jpa;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Date;

@Entity(name = "tb_localizacao")
public @Data class LocalizacaoEntity {

    @Id
    @GeneratedValue
    private Long id;
    private long latitude;
    private long longitude;
    @Column(name = "dataHora")
    private Date dataHora;
}
