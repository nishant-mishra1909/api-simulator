package mock.develop.apisimulator.repository;

import mock.develop.apisimulator.model.APIStubMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JdbcWireMockMappingRepository implements WireMockMappingRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcWireMockMappingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public void save(APIStubMapping mapping) {
        jdbcTemplate.update(
                "INSERT INTO wiremock_mapping (request_method, request_url, request_body, response_body, request_type) VALUES (?, ?, ?, ?, ?)",
                mapping.getRequestMethod(),
                mapping.getRequestUrl(),
                mapping.getRequestBody(),
                mapping.getResponseBody(),
                mapping.getApiType()
        );
    }

    @Override
    public List<APIStubMapping> findAll() {
        String findAllQuery = "SELECT id, request_method, request_url, request_body, request_type, response_body FROM wiremock_mapping";
        return jdbcTemplate.query(findAllQuery, new APIStubMappingRowMapper());
    }

}


