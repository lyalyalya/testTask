package ru.home.test.service;

import java.util.Set;
import ru.home.test.dto.AddressDto;

/**
 * Сервис для адресов.
 */
public interface AddressService {

  /**
   * Возвращает список адресов клиента по {@code id} клиента.
   *
   * @param clientId {@code id} клиента
   * @return список адресов
   */
  Set<AddressDto> findAddressByClientId(Integer clientId);

  /**
   * Сохраняет новый адрес для клиента по {@code id} клиента.
   *
   * @param address адрес для сохранения
   * @param clientId {@code id} клиента
   * @return созданный адрес
   * @throws IllegalArgumentException если не найден id клиента
   */
  AddressDto saveAddressByClientId(Integer clientId, AddressDto address);

}
