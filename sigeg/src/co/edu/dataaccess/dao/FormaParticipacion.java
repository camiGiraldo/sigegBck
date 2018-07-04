package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FormaParticipacion implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idFormaParticipacion;

	@NotBlank(message = "Nombre obligatorio")
	@Size(max = 100, message = "Nombre menor de 100 caracteres")
	private String nombre;

	@NotNull(message = "Activo obligatorio")
	@Min(value = 0, message = "Activo debe ser guardado como uno o cero")
	@Max(value = 1, message = "Activo debe ser guardado como uno o cero")
	private Long activo;

	public Long getIdFormaParticipacion() {
		return idFormaParticipacion;
	}

	public void setIdFormaParticipacion(Long idFormaParticipacion) {
		this.idFormaParticipacion = idFormaParticipacion;
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
