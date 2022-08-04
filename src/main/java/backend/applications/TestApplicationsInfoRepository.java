package backend.applications;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import backend.applications.tables.TestTablesInfo;

public interface TestApplicationsInfoRepository extends JpaRepository<TestApplicationsInfo, Integer>, JpaSpecificationExecutor<TestApplicationsInfo>
{
	@Query(value = "SELECT * FROM TEST_APPLICATIONS_INFO t WHERE t.DELETE_FLAG=:deleteFlag", nativeQuery = true)
	Optional<List<TestApplicationsInfo>> findByDeleteFlag(String deleteFlag);
	
}
