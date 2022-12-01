package backend.applications.applicationOne.testExecutionResults.testData;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import backend.applications.applicationOne.testExecutionResults.testScripts.TestScriptsExecutionHistoryEntity;

public interface TestDataExecutionHistoryMetaRepository extends JpaRepository<TestDataMetaExecutionHistoryEntity, Long>, JpaSpecificationExecutor<TestDataMetaExecutionHistoryEntity>
{
	@Query(value = "SELECT * FROM TEST_DATA_EXECUTION_HISTORY_META_APP_ONE t WHERE t.TEST_SCRIPT_EXEC_ID = :testScriptExecutionId", nativeQuery = true)
	public List<TestDataMetaExecutionHistoryEntity> findByTestScriptExecutionId(long testScriptExecutionId);

	@Query(value = "SELECT COUNT(TEST_DATA_EXEC_ID) FROM TEST_DATA_EXECUTION_HISTORY_META_APP_ONE t WHERE t.EXECUTED_ON BETWEEN :dateFrom AND :dateTo", nativeQuery = true)
	public String findExecutedTestcases(String dateFrom, String dateTo);
	
	@Query(value="SELECT count(TEST_DATA_EXEC_ID) FROM TEST_DATA_EXECUTION_HISTORY_META_APP_ONE d INNER JOIN TEST_SUITE_EXECUTION_HISTORY s ON d.SUITE_ID =s.SUITE_ID WHERE d.SUITE_ID IN (SELECT SUITE_ID FROM TEST_SUITE_EXECUTION_HISTORY WHERE URL= :environment AND (CREATED_DATE BETWEEN :dateFrom AND :dateTo))", nativeQuery = true)
	public String findExecutedTestcasesByEnvironment(String environment, String dateFrom, String dateTo);

	@Query(value = "SELECT COUNT(TEST_DATA_EXEC_ID) FROM TEST_DATA_EXECUTION_HISTORY_META_APP_ONE t WHERE t.EXECUTION_STATUS = :executionStatus AND (t.EXECUTED_ON BETWEEN :dateFrom AND :dateTo)", nativeQuery = true)
	public String findByExecutionStatus(String executionStatus, String dateFrom, String dateTo);

	@Query(value="SELECT count(TEST_DATA_EXEC_ID) FROM TEST_DATA_EXECUTION_HISTORY_META_APP_ONE d INNER JOIN TEST_SUITE_EXECUTION_HISTORY s ON d.SUITE_ID =s.SUITE_ID WHERE d.SUITE_ID IN (SELECT SUITE_ID FROM TEST_SUITE_EXECUTION_HISTORY WHERE URL= :environment AND (CREATED_DATE BETWEEN :dateFrom AND :dateTo)) AND d.EXECUTION_STATUS=:executionStatus", nativeQuery = true)
	public String findExecutionStatusByEnvironment(String environment, String executionStatus, String dateFrom, String dateTo);


}
