package backend.applications.applicationOne;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TestDataMetaAppOneRepository extends JpaRepository<TestDataMetaAppOneEntity, Integer>, JpaSpecificationExecutor<TestDataMetaAppOneEntity>
{
	
	@Query(value = "SELECT DISTINCT(TEST_DATA_META_ID) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestDataMetaIdByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_CASE_ID) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestCaseIdByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_SHORT_DESCRIPTION) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestShortDescriptionByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_SCENARIO) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestScenarioByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(RUN_FLAG) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctRunFlagByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_PRIORITY) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestPriorityByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_CATEGORY) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestCategoryByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_SCRIPT_NAME) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestScriptNameByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(JIRA_ID) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctJiraIdByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(CREATED_BY) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctCreatedByByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(UPDATED_BY) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_ONE=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctUpdatedByByTestTableOne(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_DATA_META_ID) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestDataMetaIdByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_CASE_ID) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestCaseIdByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_SHORT_DESCRIPTION) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestShortDescriptionByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_SCENARIO) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestScenarioByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(RUN_FLAG) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctRunFlagByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_PRIORITY) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestPriorityByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_CATEGORY) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestCategoryByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(TEST_SCRIPT_NAME) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctTestScriptNameByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(JIRA_ID) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctJiraIdByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(CREATED_BY) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctCreatedByByTestTableTwo(long tableId);
	
	@Query(value = "SELECT DISTINCT(UPDATED_BY) FROM TEST_DATA_META_APP_ONE t WHERE t.TEST_TABLE_TWO=:tableId AND t.DELETE_FLAG='N'", nativeQuery = true)
	List<String> findAllDistinctUpdatedByByTestTableTwo(long tableId);
}
