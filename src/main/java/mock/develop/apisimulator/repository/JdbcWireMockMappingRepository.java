/*
package mock.develop.apisimulator.repository;

import mock.develop.apisimulator.model.APIStubMapping;
import mock.develop.apisimulator.util.SimulatorDBConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class JdbcWireMockMappingRepository implements WireMockMappingRepository {

    private final Logger log = Logger.getLogger("JdbcWireMockMappingRepository");
    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public JdbcWireMockMappingRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public Object save(APIStubMapping mapping) {
        log.info("Saving New API Simulation with these details : " + mapping);

        jdbcTemplate.update(SimulatorDBConstants.insertQuery,
                mapping.getRequestMethod(),
                mapping.getRequestUrl(),
                mapping.getRequestBody(),
                mapping.getResponseBody(),
                mapping.getApiType()
        );
        return null;
    }

    @Override
    public List<APIStubMapping> findAll() {
        return jdbcTemplate.query(SimulatorDBConstants.findAllQuery, new APIStubMappingRowMapper());
    }

    @Override
    public Optional<APIStubMapping> findById(Long id) {

        return jdbcTemplate.query(SimulatorDBConstants.findSimulationByIdQuery, new Object[]{id}, rs -> {
            if (rs.next()) {
                APIStubMapping mapping = new APIStubMapping(rs.getInt("id"),
                        rs.getString("request_url"),
                        rs.getString("request_method"),
                        rs.getString("request_body"),
                        rs.getString("response_body"),
                        rs.getString("request_type"));
                return Optional.of(mapping);
            } else {
                return Optional.empty();
            }
        });
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update(SimulatorDBConstants.deleteAPISimulationQuery, id);
    }

}


*/
