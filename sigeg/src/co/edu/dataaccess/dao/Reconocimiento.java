package co.edu.dataaccess.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Reconocimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idReconocimiento;

	@NotNull(message = "Id Tipo Reconocimiento obligatorio")
	private Long idTipoReconocimiento;
	private Long adjunto;

	@NotNull(message = "Fecha Vinculacion obligatoria")
	private Date fechaVinculacion;

	@NotBlank(message = "Lugar Realización obligatorio")
	@Size(max = 100, message = "Lugar Realización menor de 100 caracteres")
	private String lugarRealizacion;

	@Size(max = 100, message = "Beneficiario menor de 100 caracteres")
	private String beneficiario;

	@Size(max = 200, message = "Descripción menor de 200 caracteres")
	private String descripcion;
	private Long soporte;

	@NotNull(message = "Fecha Creación obligatoria")
	private Date fechaCreacion;

	public Long getIdReconocimiento() {
		return idReconocimiento;
	}

	public void setIdReconocimiento(Long idReconocimiento) {
		this.idReconocimiento = idReconocimiento;
	}

	public Long getIdTipoReconocimiento() {
		return idTipoReconocimiento;
	}

	public void setIdTipoReconocimiento(Long idTipoReconocimiento) {
		this.idTipoReconocimiento = idTipoReconocimiento;
	}

	public Long getAdjunto() {
		return adjunto;
	}

	public void setAdjunto(Long adjunto) {
		this.adjunto = adjunto;
	}

	public Date getFechaVinculacion() {
		return fechaVinculacion;
	}

	public void setFechaVinculacion(Date fechaVinculacion) {
		this.fechaVinculacion = fechaVinculacion;
	}

	public String getLugarRealizacion() {
		return lugarRealizacion;
	}

	public void setLugarRealizacion(String lugarRealizacion) {
		this.lugarRealizacion = lugarRealizacion;
	}

	public String getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(String beneficiario) {
		this.beneficiario = beneficiario;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
