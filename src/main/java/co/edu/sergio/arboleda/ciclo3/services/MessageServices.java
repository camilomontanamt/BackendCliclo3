package co.edu.sergio.arboleda.ciclo3.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sergio.arboleda.ciclo3.dao.IMessageDao;
import co.edu.sergio.arboleda.ciclo3.entity.Message;

@Service
public class MessageServices {

	@Autowired
	private IMessageDao messagueDao;
	
	public MessageServices() {
		// TODO Auto-generated constructor stub
	}
	
	@Transactional
	public List<Message> findAll() {
		return (List<Message>) messagueDao.findAll();
	}

	@Transactional
	public Optional<Message> findbyId(Integer idMessage) {
		return messagueDao.findById(idMessage);
	}

	@Transactional
	public Message saveCategory(Message message) {
		if (message.getIdMessage() == null) {
			return messagueDao.save(message);			
		} else {
			Optional<Message> paux = findbyId(message.getIdMessage());
			if (paux.isEmpty()) {
				return messagueDao.save(message);
			} else {
				return message;
			}
		}
	}

	@Transactional
	public void deleteCategory(Integer idMessage) {
		messagueDao.deleteById(idMessage);
	}

}
