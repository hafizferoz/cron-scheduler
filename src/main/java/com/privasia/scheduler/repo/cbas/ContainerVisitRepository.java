package com.privasia.scheduler.repo.cbas;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.privasia.scheduler.model.ContainerVisit;
import com.privasia.scheduler.repo.BaseRepository;

/**
 * @author Hafiz Feroz
 *
 */
@Repository("containerVisitRepository")
public interface ContainerVisitRepository extends BaseRepository<ContainerVisit, String>, QueryDslPredicateExecutor<ContainerVisit> {

	public ContainerVisit getCotainerVisitByScn(String scn);

	@Query(name = "Vessel.getContainerVisitStatus", nativeQuery = true)
	//@Query(value="SELECT MARINE_STATUS FROM CBAS_CONTAINER_VISIT cv WHERE  cv.PLANNING_STATUS <> 2 AND cv.SCN = :scn", nativeQuery = true)
		public String getContainerMarrineStatusByScn(@Param("scn") String scn);
}
