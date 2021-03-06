package dao.impl;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;

import dao.DAOPeliculas;
import model.*;
@SuppressWarnings("unchecked")

public class DAOPeliculasImpl implements DAOPeliculas {

	private HibernateTemplate hibernateTemplate = null;
	@Override
	public List<Peliculas> getAll() {
		return this.hibernateTemplate.loadAll(Peliculas.class);
	}
	
	
	@Override
	public List<Peliculas> getActivas() {
		DetachedCriteria crit = DetachedCriteria.forClass(Peliculas.class);
		crit.add(Restrictions.eq("estado", true));
		crit.addOrder(Order.asc("nombre"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.hibernateTemplate.findByCriteria(crit);
	}
	
	@Override
	public List<Peliculas> getInactivas(int offset, int cantRegistros) {
		DetachedCriteria crit = DetachedCriteria.forClass(Peliculas.class);
		crit.add(Restrictions.eq("estado", false));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.hibernateTemplate.findByCriteria(crit, offset, cantRegistros);
	}
	
	@Override
	public List<Peliculas> getByTextoEnNombre(String texto) {
		DetachedCriteria crit = DetachedCriteria.forClass(Peliculas.class);
		crit.add(Restrictions.eq("estado", true));
		crit.add(Restrictions.like("nombre", "%" + texto + "%"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.hibernateTemplate.findByCriteria(crit);
	}
	
	@Override
	public List<Peliculas> getUltimasActivas(){
		DetachedCriteria crit = DetachedCriteria.forClass(Peliculas.class);
		crit.add(Restrictions.eq("estado", true));
		crit.addOrder(Order.desc("id_pelicula"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.hibernateTemplate.findByCriteria(crit, 0, 9);
	}
	
	@Override
	public List<Peliculas> getDiezMasVisitadas(){
		DetachedCriteria crit = DetachedCriteria.forClass(Peliculas.class);
		crit.add(Restrictions.eq("estado", true));
		crit.addOrder(Order.desc("cant_visitas"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.hibernateTemplate.findByCriteria(crit, 0, 10);
	}
	
	@Override
	public Peliculas getById(Integer id_pelicula) {
		return this.hibernateTemplate.get(Peliculas.class, id_pelicula);
	}

	@Override
	public void update(Peliculas pelicula) {
		this.hibernateTemplate.update(pelicula);
	}

	@Override
	public void delete(Peliculas pelicula) {
		this.hibernateTemplate.delete(pelicula);
	}

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory){
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void save(Peliculas pelicula) {
		this.hibernateTemplate.save(pelicula);
	}

	public List<Peliculas> getByActor(int id_actor) {
		return this.hibernateTemplate.find("select p from Peliculas as p join p.actores as a where a.id_actor = " + id_actor);
	}
	
	public List<Peliculas> getByDirector(int id_director) {
		return this.hibernateTemplate.find("select p from Peliculas as p join p.director as a where a.id_director = " + id_director);
	}
	
	public List<Peliculas> getByUsuario(String usuario) {
		return this.hibernateTemplate.find("select p from Peliculas as p join p.usuario as a where a.usuario = '" + usuario + "'");
	}
	
	@Override
	public Peliculas getByResenia(int id) {
		return (Peliculas)this.hibernateTemplate.find("select p from Peliculas as p join p.resenias as r where r.id_resenia = " + id).get(0);
	}
	
	@Override
	public int getCantInactivas(){
		DetachedCriteria crit = DetachedCriteria.forClass(Peliculas.class);
		crit.add(Restrictions.eq("estado", false));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.hibernateTemplate.findByCriteria(crit).size();
	}
	@Override
	public int getCantActivas(){
		DetachedCriteria crit = DetachedCriteria.forClass(Peliculas.class);
		crit.add(Restrictions.eq("estado", true));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.hibernateTemplate.findByCriteria(crit).size();
	}
	
	@Override
	public List<Peliculas> getByNombre(String texto, int offset, int cantRegistros) {
		DetachedCriteria crit = DetachedCriteria.forClass(Usuarios.class);
		crit.add(Restrictions.like("nombre", "%" + texto + "%"));
		crit.add(Restrictions.eq("estado", true));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.hibernateTemplate.findByCriteria(crit, offset, cantRegistros);
	}

	@Override
	public List<Peliculas> getActivos(int offset, int cantRegistros) {
		DetachedCriteria crit = DetachedCriteria.forClass(Peliculas.class);
		crit.add(Restrictions.eq("estado", true));
		crit.addOrder(Order.asc("nombre"));
		crit.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		return this.hibernateTemplate.findByCriteria(crit, offset, cantRegistros);
	}
	
}
