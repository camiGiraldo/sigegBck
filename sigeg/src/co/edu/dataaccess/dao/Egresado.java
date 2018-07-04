package co.edu.dataaccess.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Egresado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idEgresado;

	@NotBlank(message = "Nombres obligatorios")
	@Size(max = 70, message = "Nombres menor de 70 caracteres")
	private String nombres;

	@NotBlank(message = "Apellidos obligatorios")
	@Size(max = 70, message = "Apellidos menor de 70 caracteres")
	private String apellidos;

	@NotBlank(message = "Tipo Identificación obligatorio")
	@Size(max = 3, message = "Tipo Identificación menor de 3 caracteres")
	private String tipoIdentificacion;

	@NotBlank(message = "Identificación obligatoria")
	@Size(max = 12, message = "Identificación menor de 12 caracteres")
	private String identificacion;

	@NotBlank(message = "Ciudad Expedición obligatoria")
	@Size(max = 40, message = "Ciudad Expedición menor de 40 caracteres")
	private String ciudadExpedicion;

	@NotBlank(message = "Pais Residencia obligatorio")
	@Size(max = 60, message = "Pais Residencia menor de 60 caracteres")
	private String paisResidencia;

	@NotBlank(message = "Ciudad Residencia obligatoria")
	@Size(max = 40, message = "Ciudad Residencia menor de 40 caracteres")
	private String ciudadResidencia;

	@Size(max = 70, message = "Dirección Residencia menor de 70 caracteres")
	private String direccionResidencia;

	private Long telefonoFijo;
	private Long telefonoMovil;
	private Long telefonoMovilAlterno;

	@NotBlank(message = "Correo Electronico obligatorio")
	@Email(message = "Correo Electronico con formato inválido")
	@Size(max = 80, message = "Correo Electronico menor de 80 caracteres")
	private String correoElectronico;

	@Email(message = "Correo Electronico Alterno con formato inválido")
	@Size(max = 80, message = "Correo Electronico Alterno menor de 80 caracteres")
	private String correoElectronicoAlterno;

	@NotNull(message = "Fecha Creación obligatoria")
	private Date fechaCreacion;

	public Long getIdEgresado() {
		return idEgresado;
	}

	public void setIdEgresado(Long idEgresado) {
		this.idEgresado = idEgresado;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getCiudadExpedicion() {
		return ciudadExpedicion;
	}

	public void setCiudadExpedicion(String ciudadExpedicion) {
		this.ciudadExpedicion = ciudadExpedicion;
	}

	public String getPaisResidencia() {
		return paisResidencia;
	}

	public void setPaisResidencia(String paisResidencia) {
		this.paisResidencia = paisResidencia;
	}

	public String getCiudadResidencia() {
		return ciudadResidencia;
	}

	public void setCiudadResidencia(String ciudadResidencia) {
		this.ciudadResidencia = ciudadResidencia;
	}

	public String getDireccionResidencia() {
		return direccionResidencia;
	}

	public void setDireccionResidencia(String direccionResidencia) {
		this.direccionResidencia = direccionResidencia;
	}

	public Long getTelefonoFijo() {
		return telefonoFijo;
	}

	public void setTelefonoFijo(Long telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	public Long getTelefonoMovil() {
		return telefonoMovil;
	}

	public void setTelefonoMovil(Long telefonoMovil) {
		this.telefonoMovil = telefonoMovil;
	}

	public Long getTelefonoMovilAlterno() {
		return telefonoMovilAlterno;
	}

	public void setTelefonoMovilAlterno(Long telefonoMovilAlterno) {
		this.telefonoMovilAlterno = telefonoMovilAlterno;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getCorreoElectronicoAlterno() {
		return correoElectronicoAlterno;
	}

	public void setCorreoElectronicoAlterno(String correoElectronicoAlterno) {
		this.correoElectronicoAlterno = correoElectronicoAlterno;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
