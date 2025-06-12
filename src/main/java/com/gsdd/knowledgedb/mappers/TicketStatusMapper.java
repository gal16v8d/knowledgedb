package com.gsdd.knowledgedb.mappers;

import com.gsdd.knowledgedb.domain.TicketStatus;
import com.gsdd.knowledgedb.persistence.entity.TicketStatusEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TicketStatusMapper extends GenericMapper<TicketStatusEntity, TicketStatus> {}
