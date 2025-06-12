package com.gsdd.knowledgedb.persistence.repository;

import com.gsdd.knowledgedb.persistence.entity.UserEntity;
import jakarta.transaction.Transactional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserRepository extends GenericRepository<UserEntity, UUID> {}
