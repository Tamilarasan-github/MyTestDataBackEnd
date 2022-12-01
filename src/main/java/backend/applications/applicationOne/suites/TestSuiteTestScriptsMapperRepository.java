package backend.applications.applicationOne.suites;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import backend.applications.applicationOne.testdataInputTables.tableOne.TestDataAppOneTableOneEntity;

public interface TestSuiteTestScriptsMapperRepository extends JpaRepository<TestSuiteTestScriptsMapperEntity, Integer>, JpaSpecificationExecutor<TestSuiteTestScriptsMapperEntity>
{

	@Query(value = "SELECT t.TEST_SCRIPT_ID FROM TEST_SUITE_TEST_SCRIPTS_CONNECTOR t WHERE t.SUITE_ID=:suiteId" , nativeQuery = true)
	List<Integer> findTestScriptsBySuiteId(Integer suiteId);

}
