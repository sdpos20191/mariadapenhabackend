package br.cin.ufpe.sdpos.mpback.repositories.jpa;

import br.cin.ufpe.sdpos.mpback.models.jpa.LocalizacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalizacaoJPARepository extends JpaRepository<LocalizacaoEntity, Long> {
}
