package backend.applications.applicationOne.testExecutionResults.testData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface TestDataExecutionHistoryMetaRepository extends JpaRepository<TestDataExecutionHistoryMetaEntity, Long>
{
	@Query(value = "SELECT * FROM TEST_DATA_EXECUTION_HISTORY_META_APP_ONE t WHERE t.TEST_SCRIPT_EXEC_ID = :testScriptExecutionId", nativeQuery = true)
	public List<TestDataExecutionHistoryMetaEntity> findByTestScriptExecutionId(long testScriptExecutionId);
}
