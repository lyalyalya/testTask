package ru.home.test.converter;

import org.mapstruct.Mapper;
import ru.home.test.dto.AddressDto;
import ru.home.test.entity.AddressEntity;

/**
 * Конвертер для адреса.
 */
@Mapper(componentModel = "spring", uses = ClientMapper.class)
public interface AddressMapper {

  /**
   * Конвертирует {@link AddressDto} в {@link AddressEntity}.
   *
   * @param address DTO адреса
   * @return ENTITY адреса
   */
  AddressEntity dtoToEntity(AddressDto address);

  /**
   * Конвертирует {@link AddressEntity} в {@link AddressDto}.
   *
   * @param address ENTITY адреса
   * @return DTO адреса
   */
  AddressDto entityToDto(AddressEntity address);

}
