package br.cin.ufpe.sdpos.mpback.model;

import java.util.Date;
import java.util.List;

public class Dispositivo {

    private long id;
    private Date dataCadastro;
    private Localizacao atual;
    private List<Notificacao> notificacoes;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
