package ru.home.test.dao;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.home.test.entity.AddressEntity;

/**
 * ДАО для адресов.
 */
@Repository
public interface AddressDao extends CrudRepository<AddressEntity, Integer> {

  /**
   * Ищет адреса клиента по {@code id} клиента.
   *
   * @param clientId {@code id} клиента
   * @return список адресов
   */
  @Query("SELECT a FROM AddressEntity a LEFT JOIN a.client c WHERE c.id = :clientId")
  List<AddressEntity> findByClientId(@Param("clientId") Integer clientId);

  /**
   * Сохраняет адрес.
   *
   * @param address адрес для сохранения
   * @return созданный адрес
   */
  AddressEntity save(AddressEntity address);

}
