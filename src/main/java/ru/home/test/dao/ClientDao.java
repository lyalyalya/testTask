package ru.home.test.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.home.test.entity.ClientEntity;

/**
 * ДАО для клиентов.
 */
@Repository
public interface ClientDao extends CrudRepository<ClientEntity, Integer> {

  /**
   * Ищет клиента по {@code id}.
   *
   * @param id {@code id} клиента
   * @return найденный клиент
   */
  Optional<ClientEntity> findById(Integer id);

  /**
   * Возвращает список всех клиентов.
   *
   * @return список клиентов
   */
  List<ClientEntity> findAll();

  /**
   * Возвращает список клиентов, отфильтрованных по подстроке.
   *
   * @param part подстрока для фильтра
   * @return список клиентов
   */
  List<ClientEntity> findByNameContains(String part);

  /**
   * Сохраняет нового клиента.
   *
   * @param client новый клиент
   * @return созданный клиент
   */
  ClientEntity save(ClientEntity client);

  /**
   * Удаляет клиента по {@code id}.
   *
   * @param id {@code id} клиента
   */
  void deleteById(Integer id);

}
