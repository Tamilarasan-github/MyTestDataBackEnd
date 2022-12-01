package backend.applications.applicationOne.testExecutionResults.testSuite;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import backend.applications.applicationOne.TestDataMetaAppOneEntity;

public interface TestSuiteExecutionHistoryRepository extends JpaRepository<TestSuiteExecutionHistoryEntity, Integer>, JpaSpecificationExecutor<TestSuiteExecutionHistoryEntity>
{

	@Modifying
	@Transactional
	@Query(value = "Update TEST_SUITE_EXECUTION_HISTORY_APP_ONE t set t.SUITE_STATUS = :suiteStatus where t.SUITE_ID = :suiteId", nativeQuery = true)
	public void updateSuiteStatusById(String suiteStatus, long suiteId);
	
	@Query(value = "SELECT * FROM TEST_SUITE_EXECUTION_HISTORY_APP_ONE t where t.SUITE_EXECUTION_ID = :suiteExecutionId", nativeQuery = true)
	public Optional<TestSuiteExecutionHistoryEntity> findBySuiteExecutionId(long suiteExecutionId);
	
	@Query(value = "SELECT * FROM TEST_SUITE_EXECUTION_HISTORY_APP_ONE t where t.SUITE_STATUS = :suiteStatus ORDER BY t.EXECUTION_ID", nativeQuery = true)
	public List<TestSuiteExecutionHistoryEntity> findBySuiteStatus(String suiteStatus);
}
