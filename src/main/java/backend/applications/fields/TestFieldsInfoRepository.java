package backend.applications.fields;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

public interface TestFieldsInfoRepository extends JpaRepository<TestFieldsInfoEntity, Integer>, JpaSpecificationExecutor<TestFieldsInfoEntity>
{
	@Query(value = "SELECT * FROM TEST_FIELDS_INFO t ORDER BY FIELD_ORDER", nativeQuery = true)
	Optional<List<TestFieldsInfoEntity>> findAllOrderByFieldOrder();
	
	@Query(value = "SELECT * FROM TEST_FIELDS_INFO t WHERE t.TABLE_NAME=:tableName ORDER BY FIELD_ORDER", nativeQuery = true)
	Optional<List<TestFieldsInfoEntity>> findAllByTableNameOrderByFieldOrder(String tableName);
}
