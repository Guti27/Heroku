package pe.edu.upc.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Trabajador")
public class Trabajador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTrabajador;

	@OneToOne
	@JoinColumn(name = "idPerson")
	private Person person;

	@ManyToOne
	@JoinColumn(name = "idTipoTrabajo")
	private TipoTrabajo tipoTrabajo;

	public Trabajador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Trabajador(int idTrabajador, Person person, TipoTrabajo tipoTrabajo) {
		super();
		this.idTrabajador = idTrabajador;
		this.person = person;
		this.tipoTrabajo = tipoTrabajo;
	}

	public int getIdTrabajador() {
		return idTrabajador;
	}

	public void setIdTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public TipoTrabajo getTipoTrabajo() {
		return tipoTrabajo;
	}

	public void setTipoTrabajo(TipoTrabajo tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

}
