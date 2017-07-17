package jun.dao;

import java.util.List;

import jun.entity.Visit;

public interface VisitDao {

	void add(Visit visit);

	List<Visit> findAll();

}
