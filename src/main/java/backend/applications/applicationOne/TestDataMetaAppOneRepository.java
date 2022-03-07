package backend.applications.applicationOne;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TestDataMetaAppOneRepository extends JpaRepository<TestDataMetaAppOneTableEntity, Integer>, JpaSpecificationExecutor<TestDataMetaAppOneTableEntity>
{
	@Query(value = "SELECT * FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId fetch first 1 rows only", nativeQuery = true)
	TestDataMetaAppOneTableEntity getRandomFirstRecord(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_DATA_META_ID) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfTestDataMetaId(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_CASE_ID) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfTestCaseId(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_SHORT_DESCRIPTION) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfTestShortDescription(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_SCENARIO) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfTestScenario(long tableId);
	
	@Query(value = "SELECT DISTINCT(RUN_FLAG) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfRunFlag(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_PRIORITY) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfTestPriority(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_CATEGORY) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfTestCategory(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_SCRIPT_NAME) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfTestScriptName(long tableId);
	
	@Query(value = "SELECT DISTINCT(JIRA_ID) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfJiraId(long tableId);
	
	@Query(value = "SELECT DISTINCT(CREATED_BY) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfCreatedBy(long tableId);
	
	@Query(value = "SELECT DISTINCT(UPDATED_BY) FROM TEST_DATA_META t WHERE t.TEST_TABLE_ID=:tableId", nativeQuery = true)
	List<String> findAllDistinctOfUpdatedBy(long tableId);
}
