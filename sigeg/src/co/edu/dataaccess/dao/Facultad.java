package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Facultad implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idFacultad;

	@NotBlank(message = "Nombre facultad obligatorio")
	@Size(max = 70, message = "Nombre facultad menor de 70 caracteres")
	private String nombre;

	@NotBlank(message = "Abreviaura facultad obligatorio")
	@Size(max = 6, message = "Abreviatura facultad menor de 6 caracteres")
	private String abreviatura;

	public Long getIdFacultad() {
		return idFacultad;
	}

	public void setIdFacultad(Long idFacultad) {
		this.idFacultad = idFacultad;
	}

	public String getNombre() {
		return nombre;
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
