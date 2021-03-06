package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@SuppressWarnings("serial")
@Entity
public class Peliculas implements Serializable{
	@Id
	@GeneratedValue
	private Integer id_pelicula;

	private String nombre;
	private int anio;
	private String ubicacion;
	private Integer duracion;
	@Column(length=812)
	private String synopsis;
	private Integer puntuacion_total;
	private String poster;
	private String trailer;
	private boolean estado;
	int cant_visitas;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "PeliculaXActores", joinColumns = @JoinColumn(name = "id_pelicula"), inverseJoinColumns = @JoinColumn(name = "id_actor"))
	private List<Actores> actores;	
	
	@ManyToOne
	private Directores director;	

	@LazyCollection(LazyCollectionOption.FALSE)
	@ManyToMany(cascade ={CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name = "ReseniasXPelicula", joinColumns = @JoinColumn(name = "id_pelicula"), inverseJoinColumns = @JoinColumn(name = "id_resenia"))
	private List<Resenias> resenias;
	
	@ManyToOne
	private Usuarios usuario;
	
	@ManyToOne
	private Generos genero;
	
	public Peliculas() {
		// TODO Auto-generated constructor stub
	}

	
	
	public Peliculas(String nombre, int anio, String ubicacion,
			Integer duracion, String synopsis, Integer puntuacion_total,
			String poster, String trailer, List<Actores> actores,
			Directores director, List<Resenias> resenias, Usuarios usuario,
			Generos genero, boolean estado) {
		super();
		this.nombre = nombre;
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.duracion = duracion;
		this.synopsis = synopsis;
		this.puntuacion_total = puntuacion_total;
		this.poster = poster;
		this.trailer = trailer;
		this.actores = actores;
		this.director = director;
		this.resenias = resenias;
		this.usuario = usuario;
		this.genero = genero;
		this.estado = estado;
	}


	public Peliculas(String nombre, int anio, String ubicacion,
			Integer duracion, String synopsis, Integer puntuacion_total,
			String poster, String trailer, List<Actores> actores,
			Directores director, List<Resenias> resenias, Usuarios usuario,
			Generos genero, boolean estado, int cant_visitas) {
		super();
		this.nombre = nombre;
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.duracion = duracion;
		this.synopsis = synopsis;
		this.puntuacion_total = puntuacion_total;
		this.poster = poster;
		this.trailer = trailer;
		this.actores = actores;
		this.director = director;
		this.resenias = resenias;
		this.usuario = usuario;
		this.genero = genero;
		this.estado = estado;
		this.cant_visitas = cant_visitas;
	}

	

	public Peliculas(String nombre, int anio, String ubicacion, Integer duracion, String synopsis, Integer puntuacion_total, List<Actores> actores, Directores director, List<Resenias> resenias, Usuarios usuario, Generos genero) {
		this.nombre = nombre;
		this.setAnio(anio);
		this.ubicacion = ubicacion;
		this.duracion = duracion;
		this.synopsis = synopsis;
		this.puntuacion_total = puntuacion_total;
		this.actores = actores;
		this.director = director;
		this.resenias = resenias;
		this.usuario = usuario;
		this.genero = genero;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public Peliculas(String nombre, int anio, String ubicacion, Integer duracion, String synopsis,
			Integer puntuacion_total, String poster, String trailer, Usuarios usuario,
			Generos genero) {
		super();
		this.nombre = nombre;
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.duracion = duracion;
		this.synopsis = synopsis;
		this.puntuacion_total = puntuacion_total;
		this.poster = poster;
		this.trailer = trailer;
		this.usuario = usuario;
		this.genero = genero;
	}

	public Peliculas(String nombre, int anio, String ubicacion, Integer duracion, String synopsis,
			Integer puntuacion_total, Usuarios usuario, Generos genero) {
		super();
		this.nombre = nombre;
		this.anio = anio;
		this.ubicacion = ubicacion;
		this.duracion = duracion;
		this.synopsis = synopsis;
		this.puntuacion_total = puntuacion_total;
		this.usuario = usuario;
		this.genero = genero;
	}

	public Integer getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(Integer id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public void setDuracion(Integer duracion) {
		this.duracion = duracion;
	}

	public String getSynopsis() {
		return synopsis;
	}

	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}

	public Integer getPuntuacion_total() {
		return puntuacion_total;
	}

	public void setPuntuacion_total(Integer puntuacion_total) {
		this.puntuacion_total = puntuacion_total;
	}

	public List<Actores> getActores() {
		return actores;
	}

	public void setActores(List<Actores> actores) {
		this.actores = actores;
	}

	public Directores getDirector() {
		return director;
	}

	public void setDirector(Directores director) {
		this.director = director;
	}

	public List<Resenias> getResenias() {
		return resenias;
	}

	public void setResenias(List<Resenias> resenias) {
		this.resenias = resenias;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}



	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}



	public int getCant_visitas() {
		return cant_visitas;
	}



	public void setCant_visitas(int cant_visitas) {
		this.cant_visitas = cant_visitas;
	}
	
	
	

}
