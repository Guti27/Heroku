package pe.edu.upc.demo.Entities;

import java.util.Date;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "avisotrabajo")
public class AvisoTrabajo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idAvisoTrabajo;

	@ManyToOne
	@JoinColumn(name = "idTipoTrabajo")
	private TipoTrabajo tipoTrabajo;

	@ManyToOne
	@JoinColumn(name = "idempleador")
	private Empleador empleador;

	@NotNull(message = "La fecha es obligatoria")
	@FutureOrPresent(message = "La fecha debe estar en el futuro")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "fechaPublicacion")
	private Date fechaPublicacion;

	@NotNull(message = "Capo Vacio")
	@NotEmpty(message = "Ingresa la descripcion")
	@Size(min = 3, message = "Descripcion incompleta")
	@Column(name = "descripcionTrabajo", length = 50, nullable = false)
	private String descripcionTrabajo;

	public AvisoTrabajo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AvisoTrabajo(int idAvisoTrabajo, TipoTrabajo tipoTrabajo, Empleador empleador,
			@NotNull(message = "La fecha es obligatoria") @FutureOrPresent(message = "La fecha debe estar en el futuro") Date fechaPublicacion,
			@NotNull(message = "Capo Vacio") @NotEmpty(message = "Ingresa la descripcion") @Size(min = 3, message = "Descripcion incompleta") String descripcionTrabajo) {
		super();
		this.idAvisoTrabajo = idAvisoTrabajo;
		this.tipoTrabajo = tipoTrabajo;
		this.empleador = empleador;
		this.fechaPublicacion = fechaPublicacion;
		this.descripcionTrabajo = descripcionTrabajo;
	}

	public int getIdAvisoTrabajo() {
		return idAvisoTrabajo;
	}

	public void setIdAvisoTrabajo(int idAvisoTrabajo) {
		this.idAvisoTrabajo = idAvisoTrabajo;
	}

	public TipoTrabajo getTipoTrabajo() {
		return tipoTrabajo;
	}

	public void setTipoTrabajo(TipoTrabajo tipoTrabajo) {
		this.tipoTrabajo = tipoTrabajo;
	}

	public Empleador getEmpleador() {
		return empleador;
	}

	public void setEmpleador(Empleador empleador) {
		this.empleador = empleador;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public String getDescripcionTrabajo() {
		return descripcionTrabajo;
	}

	public void setDescripcionTrabajo(String descripcionTrabajo) {
		this.descripcionTrabajo = descripcionTrabajo;
	}

}
