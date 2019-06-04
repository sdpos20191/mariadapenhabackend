package br.cin.ufpe.sdpos.mpback.models.jpa;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity(name = "tb_localizacao")
public @Data class LocalizacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private long latitude;
    
    private long longitude;
    
    @Temporal(value=TemporalType.TIMESTAMP)
    @Column(name = "dataHora")
    private Date dataHora;
}
