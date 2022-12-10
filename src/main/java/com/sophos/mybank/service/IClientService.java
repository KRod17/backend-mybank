package com.sophos.mybank.service;

import com.sophos.mybank.entity.Client;

import java.util.List;
import java.util.Optional;

public interface IClientService {
    public Client createClient(Client client);
    public List<Client> getAllClients();
    public Optional<Client> getClientById(Integer id);
    public Optional<Client> updateClientById(Client client);
    public boolean deleteClientById(Integer id);
}
