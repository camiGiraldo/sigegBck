package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AsistenciaEvento implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long idAsistenciaEvento;

	@NotNull(message = "Id Egresado obligatorio")
	private Long idEgresado;

	@NotNull(message = "Id Evento obligatorio")
	private Long idEvento;

	@NotNull(message = "Inscrito obligatorio")
	@Min(value = 0, message = "Inscrito debe ser guardado como uno o cero")
	@Max(value = 1, message = "Inscrito debe ser guardado como uno o cero")
	private Long inscrito;

	@NotNull(message = "Asistio obligatorio")
	@Min(value = 0, message = "Asistio debe ser guardado como uno o cero")
	@Max(value = 1, message = "Asistio debe ser guardado como uno o cero")
	private Long asistio;

	@NotNull(message = "Aprobo obligatorio")
	@Min(value = 0, message = "Aprobo debe ser guardado como uno o cero")
	@Max(value = 1, message = "Aprobo debe ser guardado como uno o cero")
	private Long aprobo;

	public Long getIdAsistenciaEvento() {
		return idAsistenciaEvento;
	}

	public void setIdAsistenciaEvento(Long idAsistenciaEvento) {
		this.idAsistenciaEvento = idAsistenciaEvento;
	}

	public Long getIdEgresado() {
		return idEgresado;
	}

	public void setIdEgresado(Long idEgresado) {
		this.idEgresado = idEgresado;
	}

	public Long getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(Long idEvento) {
		this.idEvento = idEvento;
	}

	public Long getInscrito() {
		return inscrito;
	}

	public void setInscrito(Long inscrito) {
		this.inscrito = inscrito;
	}

	public Long getAsistio() {
		return asistio;
	}

	public void setAsistio(Long asistio) {
		this.asistio = asistio;
	}

	public Long getAprobo() {
		return aprobo;
	}

	public void setAprobo(Long aprobo) {
		this.aprobo = aprobo;
	}

}
