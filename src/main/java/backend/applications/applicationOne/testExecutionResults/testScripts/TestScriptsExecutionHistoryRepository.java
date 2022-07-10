package backend.applications.applicationOne.testExecutionResults.testScripts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface TestScriptsExecutionHistoryRepository extends JpaRepository<TestScriptsExecutionHistoryEntity, Long>
{
	@Query(value = "SELECT * FROM TEST_SCRIPTS_EXECUTION_HISTORY_APP_ONE t WHERE t.SUITE_ID = :suiteId", nativeQuery = true)
	public List<TestScriptsExecutionHistoryEntity> findBySuiteId(long suiteId);
}
