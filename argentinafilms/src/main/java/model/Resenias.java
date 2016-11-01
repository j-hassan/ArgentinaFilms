package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Resenias {
	@Id
	@GeneratedValue
	private Integer id_rese�a;
	private String rese�a;
	private String aportadores;
	@ManyToOne
	private Usuarios usuario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "ComentariosXResenia", joinColumns = @JoinColumn(name = "id_resenia"), inverseJoinColumns = @JoinColumn(name = "id_comentario"))
	private List<Comentarios> comentarios;
	
	public Resenias() {
		// TODO Auto-generated constructor stub
	}

	public Resenias(String rese�a, String aportadores, Usuarios usuario, List<Comentarios> comentarios) {
		this.rese�a = rese�a;
		this.aportadores = aportadores;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

	public Integer getId_rese�a() {
		return id_rese�a;
	}

	public void setId_rese�a(Integer id_rese�a) {
		this.id_rese�a = id_rese�a;
	}

	public String getRese�a() {
		return rese�a;
	}

	public void setRese�a(String rese�a) {
		this.rese�a = rese�a;
	}

	public String getAportadores() {
		return aportadores;
	}

	public void setAportadores(String aportadores) {
		this.aportadores = aportadores;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

}