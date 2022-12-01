package backend.applications.applicationOne.testdataInputTables.tableOne;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestDataAppOneTableOneRepository extends JpaRepository<TestDataAppOneTableOneEntity, Integer>
{
	@Query(value = "SELECT * FROM TEST_DATA_APP_TABLE_ONE t WHERE  t.DELETE_FLAG='N' AND t.TEST_DATA_ID=:testDataId" , nativeQuery = true)
	Optional<TestDataAppOneTableOneEntity> findByTestDataId(Integer testDataId);
}
