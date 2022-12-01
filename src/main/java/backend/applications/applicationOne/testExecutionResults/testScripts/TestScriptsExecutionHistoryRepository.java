package backend.applications.applicationOne.testExecutionResults.testScripts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;


public interface TestScriptsExecutionHistoryRepository extends JpaRepository<TestScriptsExecutionHistoryEntity, Integer>, JpaSpecificationExecutor<TestScriptsExecutionHistoryEntity>
{
	@Query(value = "SELECT * FROM TEST_SCRIPTS_EXECUTION_HISTORY_APP_ONE t WHERE t.SUITE_EXECUTION_ID = :suiteExecutionId", nativeQuery = true)
	public List<TestScriptsExecutionHistoryEntity> findBySuiteExecutionId(long suiteExecutionId);
}
