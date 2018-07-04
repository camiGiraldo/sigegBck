package co.edu.dataaccess.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idEvento;

	@NotNull(message = "Id Tipo Evento obligatorio")
	private Long idTipoEvento;

	@NotBlank(message = "Nombre obligatorio")
	@Size(max = 100, message = "Nombre menor de 100 caracteres")
	private String nombre;

	@NotNull(message = "Fecha Inicio obligatoria")
	private Date fechaInicio;
	private Date fechaFin;

	@NotBlank(message = "Lugar obligatorio")
	@Size(max = 100, message = "Lugar menor de 100 caracteres")
	private String lugar;

	@NotBlank(message = "Hora Inicio obligatoria")
	@Size(max = 8, message = "Hora Inicio menor de 8 caracteres")
	private String horaInicio;

	@Size(max = 20, message = "Duración Estimada menor de 20 caracteres")
	private String duracionEstimada;

	@NotNull(message = "Costo Egresado obligatorio")
	private Long costoEgresado;

	@NotNull(message = "Costo Uniajc obligatorio")
	private Long costoUniajc;

	@Min(value = 0, message = "Certificable debe ser guardado como uno o cero")
	@Max(value = 1, message = "Certificable debe ser guardado como uno o cero")
	private Long certificable;

	@NotBlank(message = "Dependencia Organiza obligatoria")
	@Size(max = 100, message = "Dependencia Organiza menor de 100 caracteres")
	private String dependenciaOrganiza;

	@Size(max = 100, message = "Dependencia Beneficiaria menor de 100 caracteres")
	private String dependenciaBeneficiaria;

	@Size(max = 100, message = "Comunidad Beneficiaria menor de 100 caracteres")
	private String comunidadBeneficiaria;

	@Size(max = 70, message = "Persona A Cargo menor de 70 caracteres")
	private String personaACargo;

	@Email(message = "Correo Electronico con formato inválido")
	@Size(max = 100, message = "Correo Electronico menor de 100 caracteres")
	private String correoElectronico;

	@Size(max = 10, message = "Telefono menor de 10 caracteres")
	private String telefono;
	private Long cuposEgresados;

	@NotNull(message = "Banner Evento obligatorio")
	private Long bannerEvento;

	@Size(max = 500, message = "Url Inscripcion menor de 500 caracteres")
	private String urlInscripcion;

	@Size(max = 1000, message = "Url Externa menor de 1000 caracteres")
	private String urlExterna;
	private Long soporte;

	@NotNull(message = "Fecha Creación obligatoria")
	private Date fechaCreacion;

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Long getIdTipoEvento() {
		return idTipoEvento;
	}

	public void setIdTipoEvento(Long idTipoEvento) {
		this.idTipoEvento = idTipoEvento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getDuracionEstimada() {
		return duracionEstimada;
	}

	public void setDuracionEstimada(String duracionEstimada) {
		this.duracionEstimada = duracionEstimada;
	}

	public Long getCostoEgresado() {
		return costoEgresado;
	}

	public void setCostoEgresado(Long costoEgresado) {
		this.costoEgresado = costoEgresado;
	}

	public Long getCostoUniajc() {
		return costoUniajc;
	}

	public void setCostoUniajc(Long costoUniajc) {
		this.costoUniajc = costoUniajc;
	}

	public Long getCertificable() {
		return certificable;
	}

	public void setCertificable(Long certificable) {
		this.certificable = certificable;
	}

	public String getDependenciaOrganiza() {
		return dependenciaOrganiza;
	}

	public void setDependenciaOrganiza(String dependenciaOrganiza) {
		this.dependenciaOrganiza = dependenciaOrganiza;
	}

	public String getDependenciaBeneficiaria() {
		return dependenciaBeneficiaria;
	}

	public void setDependenciaBeneficiaria(String dependenciaBeneficiaria) {
		this.dependenciaBeneficiaria = dependenciaBeneficiaria;
	}

	public String getComunidadBeneficiaria() {
		return comunidadBeneficiaria;
	}

	public void setComunidadBeneficiaria(String comunidadBeneficiaria) {
		this.comunidadBeneficiaria = comunidadBeneficiaria;
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

	public Long getCuposEgresados() {
		return cuposEgresados;
	}

	public void setCuposEgresados(Long cuposEgresados) {
		this.cuposEgresados = cuposEgresados;
	}

	public Long getBannerEvento() {
		return bannerEvento;
	}

	public void setBannerEvento(Long bannerEvento) {
		this.bannerEvento = bannerEvento;
	}

	public String getUrlInscripcion() {
		return urlInscripcion;
	}

	public void setUrlInscripcion(String urlInscripcion) {
		this.urlInscripcion = urlInscripcion;
	}

	public String getUrlExterna() {
		return urlExterna;
	}

	public void setUrlExterna(String urlExterna) {
		this.urlExterna = urlExterna;
	}

	public Long getSoporte() {
		return soporte;
	}

	public void setSoporte(Long soporte) {
		this.soporte = soporte;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
