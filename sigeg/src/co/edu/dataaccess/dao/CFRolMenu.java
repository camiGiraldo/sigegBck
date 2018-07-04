package co.edu.dataaccess.dao;

import java.io.Serializable;

public class CFRolMenu implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Long idRol;
	private Long idMenu;

	public CFRolMenu(Long idRol, Long idMenu) {
		super();
		this.idRol = idRol;
		this.idMenu = idMenu;
	}

	public CFRolMenu(Long id, Long idRol, Long idMenu) {

		this.id = id;
		this.idRol = idRol;
		this.idMenu = idMenu;
	}

	public CFRolMenu() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdRol() {
		return idRol;
	}

	public void setIdRol(Long idRol) {
		this.idRol = idRol;
	}

	public Long getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(Long idMenu) {
		this.idMenu = idMenu;
	}

}
