package com.gsdd.knowledgedb.mappers;

import com.gsdd.knowledgedb.domain.TicketType;
import com.gsdd.knowledgedb.persistence.entity.TicketTypeEntity;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(
    componentModel = MappingConstants.ComponentModel.SPRING,
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface TicketTypeMapper extends GenericMapper<TicketTypeEntity, TicketType> {}
