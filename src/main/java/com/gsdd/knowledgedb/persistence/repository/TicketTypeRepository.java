package com.gsdd.knowledgedb.persistence.repository;

import com.gsdd.knowledgedb.persistence.entity.TicketTypeEntity;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TicketTypeRepository extends GenericRepository<TicketTypeEntity, UUID> {}
