package br.cin.ufpe.sdpos.mpback.models.jpa;

import br.cin.ufpe.sdpos.mpback.models.common.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "tb_notificacao")
public @Data class NotificacaoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Date dataHora;
    private Status status;
}
