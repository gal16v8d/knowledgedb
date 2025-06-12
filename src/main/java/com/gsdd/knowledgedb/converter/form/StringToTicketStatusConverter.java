package com.gsdd.knowledgedb.converter.form;

import com.gsdd.knowledgedb.domain.TicketStatus;
import com.gsdd.knowledgedb.service.TicketStatusService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class StringToTicketStatusConverter implements Converter<String, TicketStatus> {

  private final TicketStatusService ticketStatusService;

  @Override
  public TicketStatus convert(String arg) {
    return ticketStatusService.findById(UUID.fromString(arg));
  }
}
