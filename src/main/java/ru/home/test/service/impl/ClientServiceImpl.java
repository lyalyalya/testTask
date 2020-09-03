package ru.home.test.service.impl;

import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.test.converter.ClientMapper;
import ru.home.test.dao.ClientDao;
import ru.home.test.dto.ClientDto;
import ru.home.test.entity.ClientEntity;
import ru.home.test.service.ClientService;

@Service
@Transactional
public class ClientServiceImpl implements ClientService {

  @Autowired
  private ClientDao clientDao;

  @Autowired
  private ClientMapper clientMapper;

  @Override
  public Set<ClientDto> findAllClients() {
    return clientDao.findAll()
                    .stream()
                    .map(clientMapper::entityToDto)
                    .collect(Collectors.toSet());
  }

  public Set<ClientDto> findClientsByNameContains(String part) {
    return clientDao.findByNameContains(part)
                    .stream()
                    .map(clientMapper::entityToDto)
                    .collect(Collectors.toSet());
  }

  @Override
  public ClientDto addClient(ClientDto client) {
    ClientEntity clientToSave = clientMapper.dtoToEntity(client);

    ClientEntity savedClient = clientDao.save(clientToSave);
    client.setId(savedClient.getId());

    return client;
  }

  @Override
  public void deleteClient(Integer id) {
    clientDao.deleteById(id);
  }

}
