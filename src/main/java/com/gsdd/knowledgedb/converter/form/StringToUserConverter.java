package com.gsdd.knowledgedb.converter.form;

import com.gsdd.knowledgedb.domain.User;
import com.gsdd.knowledgedb.service.UserService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StringToUserConverter implements Converter<String, User> {

  private final UserService userService;

  @Override
  public User convert(String arg) {
    return userService.findById(UUID.fromString(arg));
  }
}
