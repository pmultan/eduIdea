package sk.revolone.eduidea.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.revolone.eduidea.data.entity.Idea;
import sk.revolone.eduidea.data.entity.User;

public interface IdeaRepository extends JpaRepository<Idea, Integer>{
	List<Idea> findByAuthor(User author);
}
