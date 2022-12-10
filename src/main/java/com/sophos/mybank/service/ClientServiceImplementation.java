package com.sophos.mybank.service;

import com.sophos.mybank.entity.Client;
import com.sophos.mybank.repository.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImplementation implements IClientService {
    @Autowired
    IClientRepository iClientRepository;

    @Override
    public Client createClient(Client client) {
        return iClientRepository.save(client);
    }

    // Listar todos los clientes
    @Override
    public List<Client> getAllClients() {
        return iClientRepository.findAll();
    }

    @Override
    public Optional<Client> getClientById(Integer id) {
        return iClientRepository.findById(id);
    }

    @Override
    public Optional<Client> updateClientById(Client client) {
        Optional<Client> optionalClient = iClientRepository.findById(client.getId());
        if (optionalClient.isPresent()) {
            Client updatedClient = optionalClient.get();
            iClientRepository.save(updatedClient);
            return Optional.ofNullable(updatedClient);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteClientById(Integer id) {
        return getClientById(id).map(book -> {
            iClientRepository.deleteById(id);
            return true;
        }).orElse(false);
    }
}
