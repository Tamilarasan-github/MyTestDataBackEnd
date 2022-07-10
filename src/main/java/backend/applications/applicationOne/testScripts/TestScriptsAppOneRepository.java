package backend.applications.applicationOne.testScripts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import backend.applications.TestApplicationsInfo;

public interface TestScriptsAppOneRepository extends JpaRepository<TestScriptsEntity, Integer>, JpaSpecificationExecutor<TestScriptsEntity>
{

	@Query(value = "SELECT DISTINCT(TEST_SCRIPT_ID) FROM TEST_SCRIPTS_APP_ONE t WHERE  t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestScriptsId();
	
	@Query(value = "SELECT DISTINCT(TEST_SCRIPT_CATEGORY) FROM TEST_SCRIPTS_APP_ONE t WHERE  t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestScriptsCategory();
	
	@Query(value = "SELECT DISTINCT(TEST_SCRIPT_NAME) FROM TEST_SCRIPTS_APP_ONE t WHERE  t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestScripts();
	
	@Query(value = "SELECT DISTINCT(CREATED_BY) FROM TEST_SCRIPTS_APP_ONE t WHERE  t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestScriptsCreatedBy();
	
	@Query(value = "SELECT DISTINCT(UPDATED_BY) FROM TEST_SCRIPTS_APP_ONE t WHERE  t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestScriptsUpdatedBy();
}
