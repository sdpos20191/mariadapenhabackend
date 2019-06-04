package br.cin.ufpe.sdpos.mpback.models.jpa;

import br.cin.ufpe.sdpos.mpback.models.common.Status;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.util.Date;

@Entity(name = "tb_notificacao")
public @Data class NotificacaoEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Temporal(value=TemporalType.TIMESTAMP)
    private Date dataHora;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Ocorrencia_Id", nullable = true)
	private OcorrenciaEntity ocorrencia;
    
    @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "Dispositivo_Id", nullable = true)
	private DispositivoEntity dispositivo;
    
}
