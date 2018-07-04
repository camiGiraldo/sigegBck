package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EgresadoAporte implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idEgresadoAporte;

	@NotNull(message = "Id Aporte Investigación obligatorio")
	private Long idAporteInvestigacion;

	@NotNull(message = "Id Egresado obligatorio")
	private Long idEgresado;

	@NotBlank(message = "Participación obligatorio")
	@Size(max = 1000, message = "Participación menor de 1000 caracteres")
	private String participacion;

	@Size(max = 1000, message = "Url Externa menor de 1000 caracteres")
	private String urlExterna;
	private Long soporte;

	public Long getIdEgresadoAporte() {
		return idEgresadoAporte;
	}

	public void setIdEgresadoAporte(Long idEgresadoAporte) {
		this.idEgresadoAporte = idEgresadoAporte;
	}

	public Long getIdAporteInvestigacion() {
		return idAporteInvestigacion;
	}

	public void setIdAporteInvestigacion(Long idAporteInvestigacion) {
		this.idAporteInvestigacion = idAporteInvestigacion;
	}

	public Long getIdEgresado() {
		return idEgresado;
	}

	public void setIdEgresado(Long idEgresado) {
		this.idEgresado = idEgresado;
	}

	public String getParticipacion() {
		return participacion;
	}

	public void setParticipacion(String participacion) {
		this.participacion = participacion;
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

}
