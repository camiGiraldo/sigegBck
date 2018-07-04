package co.edu.dataaccess.dao;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class InformacionAcademica implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idInformacionAcademica;

	@NotNull(message = "Id Egresado obligatorio")
	private Long idEgresado;

	@NotNull(message = "Id Programa obligatorio")
	private Long idPrograma;

	@Size(max = 20, message = "Libro menor de 20 caracteres")
	private String libro;

	@Size(max = 20, message = "Folio menor de 20 caracteres")
	private String folio;

	@Size(max = 20, message = "Acta menor de 20 caracteres")
	private String acta;

	@Size(max = 20, message = "Numero Diploma menor de 20 caracteres")
	private String numeroDiploma;

	@NotBlank(message = "Semestre Grado obligatorio")
	@Size(max = 10, message = "Semestre Grado menor de 10 caracteres")
	private String semestreGrado;

	@NotBlank(message = "Forma Grado obligatorio")
	@Size(max = 20, message = "Forma Grado menor de 20 caracteres")
	private String formaGrado;

	@Size(max = 50, message = "Tipo Opción Grado menor de 50 caracteres")
	private String tipoOpcionGrado;

	@Size(max = 5, message = "Nota Opción Grado menor de 5 caracteres")
	private String notaOpcionGrado;

	@Size(max = 10, message = "Semestre Finalizo Materias menor de 10 caracteres")
	private String semestreFinalizoMaterias;

	public Long getIdInformacionAcademica() {
		return idInformacionAcademica;
	}

	public void setIdInformacionAcademica(Long idInformacionAcademica) {
		this.idInformacionAcademica = idInformacionAcademica;
	}

	public Long getIdEgresado() {
		return idEgresado;
	}

	public void setIdEgresado(Long idEgresado) {
		this.idEgresado = idEgresado;
	}

	public Long getIdPrograma() {
		return idPrograma;
	}

	public void setIdPrograma(Long idPrograma) {
		this.idPrograma = idPrograma;
	}

	public String getLibro() {
		return this.libro;
	}

	public void setLibro(String libro) {
		this.libro = libro;
	}

	public String getFolio() {
		return this.folio;
	}

	public void setFolio(String folio) {
		this.folio = folio;
	}

	public String getActa() {
		return this.acta;
	}

	public void setActa(String acta) {
		this.acta = acta;
	}

	public String getNumeroDiploma() {
		return numeroDiploma;
	}

	public void setNumeroDiploma(String numeroDiploma) {
		this.numeroDiploma = numeroDiploma;
	}

	public String getSemestreGrado() {
		return semestreGrado;
	}

	public void setSemestreGrado(String semestreGrado) {
		this.semestreGrado = semestreGrado;
	}

	public String getFormaGrado() {
		return formaGrado;
	}

	public void setFormaGrado(String formaGrado) {
		this.formaGrado = formaGrado;
	}

	public String getTipoOpcionGrado() {
		return tipoOpcionGrado;
	}

	public void setTipoOpcionGrado(String tipoOpcionGrado) {
		this.tipoOpcionGrado = tipoOpcionGrado;
	}

	public String getNotaOpcionGrado() {
		return notaOpcionGrado;
	}

	public void setNotaOpcionGrado(String notaOpcionGrado) {
		this.notaOpcionGrado = notaOpcionGrado;
	}

	public String getSemestreFinalizoMaterias() {
		return semestreFinalizoMaterias;
	}

	public void setSemestreFinalizoMaterias(String semestreFinalizoMaterias) {
		this.semestreFinalizoMaterias = semestreFinalizoMaterias;
	}

}
