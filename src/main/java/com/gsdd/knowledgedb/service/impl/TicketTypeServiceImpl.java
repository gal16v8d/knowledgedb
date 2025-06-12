package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.domain.TicketType;
import com.gsdd.knowledgedb.mappers.TicketTypeMapper;
import com.gsdd.knowledgedb.persistence.entity.TicketTypeEntity;
import com.gsdd.knowledgedb.persistence.repository.TicketTypeRepository;
import com.gsdd.knowledgedb.service.TicketTypeService;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class TicketTypeServiceImpl
    extends AbstractGenericService<TicketTypeEntity, TicketType, UUID>
    implements TicketTypeService {

  public TicketTypeServiceImpl(TicketTypeRepository repository, TicketTypeMapper mapper) {
    super(repository, mapper);
  }
}
