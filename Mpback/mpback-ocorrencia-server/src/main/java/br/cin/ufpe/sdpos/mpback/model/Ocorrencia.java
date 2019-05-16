package br.cin.ufpe.sdpos.mpback.model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.List;

@Entity
public class Ocorrencia {
    private long id;
    private Localizacao localizacao;
    private Date dataHora;
    private Dispositivo dispositivo;
    private List<Notificacao> notificaoes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
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

    public List<Notificacao> getNotificaoes() {
        return notificaoes;
    }

    public void setNotificaoes(List<Notificacao> notificaoes) {
        this.notificaoes = notificaoes;
    }
}


