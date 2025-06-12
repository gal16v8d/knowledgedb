package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.domain.TicketStatus;
import com.gsdd.knowledgedb.mappers.TicketStatusMapper;
import com.gsdd.knowledgedb.persistence.entity.TicketStatusEntity;
import com.gsdd.knowledgedb.persistence.repository.TicketStatusRepository;
import com.gsdd.knowledgedb.service.TicketStatusService;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TicketStatusServiceImpl
    extends AbstractGenericService<TicketStatusEntity, TicketStatus, UUID>
    implements TicketStatusService {

  public TicketStatusServiceImpl(TicketStatusRepository repository, TicketStatusMapper mapper) {
    super(repository, mapper);
  }
}
