package br.cin.ufpe.sdpos.mpback.models.jpa;

import br.cin.ufpe.sdpos.mpback.models.mongo.Dispositivo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import java.util.Date;
import java.util.List;

@Entity
public class OcorrenciaEntity {

    @Id
    @GeneratedValue
    private String id;
    private LocalizacaoEntity localizacao;
    private Date dataHora;
    private Dispositivo dispositivo;
    private List<NotificacaoEntity> notificaoes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalizacaoEntity getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoEntity localizacao) {
        this.localizacao = localizacao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    public List<NotificacaoEntity> getNotificaoes() {
        return notificaoes;
    }

    public void setNotificaoes(List<NotificacaoEntity> notificaoes) {
        this.notificaoes = notificaoes;
    }
}


