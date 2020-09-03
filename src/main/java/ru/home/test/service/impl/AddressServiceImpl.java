package ru.home.test.service.impl;

import static java.util.stream.Collectors.toSet;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.test.converter.AddressMapper;
import ru.home.test.dao.AddressDao;
import ru.home.test.dao.ClientDao;
import ru.home.test.dto.AddressDto;
import ru.home.test.entity.AddressEntity;
import ru.home.test.entity.ClientEntity;
import ru.home.test.service.AddressService;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {

  private static final String INVALID_CLIENT_ID_MSG = "Invalid client id";

  @Autowired
  private AddressDao addressDao;

  @Autowired
  private ClientDao clientDao;

  @Autowired
  private AddressMapper addressMapper;

  @Override
  public Set<AddressDto> findAddressByClientId(Integer clientId) {
    return addressDao.findByClientId(clientId)
                     .stream()
                     .map(addressMapper::entityToDto)
                     .collect(toSet());
  }

  @Override
  public AddressDto saveAddressByClientId(Integer clientId, AddressDto address) {
    AddressEntity addressToSave = addressMapper.dtoToEntity(address);
    ClientEntity client = clientDao.findById(clientId)
                                   .orElseThrow(
                                       () -> new IllegalArgumentException(INVALID_CLIENT_ID_MSG));
    addressToSave.setClient(client);

    AddressEntity savedAddress = addressDao.save(addressToSave);
    address.setId(savedAddress.getId());

    return address;
  }

}
