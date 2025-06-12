package com.gsdd.knowledgedb.persistence.init;

import com.gsdd.knowledgedb.persistence.entity.TicketStatusEntity;
import com.gsdd.knowledgedb.persistence.entity.TicketTypeEntity;
import com.gsdd.knowledgedb.persistence.entity.enums.TicketStatusEnum;
import com.gsdd.knowledgedb.persistence.entity.enums.TicketTypeEnum;
import com.gsdd.knowledgedb.persistence.repository.TicketStatusRepository;
import com.gsdd.knowledgedb.persistence.repository.TicketTypeRepository;
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

  private final TicketTypeRepository ticketTypeRepository;
  private final TicketStatusRepository ticketStatusRepository;

  @Override
  public void run(ApplicationArguments args) {
    Stream.of(TicketTypeEnum.values()).forEach(this::attemptToSaveType);
    Stream.of(TicketStatusEnum.values()).forEach(this::attemptToSaveStatus);
  }

  private void attemptToSaveType(TicketTypeEnum value) {
    try {
      ticketTypeRepository.save(TicketTypeEntity.builder().name(value).status(true).build());
    } catch (Exception e) {
      log.warn("Seems type value already exists in db {}", value);
    }
  }

  private void attemptToSaveStatus(TicketStatusEnum value) {
    try {
      ticketStatusRepository.save(TicketStatusEntity.builder().name(value).status(true).build());
    } catch (Exception e) {
      log.warn("Seems status value already exists in db {}", value);
    }
  }
}
