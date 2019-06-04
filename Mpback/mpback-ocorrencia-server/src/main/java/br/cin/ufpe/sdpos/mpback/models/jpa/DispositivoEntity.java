package br.cin.ufpe.sdpos.mpback.models.jpa;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity(name = "tb_dispositivo")
public @Data class DispositivoEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(value=TemporalType.DATE)
    private Date dataCadastro;
    
    @OneToOne(cascade = CascadeType.ALL)
    private LocalizacaoEntity atual;
    
    @OneToMany(mappedBy = "dispositivo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<NotificacaoEntity> notificacoes;
}
