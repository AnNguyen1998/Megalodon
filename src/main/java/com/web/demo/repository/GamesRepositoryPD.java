package com.web.demo.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.web.demo.entity.Games;

@Repository
public interface GamesRepositoryPD extends JpaRepository<Games, Integer>, PagingAndSortingRepository<Games, Integer> {
	/*
	 * @author PhatDat
	 * method get games by Filters without Pagination
	 */
	@Query(value = "SELECT * FROM games",
			countQuery = "SELECT count(*) FROM games",
			nativeQuery = true)
	List<Games> findGamesByFilter(Pageable pageable);
	
	/*
	 * @author PhatDat
	 * method get games by Filters with Pagination
	 */
	@Query(value = "SELECT * FROM games",
			countQuery = "SELECT count(*) FROM games",
			nativeQuery = true)
	Page<Games> findGamesByFilterPaginated(Pageable pageable);
	
	/*
	 * @author PhatDat
	 * method get games by term because user searched with Pagination
	 */
	@Query(value = "SELECT * FROM games WHERE CONCAT(Name_game, Producter_game, Publisher_game, ReleaseYear_game, Description_game) LIKE %?1%",
			countQuery = "SELECT count(*) FROM games",
			nativeQuery = true)
	public Page<Games> search(String keyword, Pageable pageable);
	
	
}
