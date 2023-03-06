package mock.develop.apisimulator.repository;


import mock.develop.apisimulator.model.APIStubMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface WireMockMappingRepository extends JpaRepository<APIStubMapping, Long> {

    APIStubMapping save(APIStubMapping mapping);

    List<APIStubMapping> findAll();

    Optional<APIStubMapping> findById(Long id);

    void deleteById(Long id);
}
