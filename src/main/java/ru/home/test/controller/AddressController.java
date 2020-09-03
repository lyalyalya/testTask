package ru.home.test.controller;

import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.home.test.dto.AddressDto;
import ru.home.test.service.AddressService;

/**
 * Контроллер для адресов.
 */
@RestController
@RequestMapping(path = "addresses", produces = MediaType.APPLICATION_JSON_VALUE)
public class AddressController {

  @Autowired
  private AddressService addressService;

  /**
   * Возвращает список адресов клиента по {@code id} клиента.
   *
   * @param clientId {@code id} клиента
   * @return список адресов
   */
  @GetMapping
  @ResponseBody
  public Set<AddressDto> findByClientId(@RequestParam Integer clientId) {
    return addressService.findAddressByClientId(clientId);
  }

  /**
   * Сохраняет новый адрес для клиента по {@code id} клиента.
   *
   * @param address адрес для сохранения
   * @param clientId {@code id} клиента
   * @return созданный адрес
   */
  @PostMapping
  @ResponseBody
  public AddressDto addAddress(@RequestParam Integer clientId,
                               @Valid @RequestBody AddressDto address) {
    return addressService.saveAddressByClientId(clientId, address);
  }

}
