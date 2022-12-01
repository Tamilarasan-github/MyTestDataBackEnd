package backend.applications.applicationOne.testdataInputTables.tableTwo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TestDataAppOneTableTwoRepository extends JpaRepository<TestDataAppOneTableTwoEntity, Integer>
{
	@Query(value = "SELECT * FROM TEST_DATA_APP_TABLE_TWO t WHERE  t.DELETE_FLAG='N' AND t.TEST_DATA_ID=:testDataId" , nativeQuery = true)
	Optional<TestDataAppOneTableTwoEntity> findByTestDataId(Integer testDataId);

}
