package co.edu.sergio.arboleda.ciclo3.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sergio.arboleda.ciclo3.dao.IClientDao;
import co.edu.sergio.arboleda.ciclo3.entity.Client;

@Service
public class ClientServices {

	@Autowired
	private IClientDao clientDao;
	
	public ClientServices() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public List<Client> findAll() {
		return (List<Client>) clientDao.findAll();
	}

	@Transactional
	public Optional<Client> findbyId(Integer idClient) {
		return clientDao.findById(idClient);
	}

	@Transactional
	public Client saveCategory(Client client) {
		if (client.getIdClient() == null) {
			return clientDao.save(client);			
		} else {
			Optional<Client> paux = findbyId(client.getIdClient());
			if (paux.isEmpty()) {
				return clientDao.save(client);
			} else {
				return client;
			}
		}
	}

	@Transactional
	public void deleteCategory(Integer idClient) {
		clientDao.deleteById(idClient);
	}
	
}
