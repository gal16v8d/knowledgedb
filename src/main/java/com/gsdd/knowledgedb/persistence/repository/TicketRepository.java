package com.gsdd.knowledgedb.persistence.repository;

import com.gsdd.knowledgedb.persistence.entity.TicketEntity;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface TicketRepository extends GenericRepository<TicketEntity, UUID> {}
