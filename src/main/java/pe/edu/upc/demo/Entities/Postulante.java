package pe.edu.upc.demo.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "postulante")
public class Postulante {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idPostulante;

	@ManyToOne
	@JoinColumn(name = "avisoTrabajo")
	private AvisoTrabajo avisoTrabajo;

	@ManyToOne
	@JoinColumn(name = "trabajador")
	private Trabajador trabajador;

	public Postulante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Postulante(int idPostulante, AvisoTrabajo avisoTrabajo, Trabajador trabajador) {
		super();
		this.idPostulante = idPostulante;
		this.avisoTrabajo = avisoTrabajo;
		this.trabajador = trabajador;
	}

	public int getIdPostulante() {
		return idPostulante;
	}

	public void setIdPostulante(int idPostulante) {
		this.idPostulante = idPostulante;
	}

	public AvisoTrabajo getAvisoTrabajo() {
		return avisoTrabajo;
	}

	public void setAvisoTrabajo(AvisoTrabajo avisoTrabajo) {
		this.avisoTrabajo = avisoTrabajo;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}

}
