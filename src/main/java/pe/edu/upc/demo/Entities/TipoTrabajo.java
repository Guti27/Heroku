package pe.edu.upc.demo.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipotrabajo")
public class TipoTrabajo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTipoTrabajo;

	@Column(name = "rubro", length = 48, nullable = false)
	private String rubro;

	@Column(name = "especialidad", length = 48, nullable = false)
	private String especialidad;

	@Column(name = "carrera", length = 48, nullable = false)
	private String carrera;

	public TipoTrabajo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TipoTrabajo(int idTipoTrabajo, String rubro, String especialidad, String carrera) {
		super();
		this.idTipoTrabajo = idTipoTrabajo;
		this.rubro = rubro;
		this.especialidad = especialidad;
		this.carrera = carrera;
	}

	public int getIdTipoTrabajo() {
		return idTipoTrabajo;
	}

	public void setIdTipoTrabajo(int idTipoTrabajo) {
		this.idTipoTrabajo = idTipoTrabajo;
	}

	public String getRubro() {
		return rubro;
	}

	public void setRubro(String rubro) {
		this.rubro = rubro;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

}
