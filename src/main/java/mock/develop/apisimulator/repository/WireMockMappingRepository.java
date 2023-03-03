package mock.develop.apisimulator.repository;


import mock.develop.apisimulator.model.APIStubMapping;

import java.util.List;

public interface WireMockMappingRepository {

    void save(APIStubMapping mapping);

    List<APIStubMapping> findAll();

}
