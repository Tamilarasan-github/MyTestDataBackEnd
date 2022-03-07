package backend.applications;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TestApplicationsInfoRepository extends JpaRepository<TestApplicationsInfo, Integer>, JpaSpecificationExecutor<TestApplicationsInfo>
{
	Optional<List<TestApplicationsInfo>> findByDeleteFlag(String deleteFlag);
}
