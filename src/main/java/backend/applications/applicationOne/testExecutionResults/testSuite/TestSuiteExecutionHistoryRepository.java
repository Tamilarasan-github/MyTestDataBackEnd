package backend.applications.applicationOne.testExecutionResults.testSuite;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface TestSuiteExecutionHistoryRepository extends JpaRepository<TestSuiteExecutionHistoryEntity, Long>
{

	@Modifying
	@Transactional
	@Query(value = "Update TEST_SUITE_EXECUTION_HISTORY t set t.SUITE_STATUS = :suiteStatus where t.SUITE_ID = :suiteId", nativeQuery = true)
	public void updateSuiteStatusById(String suiteStatus, long suiteId);
	
	@Query(value = "SELECT * FROM TEST_SUITE_EXECUTION_HISTORY t where t.SUITE_ID = :suiteId", nativeQuery = true)
	public TestSuiteExecutionHistoryEntity findBySuiteId(long suiteId);
}
