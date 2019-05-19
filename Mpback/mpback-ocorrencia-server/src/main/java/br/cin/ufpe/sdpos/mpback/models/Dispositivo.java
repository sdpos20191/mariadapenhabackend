package br.cin.ufpe.sdpos.mpback.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "dispositivos")
public class Dispositivo {

    @Id
    private String id;
    private Date dataCadastro;
    private Localizacao atual;
    private List<Notificacao> notificacoes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Localizacao getAtual() {
        return atual;
    }

    public void setAtual(Localizacao atual) {
        this.atual = atual;
    }

    public List<Notificacao> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<Notificacao> notificacoes) {
        this.notificacoes = notificacoes;
    }
}
