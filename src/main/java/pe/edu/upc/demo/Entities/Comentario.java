package pe.edu.upc.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comentario")
public class Comentario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idComentario;

	@ManyToOne
	@JoinColumn(name = "idContrato")
	private Contrato contrato;

	@ManyToOne
	@JoinColumn(name = "idempleador")
	private Empleador empleador;

	@Column(name = "addComentario")
	private String addComentario;

	@Column(name = "addCalificacion")
	private String addCalificacion;

	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comentario(int idComentario, Contrato contrato, Empleador empleador, String addComentario,
			String addCalificacion) {
		super();
		this.idComentario = idComentario;
		this.contrato = contrato;
		this.empleador = empleador;
		this.addComentario = addComentario;
		this.addCalificacion = addCalificacion;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public Contrato getContrato() {
		return contrato;
	}

	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	public String getAddComentario() {
		return addComentario;
	}

	public void setAddComentario(String addComentario) {
		this.addComentario = addComentario;
	}

	public String getAddCalificacion() {
		return addCalificacion;
	}

	public void setAddCalificacion(String addCalificacion) {
		this.addCalificacion = addCalificacion;
	}

}
