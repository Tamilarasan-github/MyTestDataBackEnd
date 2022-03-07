package backend.applications.tables;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TestTablesInfoRepository extends JpaRepository<TestTablesInfo, Integer>, JpaSpecificationExecutor<TestTablesInfo>
{
	Optional<List<TestTablesInfo>> findByDeleteFlag(String deleteFlag);
	
	@Query(value = "SELECT * FROM TEST_TABLE_INFO t WHERE t.APPLICATION_ID=:applicationId AND DELETE_FLAG=:deleteFlag", nativeQuery = true)
	Optional<List<TestTablesInfo>> findByTestApplicationsInfoAndDeleteFlag(long applicationId, String deleteFlag);
}
