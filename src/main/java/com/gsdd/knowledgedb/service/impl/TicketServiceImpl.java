package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.domain.Ticket;
import com.gsdd.knowledgedb.mappers.TicketMapper;
import com.gsdd.knowledgedb.persistence.entity.TicketEntity;
import com.gsdd.knowledgedb.persistence.repository.TicketRepository;
import com.gsdd.knowledgedb.service.TicketService;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl extends AbstractCrudService<TicketEntity, Ticket, UUID>
    implements TicketService {

  public TicketServiceImpl(TicketRepository repository, TicketMapper mapper) {
    super(repository, mapper);
  }
}
