package br.cin.ufpe.sdpos.mpback.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "ocrrencias")
public class Ocorrencia {

    @Id
    private String id;
    private Localizacao localizacao;
    private Date dataHora;
    private Dispositivo dispositivo;
    private List<Notificacao> notificaoes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
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


