package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TipoReconocimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idTipoReconocimiento;

	@NotBlank(message = "Nombre obligatorio")
	@Size(max = 30, message = "Nombre menor de 30 caracteres")
	private String nombre;

	@NotNull(message = "Activo obligatorio")
	@Min(value = 0, message = "Activo debe ser guardado como uno o cero")
	@Max(value = 1, message = "Activo debe ser guardado como uno o cero")
	private Long activo;

	public Long getIdTipoReconocimiento() {
		return idTipoReconocimiento;
	}

	public void setIdTipoReconocimiento(Long idTipoReconocimiento) {
		this.idTipoReconocimiento = idTipoReconocimiento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getActivo() {
		return activo;
	}

	public void setActivo(Long activo) {
		this.activo = activo;
	}

}
