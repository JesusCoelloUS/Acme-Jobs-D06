
package acme.features.employer.job;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.applications.Application;
import acme.entities.duties.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerJobRepository extends AbstractRepository {

	@Query("select j from Job j")
	Collection<Job> findAllJobs();

	@Query("select j from Job j where j.employer.id=?1")
	Collection<Job> findMyJobs(int id);

	@Query("select j from Job j where j.id=?1")
	Job findOneJobById(int id);

	@Query("select e from Employer e where e.id=?1")
	Employer findOneEmployerById(int id);

	@Query("select d from Duty d where d.job.id=?1")
	Collection<Duty> findDutiesFromJob(int id);

	@Query("select a from Application a where a.job.id=?1")
	Collection<Application> findApplicationsFromJob(int id);

}
