package co.edu.dataaccess.dao;

import java.io.Serializable;
import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InformacionControl implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idInformacionControl;

	@NotNull(message = "Id Egresado obligatorio")
	private Long idEgresado;
	private Date fechaEntregaCarnet;
	private Date encuestaM0En;
	private Date encuestaM1En;
	private Date encuestaM5En;

	@NotBlank(message = "Grado Academusoft obligatorio")
	@Size(max = 20, message = "Grado Academusoft menor de 20 caracteres")
	private String gradoAcademusoft;

	@Min(value = 0, message = "Recibe Informacion debe ser guardado como uno o cero")
	@Max(value = 1, message = "Recibe Informacion debe ser guardado como uno o cero")
	private Long recibeInformacion;

	@Size(max = 100, message = "Tipo Información menor de 100 caracteres")
	private String tipoInformacion;

	@Size(max = 200, message = "Observación Correo menor de 200 caracteres")
	private String observacionCorreo;

	@Size(max = 200, message = "Observaciones Generales menor de 200 caracteres")
	private String observacionesGenerales;

	public Long getIdInformacionControl() {
		return idInformacionControl;
	}

	public void setIdInformacionControl(Long idInformacionControl) {
		this.idInformacionControl = idInformacionControl;
	}

	public Long getIdEgresado() {
		return idEgresado;
	}

	public void setIdEgresado(Long idEgresado) {
		this.idEgresado = idEgresado;
	}

	public Date getFechaEntregaCarnet() {
		return fechaEntregaCarnet;
	}

	public void setFechaEntregaCarnet(Date fechaEntregaCarnet) {
		this.fechaEntregaCarnet = fechaEntregaCarnet;
	}

	public Date getEncuestaM0En() {
		return encuestaM0En;
	}

	public void setEncuestaM0En(Date encuestaM0En) {
		this.encuestaM0En = encuestaM0En;
	}

	public Date getEncuestaM1En() {
		return encuestaM1En;
	}

	public void setEncuestaM1En(Date encuestaM1En) {
		this.encuestaM1En = encuestaM1En;
	}

	public Date getEncuestaM5En() {
		return encuestaM5En;
	}

	public void setEncuestaM5En(Date encuestaM5En) {
		this.encuestaM5En = encuestaM5En;
	}

	public String getGradoAcademusoft() {
		return gradoAcademusoft;
	}

	public void setGradoAcademusoft(String gradoAcademusoft) {
		this.gradoAcademusoft = gradoAcademusoft;
	}

	public Long getRecibeInformacion() {
		return recibeInformacion;
	}

	public void setRecibeInformacion(Long recibeInformacion) {
		this.recibeInformacion = recibeInformacion;
	}

	public String getTipoInformacion() {
		return tipoInformacion;
	}

	public void setTipoInformacion(String tipoInformacion) {
		this.tipoInformacion = tipoInformacion;
	}

	public String getObservacionCorreo() {
		return observacionCorreo;
	}

	public void setObservacionCorreo(String observacionCorreo) {
		this.observacionCorreo = observacionCorreo;
	}

	public String getObservacionesGenerales() {
		return observacionesGenerales;
	}

	public void setObservacionesGenerales(String observacionesGenerales) {
		this.observacionesGenerales = observacionesGenerales;
	}

}
