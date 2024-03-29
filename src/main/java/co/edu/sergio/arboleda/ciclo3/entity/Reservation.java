package co.edu.sergio.arboleda.ciclo3.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idReservation;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Temporal(TemporalType.DATE)
	private Date devolutionDate;
	
	@ManyToOne
	@JoinColumn(name="quadbikeId")
	@JsonIgnoreProperties({"messages", "reservations"})
	private Quadbike quadbike;

	@ManyToOne
	@JoinColumn(name="clientId")
	@JsonIgnoreProperties({"messages", "reservations"})
	private Client client;
	
	private String score;
	
	public Integer getIdReservation() {
		return idReservation;
	}
	
	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}
	
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	
	public Date getDevolutionDate() {
		return devolutionDate;
	}
	
	public void setDevolutionDate(Date devolutionDate) {
		this.devolutionDate = devolutionDate;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public Quadbike getQuadbike() {
		return quadbike;
	}
	
	public void setQuadbike(Quadbike quadbike) {
		this.quadbike = quadbike;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}


	private static final long serialVersionUID = 1L;

}
