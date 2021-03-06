package service.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import dao.DAOPeliculas;
import model.Peliculas;
import service.ServicePelicula;

@Transactional
public class ServicePeliculaImpl implements ServicePelicula{

	@Autowired
	private DAOPeliculas daoPelicula = null;
	
	@Override
	public List<Peliculas> getAll() {
		return this.daoPelicula.getAll();
	}
	
	@Override
	public List<Peliculas> getActivas(){
		return this.daoPelicula.getActivas();
	}
	
	@Override
	public List<Peliculas> getInactivas(int offset, int cantRegistros){
		return this.daoPelicula.getInactivas(offset, cantRegistros);
	}
	
	@Override
	public List<Peliculas> getByTextoEnNombre(String texto) {
		DetachedCriteria crit = DetachedCriteria.forClass(Peliculas.class);
		crit.add(Restrictions.eq("nombre", texto));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.daoPelicula.getByTextoEnNombre(texto);
	}
	
	@Override
	public List<Peliculas> getUltimasCuatroActivas(){
		return this.daoPelicula.getUltimasActivas();
	}

	@Override
	public List<Peliculas> getDiezMasVisitadas(){
		return this.daoPelicula.getDiezMasVisitadas();
	}
	
	@Override
	public Peliculas getById(int id) {
		return this.daoPelicula.getById(id);
	}

	@Override
	public void add(Peliculas pelicula) {
		this.daoPelicula.save(pelicula);
	}

	@Override
	public void update(Peliculas pelicula) {
		this.daoPelicula.update(pelicula);
	}

	@Override
	public void delete(Peliculas pelicula) {
		this.daoPelicula.delete(pelicula);
	}

	public void setDaoPelicula(DAOPeliculas daoPelicula) {
		this.daoPelicula = daoPelicula;
	}
	
	@Override
	public List<Peliculas> getByActor(int id) {
		return this.daoPelicula.getByActor(id);
	}

	@Override
	public List<Peliculas> getByDirector(int id) {
		return this.daoPelicula.getByDirector(id);
	}
	
	@Override
	public List<Peliculas> getByUsuario(String id) {
		return this.daoPelicula.getByUsuario(id);
	}
	
	@Override
	public Peliculas getByResenia(int id) {
		return this.daoPelicula.getByResenia(id);
	}
	
	@Override
	public int getCantInactivas() {
		return this.daoPelicula.getCantInactivas();
	}

}
