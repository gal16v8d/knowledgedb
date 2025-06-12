package com.gsdd.knowledgedb.service.impl;

import com.gsdd.knowledgedb.domain.User;
import com.gsdd.knowledgedb.mappers.UserMapper;
import com.gsdd.knowledgedb.persistence.entity.UserEntity;
import com.gsdd.knowledgedb.persistence.repository.UserRepository;
import com.gsdd.knowledgedb.service.UserService;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends AbstractCrudService<UserEntity, User, UUID>
    implements UserService {

  public UserServiceImpl(UserRepository repository, UserMapper mapper) {
    super(repository, mapper);
  }
}
