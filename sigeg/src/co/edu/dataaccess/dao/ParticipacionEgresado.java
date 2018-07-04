package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ParticipacionEgresado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idParticipacionEgresado;

	@NotNull(message = "Id Participación Democratica obligatorio")
	private Long idParticipacionDemocratica;

	@NotNull(message = "Id Egresado obligatorio")
	private Long idEgresado;

	@NotNull(message = "Inscrito obligatorio")
	@Min(value = 0, message = "Inscrito debe ser guardado como uno o cero")
	@Max(value = 1, message = "Inscrito debe ser guardado como uno o cero")
	private Long inscrito;

	@NotNull(message = "Elegido obligatorio")
	@Min(value = 0, message = "Elegido debe ser guardado como uno o cero")
	@Max(value = 1, message = "Elegido debe ser guardado como uno o cero")
	private Long elegido;

	@NotNull(message = "Socio Fundador obligatorio")
	@Min(value = 0, message = "Socio Fundador debe ser guardado como uno o cero")
	@Max(value = 1, message = "Socio Fundador debe ser guardado como uno o cero")
	private Long socioFundador;

	@NotNull(message = "Socio Adherente obligatorio")
	@Min(value = 0, message = "Socio Adherente debe ser guardado como uno o cero")
	@Max(value = 1, message = "Socio Adherente debe ser guardado como uno o cero")
	private Long socioAdherente;

	@NotNull(message = "Beneficiario obligatorio")
	@Min(value = 0, message = "Beneficiario debe ser guardado como uno o cero")
	@Max(value = 1, message = "Beneficiario debe ser guardado como uno o cero")
	private Long beneficiario;

	public Long getIdParticipacionEgresado() {
		return idParticipacionEgresado;
	}

	public void setIdParticipacionEgresado(Long idParticipacionEgresado) {
		this.idParticipacionEgresado = idParticipacionEgresado;
	}

	public Long getIdParticipacionDemocratica() {
		return idParticipacionDemocratica;
	}

	public void setIdParticipacionDemocratica(Long idParticipacionDemocratica) {
		this.idParticipacionDemocratica = idParticipacionDemocratica;
	}

	public Long getIdEgresado() {
		return idEgresado;
	}

	public void setIdEgresado(Long idEgresado) {
		this.idEgresado = idEgresado;
	}

	public Long getInscrito() {
		return inscrito;
	}

	public void setInscrito(Long inscrito) {
		this.inscrito = inscrito;
	}

	public Long getElegido() {
		return elegido;
	}

	public void setElegido(Long elegido) {
		this.elegido = elegido;
	}

	public Long getSocioFundador() {
		return socioFundador;
	}

	public void setSocioFundador(Long socioFundador) {
		this.socioFundador = socioFundador;
	}

	public Long getSocioAdherente() {
		return socioAdherente;
	}

	public void setSocioAdherente(Long socioAdherente) {
		this.socioAdherente = socioAdherente;
	}

	public Long getBeneficiario() {
		return beneficiario;
	}

	public void setBeneficiario(Long beneficiario) {
		this.beneficiario = beneficiario;
	}

}
