package co.edu.dataaccess.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AporteInvestigacion implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idAporteInvestigacion;

	@NotNull(message = "Id Tipo Aporte obligatorio")
	private Long idTipoAporte;

	@NotNull(message = "Fecha Realización obligatoria")
	private Date fechaRealizacion;
	private Date fechaFinalizacion;

	@NotBlank(message = "Grupo Beneficiario obligatorio")
	@Size(max = 100, message = "Grupo Beneficiario menor de 100 caracteres")
	private String grupoBeneficiario;

	@Size(max = 100, message = "Sub Grupo Beneficiario menor de 100 caracteres")
	private String subGrupoBeneficiario;

	@NotBlank(message = "Nombre Proyecto obligatorio")
	@Size(max = 100, message = "Nombre Proyecto menor de 100 caracteres")
	private String nombreProyecto;

	@Size(max = 300, message = "Descripción Proyecto menor de 300 caracteres")
	private String descripcionProyecto;

	@Size(max = 70, message = "Persona A Cargo menor de 70 caracteres")
	private String personaACargo;

	@Size(max = 50, message = "Correo Electronico menor de 50 caracteres")
	@Email(message = "Correo Electronico con formato inválido")
	private String correoElectronico;

	@Size(max = 10, message = "Telefono menor de 10 caracteres")
	private String telefono;

	private Long adjunto;

	@NotNull(message = "Fecha Creación obligatoria")
	private Date fechaCreacion;

	public Long getIdAporteInvestigacion() {
		return idAporteInvestigacion;
	}

	public void setIdAporteInvestigacion(Long idAporteInvestigacion) {
		this.idAporteInvestigacion = idAporteInvestigacion;
	}

	public Long getIdTipoAporte() {
		return idTipoAporte;
	}

	public void setIdTipoAporte(Long idTipoAporte) {
		this.idTipoAporte = idTipoAporte;
	}

	public Date getFechaRealizacion() {
		return fechaRealizacion;
	}

	public void setFechaRealizacion(Date fechaRealizacion) {
		this.fechaRealizacion = fechaRealizacion;
	}

	public Date getFechaFinalizacion() {
		return fechaFinalizacion;
	}

	public void setFechaFinalizacion(Date fechaFinalizacion) {
		this.fechaFinalizacion = fechaFinalizacion;
	}

	public String getGrupoBeneficiario() {
		return grupoBeneficiario;
	}

	public void setGrupoBeneficiario(String grupoBeneficiario) {
		this.grupoBeneficiario = grupoBeneficiario;
	}

	public String getSubGrupoBeneficiario() {
		return subGrupoBeneficiario;
	}

	public void setSubGrupoBeneficiario(String subGrupoBeneficiario) {
		this.subGrupoBeneficiario = subGrupoBeneficiario;
	}

	public String getNombreProyecto() {
		return nombreProyecto;
	}

	public void setNombreProyecto(String nombreProyecto) {
		this.nombreProyecto = nombreProyecto;
	}

	public String getDescripcionProyecto() {
		return descripcionProyecto;
	}

	public void setDescripcionProyecto(String descripcionProyecto) {
		this.descripcionProyecto = descripcionProyecto;
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

	public Long getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(Long adjunto) {
		this.adjunto = adjunto;
	}

	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

}
