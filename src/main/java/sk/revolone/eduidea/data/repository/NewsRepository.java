package sk.revolone.eduidea.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.revolone.eduidea.data.entity.News;

public interface NewsRepository extends JpaRepository<News, Integer>{

}
