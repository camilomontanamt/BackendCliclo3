package co.edu.sergio.arboleda.ciclo3.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.sergio.arboleda.ciclo3.dao.IReservationDao;
import co.edu.sergio.arboleda.ciclo3.entity.Reservation;

@Service
public class ReservationServices {
	
	@Autowired
	private IReservationDao reservationDao;

	public ReservationServices() {
		// TODO Auto-generated constructor stub
	}

	@Transactional
	public List<Reservation> findAll() {
		return (List<Reservation>) reservationDao.findAll();
	}

	@Transactional
	public Optional<Reservation> findbyId(Integer idReservation) {
		return reservationDao.findById(idReservation);
	}

	@Transactional
	public Reservation saveCategory(Reservation reservation) {
		if (reservation.getIdReservation() == null) {
			return reservationDao.save(reservation);			
		} else {
			Optional<Reservation> paux = findbyId(reservation.getIdReservation());
			if (paux.isEmpty()) {
				return reservationDao.save(reservation);
			} else {
				return reservation;
			}
		}
	}

	@Transactional
	public void deleteCategory(Integer idReservation) {
		reservationDao.deleteById(idReservation);
	}

}
