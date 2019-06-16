package br.cin.ufpe.sdpos.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class OcorrenciaDtoInfo {

	private String id; 
	private LocalizacaoDto localizacaoDto;
	private Date dataHora;
	private String idDispositivo;
	private List<NotificacaoDto> notificacoesDto;
	
	@Data
	public static class LocalizacaoDto {
		private String id;
		private BigDecimal latitude;
		private BigDecimal longitude;
		private Date dataHora;
	}
	
	@Data
	public static class NotificacaoDto {
		private String id;
		private Date dataHora;
	    private Status status;
	}
	
}
