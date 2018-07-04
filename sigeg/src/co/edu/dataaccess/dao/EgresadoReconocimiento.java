package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EgresadoReconocimiento implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idEgresadoReconocimiento;

	@NotNull(message = "Id Reconocimiento obligatorio")
	private Long idReconocimiento;

	@NotNull(message = "Id Egresado obligatorio")
	private Long idEgresado;

	@NotNull(message = "Distinguido obligatorio")
	@Min(value = 0, message = "Distinguido debe ser guardado como uno o cero")
	@Max(value = 1, message = "Distinguido debe ser guardado como uno o cero")
	private Long distinguido;

	@NotNull(message = "Vinculado Laboralmente obligatorio")
	@Min(value = 0, message = "Vinculado Laboralmente debe ser guardado como uno o cero")
	@Max(value = 1, message = "Vinculado Laboralmente debe ser guardado como uno o cero")
	private Long vinculadoLaboralmente;

	@NotNull(message = "Logro Publicado obligatorio")
	@Min(value = 0, message = "Logro Publicado debe ser guardado como uno o cero")
	@Max(value = 1, message = "Logro Publicado debe ser guardado como uno o cero")
	private Long logroPublicado;

	@Size(max = 1000, message = "Url Externa menor de 1000 caracteres")
	private String urlExterna;
	private Long soporte;

	public Long getIdEgresadoReconocimiento() {
		return idEgresadoReconocimiento;
	}

	public void setIdEgresadoReconocimiento(Long idEgresadoReconocimiento) {
		this.idEgresadoReconocimiento = idEgresadoReconocimiento;
	}

	public Long getIdReconocimiento() {
		return idReconocimiento;
	}

	public void setIdReconocimiento(Long idReconocimiento) {
		this.idReconocimiento = idReconocimiento;
	}

	public Long getIdEgresado() {
		return idEgresado;
	}

	public void setIdEgresado(Long idEgresado) {
		this.idEgresado = idEgresado;
	}

	public Long getDistinguido() {
		return distinguido;
	}

	public void setDistinguido(Long distinguido) {
		this.distinguido = distinguido;
	}

	public Long getVinculadoLaboralmente() {
		return vinculadoLaboralmente;
	}

	public void setVinculadoLaboralmente(Long vinculadoLaboralmente) {
		this.vinculadoLaboralmente = vinculadoLaboralmente;
	}

	public Long getLogroPublicado() {
		return logroPublicado;
	}

	public void setLogroPublicado(Long logroPublicado) {
		this.logroPublicado = logroPublicado;
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
