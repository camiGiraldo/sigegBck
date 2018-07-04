package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Programa implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idPrograma;

	@NotNull(message = "Id Facultad obligatorio")
	private Long idFacultad;

	@NotBlank(message = "Nombre obligatorio")
	@Size(max = 70, message = "Nombre menor de 70 caracteres")
	private String nombre;

	@NotBlank(message = "Abreviatura obligatorio")
	@Size(max = 6, message = "Abreviatura menor de 6 caracteres")
	private String abreviatura;

	public Long getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

	public Long getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(Long idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

}
