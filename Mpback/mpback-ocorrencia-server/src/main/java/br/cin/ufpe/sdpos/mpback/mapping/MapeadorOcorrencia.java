package br.cin.ufpe.sdpos.mpback.mapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import br.cin.ufpe.sdpos.mpback.models.jpa.DispositivoEntity;
import br.cin.ufpe.sdpos.mpback.models.jpa.LocalizacaoEntity;
import br.cin.ufpe.sdpos.mpback.models.jpa.NotificacaoEntity;
import br.cin.ufpe.sdpos.mpback.models.jpa.OcorrenciaDto;
import br.cin.ufpe.sdpos.mpback.models.jpa.OcorrenciaEntity;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MappingContext;

@Service
@Mapear
public class MapeadorOcorrencia extends CustomMapper<OcorrenciaEntity, OcorrenciaDto> {

	@Override
	public void mapAtoB(OcorrenciaEntity ocorrencia, OcorrenciaDto dto, MappingContext context) {
		dto.setId(ocorrencia.getId());
		
		dto.setLocalizacaoDto(criarLocalizacaoDto(ocorrencia.getLocalizacao()));
		
		OcorrenciaDto.DispositivoDto dispositivoDto = new OcorrenciaDto.DispositivoDto();
		dispositivoDto.setId(ocorrencia.getDispositivo().getId());
		dispositivoDto.setAtualDto(criarLocalizacaoDto(ocorrencia.getDispositivo().getAtual()));
		dispositivoDto.setNotificacoesDto(criarNotificacoesDto(ocorrencia.getDispositivo().getNotificacoes()));
		dto.setDispositivoDto(dispositivoDto);
		
		dto.setNotificacoesDto(criarNotificacoesDto(ocorrencia.getNotificaoes()));
	}
	
	private OcorrenciaDto.LocalizacaoDto criarLocalizacaoDto(LocalizacaoEntity localizacao) {
		OcorrenciaDto.LocalizacaoDto localizacaoDto = new OcorrenciaDto.LocalizacaoDto();
		localizacaoDto.setId(localizacao.getId());
		localizacaoDto.setLatitude(localizacao.getLatitude());
		localizacaoDto.setLongitude(localizacao.getLongitude());
		return localizacaoDto;
	}
	
	private List<OcorrenciaDto.NotificacaoDto> criarNotificacoesDto(List<NotificacaoEntity> notificacoes) {
		List<OcorrenciaDto.NotificacaoDto> notificacoesDto = new ArrayList<OcorrenciaDto.NotificacaoDto>();
		for (NotificacaoEntity notificacao : notificacoes) {
			OcorrenciaDto.NotificacaoDto dto = new OcorrenciaDto.NotificacaoDto();
			dto.setId(notificacao.getId());
			dto.setStatus(notificacao.getStatus());
			notificacoesDto.add(dto);
		}
		return notificacoesDto;
	}
	
	@Override
	public void mapBtoA(OcorrenciaDto dto, OcorrenciaEntity ocorrencia, MappingContext context) {
		ocorrencia.setId(dto.getId());
		ocorrencia.setDataHora(new Date());
		
		ocorrencia.setLocalizacao(criarLocalizacaoEntity(dto.getLocalizacaoDto()));
		
		DispositivoEntity dispositivo = new DispositivoEntity();
		dispositivo.setId(dto.getDispositivoDto().getId());
		dispositivo.setAtual(criarLocalizacaoEntity(dto.getDispositivoDto().getAtualDto()));
		dispositivo.setNotificacoes(criarNotificacaoEntity(dto.getDispositivoDto().getNotificacoesDto()));
		dispositivo.setDataCadastro(new Date());
		ocorrencia.setDispositivo(dispositivo);
		
		ocorrencia.setNotificaoes(criarNotificacaoEntity(dto.getNotificacoesDto()));
	}
	
	private LocalizacaoEntity criarLocalizacaoEntity(OcorrenciaDto.LocalizacaoDto dto) {
		LocalizacaoEntity localizacao = new LocalizacaoEntity();
		localizacao.setId(dto.getId());
		localizacao.setLatitude(dto.getLatitude());
		localizacao.setLongitude(dto.getLongitude());
		localizacao.setDataHora(new Date());
		return localizacao;
	}
	
	private List<NotificacaoEntity> criarNotificacaoEntity(List<OcorrenciaDto.NotificacaoDto> dtos) {
		List<NotificacaoEntity> notificacoes = new ArrayList<NotificacaoEntity>();
		for (OcorrenciaDto.NotificacaoDto dto : dtos) {
			NotificacaoEntity notificacao = new NotificacaoEntity();
			notificacao.setId(dto.getId());
			notificacao.setStatus(dto.getStatus());
			notificacao.setDataHora(new Date());
			notificacoes.add(notificacao);
		}
		return notificacoes;
	}
	
}
