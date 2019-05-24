package br.cin.ufpe.sdpos.mpback.models.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_dispositivo")
public @Data class DispositivoEntity {
    @Id
    @GeneratedValue
    private Long id;
    private Date dataCadastro;
    @OneToOne
    private LocalizacaoEntity atual;
    @OneToMany
    private List<NotificacaoEntity> notificacoes;
}
