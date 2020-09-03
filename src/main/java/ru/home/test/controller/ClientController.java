package ru.home.test.controller;

import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.home.test.dto.ClientDto;
import ru.home.test.service.ClientService;

/**
 * Контроллер для клиентов.
 */
@RestController
@RequestMapping(path = "clients", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

  @Autowired
  private ClientService clientService;

  /**
   * Возвращает список всех клиентов.
   *
   * @return список клиентов
   */
  @GetMapping
  @ResponseBody
  public Set<ClientDto> findAllClients() {
    return clientService.findAllClients();
  }

  /**
   * Возвращает список клиентов, отфильтрованных по подстроке.
   *
   * @param part подстрока для фильтра
   * @return список клиентов
   */
  @GetMapping("filter")
  @ResponseBody
  public Set<ClientDto> findClientsByNameContains(@RequestParam String part) {
    return clientService.findClientsByNameContains(part);
  }

  /**
   * Сохраняет нового клиента.
   *
   * @param client новый клиент
   * @return созданный клиент
   */
  @PostMapping
  @ResponseBody
  public ClientDto addClient(@Valid @RequestBody ClientDto client) {
    return clientService.addClient(client);
  }

  /**
   * Удаляет клиента по {@code id}.
   *
   * @param id {@code id} клиента
   */
  @DeleteMapping("/{id}")
  public void deleteClient(@PathVariable Integer id) {
    clientService.deleteClient(id);
  }

}
