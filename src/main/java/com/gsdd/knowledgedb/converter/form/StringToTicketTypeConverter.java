package com.gsdd.knowledgedb.converter.form;

import com.gsdd.knowledgedb.domain.TicketType;
import com.gsdd.knowledgedb.service.TicketTypeService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StringToTicketTypeConverter implements Converter<String, TicketType> {

  private final TicketTypeService ticketTypeService;

  @Override
  public TicketType convert(String arg) {
    return ticketTypeService.findById(UUID.fromString(arg));
  }
}
