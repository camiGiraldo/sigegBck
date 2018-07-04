package co.edu.dataaccess.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ParticipacionDemocratica implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idParticipacionDemocratica;

	@NotNull(message = "Id Forma Participación obligatorio")
	private Long idFormaParticipacion;

	@NotBlank(message = "Organo Gremial obligatorio")
	@Size(max = 100, message = "Organo Gremial menor de 100 caracteres")
	private String organoGremial;
	private Date fechaInscripcion;

	@NotNull(message = "Fecha Elección obligatoria")
	private Date fechaEleccion;

	@NotBlank(message = "Vigencia obligatoria")
	@Size(max = 30, message = "Vigencia menor de 30 caracteres")
	private String vigencia;
	private Date fechaLimite;

	@Size(max = 50, message = "Dependencia Supervisa menor de 50 caracteres")
	private String dependenciaSupervisa;

	@Size(max = 70, message = "Persona A Cargo menor de 70 caracteres")
	private String personaACargo;

	@Email(message = "Correo Electronico con formato inválido")
	@Size(max = 50, message = "CorreoElectronico menor de 50 caracteres")
	private String correoElectronico;

	@Size(max = 30, message = "Telefono menor de 30 caracteres")
	private String telefono;

	@Size(max = 300, message = "Enlace Votaciones menor de 300 caracteres")
	private String enlaceVotaciones;
	private Date fechaCreacion;

	public Long getIdParticipacionDemocratica() {
		return idParticipacionDemocratica;
	}

	public void setIdParticipacionDemocratica(Long idParticipacionDemocratica) {
		this.idParticipacionDemocratica = idParticipacionDemocratica;
	}

	public Long getIdFormaParticipacion() {
		return idFormaParticipacion;
	}

	public void setIdFormaParticipacion(Long idFormaParticipacion) {
		this.idFormaParticipacion = idFormaParticipacion;
	}

	public String getOrganoGremial() {
		return organoGremial;
	}

	public void setOrganoGremial(String organoGremial) {
		this.organoGremial = organoGremial;
	}

	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Date getFechaEleccion() {
		return fechaEleccion;
	}

	public void setFechaEleccion(Date fechaEleccion) {
		this.fechaEleccion = fechaEleccion;
	}

	public String getVigencia() {
		return vigencia;
	}

	public void setVigencia(String vigencia) {
		this.vigencia = vigencia;
	}

	public Date getFechaLimite() {
		return fechaLimite;
	}

	public void setFechaLimite(Date fechaLimite) {
		this.fechaLimite = fechaLimite;
	}

	public String getDependenciaSupervisa() {
		return dependenciaSupervisa;
	}

	public void setDependenciaSupervisa(String dependenciaSupervisa) {
		this.dependenciaSupervisa = dependenciaSupervisa;
	}

	public String getPersonaACargo() {
		return personaACargo;
	}

	public void setPersonaACargo(String personaACargo) {
		this.personaACargo = personaACargo;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEnlaceVotaciones() {
		return enlaceVotaciones;
	}

	public void setEnlaceVotaciones(String enlaceVotaciones) {
		this.enlaceVotaciones = enlaceVotaciones;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
