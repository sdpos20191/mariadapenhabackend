package br.cin.ufpe.sdpos.mpback.models.jpa;

import br.cin.ufpe.sdpos.mpback.models.mongo.Dispositivo;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_ocorrencia")
public @Data
class OcorrenciaEntity {

    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private LocalizacaoEntity localizacao;
    private Date dataHora;
    @ManyToOne
    private DispositivoEntity dispositivo;
    @OneToMany
    private List<NotificacaoEntity> notificaoes;

}


