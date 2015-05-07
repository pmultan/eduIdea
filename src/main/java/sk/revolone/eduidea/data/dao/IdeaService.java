package sk.revolone.eduidea.data.dao;

import java.util.List;

import sk.revolone.eduidea.data.entity.Idea;
import sk.revolone.eduidea.exception.EntityNotFound;

public interface IdeaService {
 	public Idea create(Idea idea);
    public Idea delete(int id) throws EntityNotFound;
    public List<Idea> findAll();
    public Idea update(Idea idea) throws EntityNotFound;
    public Idea findById(int id);  
    public List<Idea> findAllOrderByDateCreatedDesc();
}
