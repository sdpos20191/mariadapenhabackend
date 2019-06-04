package br.cin.ufpe.sdpos.mpback.mapping;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ma.glasnost.orika.Mapper;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/**
 * 
 * Classe que obt�m a inst�ncia do bean do mapeador orika.
 * 
 */
@Service
public class Mapeador {
	
	private static MapperFacade mapeador;
	private List<Class<? extends Mapper>> classesAnotadas = new ArrayList<>();

	private Mapeador() {
	}

	public MapperFacade getInstancia() {
		if (mapeador == null) {
			mapeador = getMapeador();
		}
		return mapeador;
	}

	private MapperFacade getMapeador() {
		MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
		addClassesAnotadas();
		
		try {
			for (Class<? extends Mapper> classe : classesAnotadas) {
				mapperFactory.registerMapper(classe.newInstance());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException("Erro ao obter instancia da classe");
		}
		
		return mapperFactory.getMapperFacade();
	}
	
	private void addClassesAnotadas() {		
		classesAnotadas.add(MapeadorOcorrencia.class);
	}
	
}