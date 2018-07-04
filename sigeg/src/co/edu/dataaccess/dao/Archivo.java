package co.edu.dataaccess.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Archivo implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idArchivo;

	@NotBlank(message = "Nombre obligatorio")
	@Size(max = 200, message = "Nombre menor de 200 caracteres")
	private String nombre;

	@NotBlank(message = "Extensión obligatoria")
	@Size(max = 5, message = "Extensión menor de 5 caracteres")
	private String extension;

	@NotBlank(message = "Ruta obligatoria")
	@Size(max = 100, message = "Ruta menor de 100 caracteres")
	private String ruta;

	@NotNull(message = "Fecha Creación obligatoria")
	private Date fechaCreacion;

	public Long getIdArchivo() {
		return idArchivo;
	}

	public void setIdArchivo(Long idArchivo) {
		this.idArchivo = idArchivo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
