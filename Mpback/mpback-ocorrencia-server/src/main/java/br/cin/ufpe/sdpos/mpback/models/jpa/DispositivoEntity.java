package br.cin.ufpe.sdpos.mpback.models.jpa;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_dispositivo")
public class DispositivoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Date dataCadastro;
    @OneToOne
    private LocalizacaoEntity atual;
    @OneToMany
    private List<NotificacaoEntity> notificacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalizacaoEntity getAtual() {
        return atual;
    }

    public void setAtual(LocalizacaoEntity atual) {
        this.atual = atual;
    }

    public List<NotificacaoEntity> getNotificacoes() {
        return notificacoes;
    }

    public void setNotificacoes(List<NotificacaoEntity> notificacoes) {
        this.notificacoes = notificacoes;
    }
}
