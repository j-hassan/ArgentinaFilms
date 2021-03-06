package model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@SuppressWarnings("serial")
@Entity
public class Directores implements Serializable{
	@Id
	@GeneratedValue
	private Integer id_director;

	private String nombre;
	private String apellido;
	private Integer edad;
	private boolean estado;
	
	public Directores() {
		// TODO Auto-generated constructor stub
	}

	public Directores(String nombre, String apellido, Integer edad) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
	}
	
	public Directores(String nombre, String apellido, Integer edad, boolean estado) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.estado = estado;
	}

	public Integer getId_director() {
		return id_director;
	}

	public void setId_director(Integer id_director) {
		this.id_director = id_director;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	

}
