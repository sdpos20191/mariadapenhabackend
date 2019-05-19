package br.cin.ufpe.sdpos.mpback.models.jpa;

import br.cin.ufpe.sdpos.mpback.models.common.Status;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name = "tb_notificacao")
public class NotificacaoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Date dataHora;
    private Status status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
