package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TipoEvento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idTipoEvento;

	@NotNull(message = "Id Categoria Evento obligatorio")
	private Long idCategoriaEvento;

	@NotBlank(message = "Nombre obligatorio")
	@Size(max = 70, message = "Nombre menor de 70 caracteres")
	private String nombre;

	@NotNull(message = "Activo obligatorio")
	@Min(value = 0, message = "Activo debe ser guardado como uno o cero")
	@Max(value = 1, message = "Activo debe ser guardado como uno o cero")
	private Long activo;

	public Long getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(Long idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public Long getIdCategoriaEvento() {
		return idCategoriaEvento;
	}

	public void setIdCategoriaEvento(Long idCategoriaEvento) {
		this.idCategoriaEvento = idCategoriaEvento;
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
