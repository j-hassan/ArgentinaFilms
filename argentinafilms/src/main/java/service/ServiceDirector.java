package service;

import java.util.List;

import model.Directores;

public interface ServiceDirector {

	public List<Directores> getAll();
	
	public Directores getById(Integer id);
	
	public void add(Directores director);
	
	public void update(Directores director);
	
	public void delete(Integer id);
	
}
