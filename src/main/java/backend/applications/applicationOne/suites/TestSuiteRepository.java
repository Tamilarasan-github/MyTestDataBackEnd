package backend.applications.applicationOne.suites;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface TestSuiteRepository extends JpaRepository<TestSuiteEntity, Integer>, JpaSpecificationExecutor<TestSuiteEntity>
{

}
