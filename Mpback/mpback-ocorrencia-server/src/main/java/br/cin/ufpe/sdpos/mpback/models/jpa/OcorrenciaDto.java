package br.cin.ufpe.sdpos.mpback.models.jpa;

import java.util.List;

import br.cin.ufpe.sdpos.mpback.models.common.Status;
import lombok.Data;

@Data
public class OcorrenciaDto {

	private Long id; 
	private LocalizacaoDto localizacaoDto;
	private DispositivoDto dispositivoDto;
	private List<NotificacaoDto> notificacoesDto;
	
	@Data
	public static class LocalizacaoDto {
		private Long id;
		private long latitude;
		private long longitude;
	}
	
	@Data
	public static class DispositivoDto {
		private Long id;
		private LocalizacaoDto atualDto;
		private List<NotificacaoDto> notificacoesDto;
	}
	
	@Data
	public static class NotificacaoDto {
		private Long id;
	    private Status status;
	}
	
}
