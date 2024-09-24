package com.gsdd.knowledgedb.persistence.init;

import com.gsdd.knowledgedb.persistence.entity.EstadoCasoEntidad;
import com.gsdd.knowledgedb.persistence.entity.TipoCasoEntidad;
import com.gsdd.knowledgedb.persistence.entity.enums.EstadoCasoEnum;
import com.gsdd.knowledgedb.persistence.entity.enums.TipoCasoEnum;
import com.gsdd.knowledgedb.persistence.repository.EstadoCasoRepository;
import com.gsdd.knowledgedb.persistence.repository.TipoCasoRepository;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class InitDb implements ApplicationRunner {

  private final TipoCasoRepository tipoCasoRepository;
  private final EstadoCasoRepository estadoCasoRepository;

  @Override
  public void run(ApplicationArguments args) {
    AtomicLong countTipoCaso = new AtomicLong(1);
    Stream.of(TipoCasoEnum.values())
        .forEach(
            (TipoCasoEnum tipoCaso) -> {
              validateTipoCasoInDb(countTipoCaso.get(), tipoCaso);
              countTipoCaso.addAndGet(1L);
            });
    AtomicLong countEstadoCaso = new AtomicLong(1);
    Stream.of(EstadoCasoEnum.values())
        .forEach(
            (EstadoCasoEnum estadoCaso) -> {
              validateEstadoCasoInDb(countEstadoCaso.get(), estadoCaso);
              countEstadoCaso.addAndGet(1L);
            });
  }

  private void validateTipoCasoInDb(Long id, TipoCasoEnum valor) {
    if (tipoCasoRepository.findById(id).isPresent()) {
      log.debug("El tipoCaso {} ya existe en BD", valor);
    } else {
      TipoCasoEntidad tipoCaso = new TipoCasoEntidad();
      tipoCaso.setCodigoTipo(id);
      tipoCaso.setEstado(true);
      tipoCaso.setDescripcion(valor);
      tipoCasoRepository.save(tipoCaso);
    }
  }

  private void validateEstadoCasoInDb(Long id, EstadoCasoEnum valor) {
    if (estadoCasoRepository.findById(id).isPresent()) {
      log.debug("El estadoCaso {} ya existe en BD", valor);
    } else {
      EstadoCasoEntidad estadoCaso = new EstadoCasoEntidad();
      estadoCaso.setCodigoEstado(id);
      estadoCaso.setEstado(true);
      estadoCaso.setDescripcion(valor);
      estadoCasoRepository.save(estadoCaso);
    }
  }
}
