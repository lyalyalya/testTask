package ru.home.test.service;

import java.util.Set;
import ru.home.test.dto.ClientDto;

/**
 * Сервис для клиентов.
 */
public interface ClientService {

  /**
   * Возвращает список всех клиентов.
   *
   * @return список клиентов
   */
  Set<ClientDto> findAllClients();

  /**
   * Возвращает список клиентов, отфильтрованных по подстроке.
   *
   * @param part подстрока для фильтра
   * @return список клиентов
   */
  Set<ClientDto> findClientsByNameContains(String part);

  /**
   * Сохраняет нового клиента.
   *
   * @param client новый клиент
   * @return созданный клиент
   */
  ClientDto addClient(ClientDto client);

  /**
   * Удаляет клиента по {@code id}.
   *
   * @param id {@code id} клиента
   */
  void deleteClient(Integer id);
}
