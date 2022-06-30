package pe.edu.upc.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleador")
public class Empleador {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int idEmpleador;

	@OneToOne
	@JoinColumn(name = "idPerson")
	private Person person;

	public Empleador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Empleador(int idEmpleador, Person person) {
		super();
		this.idEmpleador = idEmpleador;
		this.person = person;
	}

	public int getIdEmpleador() {
		return idEmpleador;
	}

	public void setIdEmpleador(int idEmpleador) {
		this.idEmpleador = idEmpleador;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

}
