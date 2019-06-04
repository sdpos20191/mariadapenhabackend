package br.cin.ufpe.sdpos.mpback.models.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_ocorrencia")
public @Data
class OcorrenciaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToOne(cascade = CascadeType.ALL)
    private LocalizacaoEntity localizacao;
    
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dataHora;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private DispositivoEntity dispositivo;
    
    @OneToMany(mappedBy = "ocorrencia", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NotificacaoEntity> notificaoes;

}


