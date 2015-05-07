package sk.revolone.eduidea.data.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sk.revolone.eduidea.data.entity.Idea;
import sk.revolone.eduidea.data.repository.IdeaRepository;
import sk.revolone.eduidea.exception.EntityNotFound;
import sk.revolone.eduidea.utils.CustomSorts;

@Service
public class IdeaServiceImpl implements IdeaService {

	@Resource
	IdeaRepository ideaRepository;

	@Transactional
	@Override
	public Idea create(Idea idea) {
		Idea createdIdea = idea;
		return ideaRepository.save(createdIdea);
	}

	@Transactional
	@Override
	public Idea delete(int id) throws EntityNotFound {
		Idea deletedIdea = ideaRepository.findOne(id);
		if (deletedIdea == null)
			throw new EntityNotFound(
					"Idea that you are trying to remove was not found in DB.");
		ideaRepository.delete(deletedIdea);
		return deletedIdea;
	}

	@Override
	public List<Idea> findAll() {
		return ideaRepository.findAll();
	}

	@Transactional
	@Override
	public Idea update(Idea idea) throws EntityNotFound {
		Idea updatedIdea = ideaRepository.findOne(idea.getId());
		if (updatedIdea == null) {
			throw new EntityNotFound(
					"Idea that you are trying to update was not found in DB.");
		}
		
		updatedIdea.setText(idea.getText());
		updatedIdea.setTitle(idea.getTitle());
		updatedIdea.setComplexityLvl(idea.getComplexityLvl());
		updatedIdea.setExpectedVotes(idea.getExpectedVotes());

		return updatedIdea;
	}

	@Override
	public Idea findById(int id) {
		return ideaRepository.findOne(id);
	}

	@Override
	public List<Idea> findAllOrderByDateCreatedDesc() {
		return ideaRepository.findAll(CustomSorts.sortByDateCreatedDesc());
	}

}
