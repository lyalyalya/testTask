package ru.home.test.converter;

import org.mapstruct.Mapper;
import ru.home.test.dto.ClientDto;
import ru.home.test.entity.ClientEntity;

/**
 * Конвертер для клиентов.
 */
@Mapper(componentModel = "spring")
public interface ClientMapper {

  /**
   * Конвертирует {@link ClientDto} в {@link ClientEntity}.
   *
   * @param client DTO клиента
   * @return ENTITY клиента
   */
  ClientEntity dtoToEntity(ClientDto client);

  /**
   * Конвертирует {@link ClientEntity} в {@link ClientDto}.
   *
   * @param client DTO клиента
   * @return ENTITY клиента
   */
  ClientDto entityToDto(ClientEntity client);

}
