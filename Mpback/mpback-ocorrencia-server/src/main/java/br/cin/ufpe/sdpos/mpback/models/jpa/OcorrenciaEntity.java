package br.cin.ufpe.sdpos.mpback.models.jpa;

import br.cin.ufpe.sdpos.mpback.models.mongo.Dispositivo;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_ocorrencia")
public class OcorrenciaEntity {

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public DispositivoEntity getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(DispositivoEntity dispositivo) {
        this.dispositivo = dispositivo;
    }

    public List<NotificacaoEntity> getNotificaoes() {
        return notificaoes;
    }

    public void setNotificaoes(List<NotificacaoEntity> notificaoes) {
        this.notificaoes = notificaoes;
    }
}


