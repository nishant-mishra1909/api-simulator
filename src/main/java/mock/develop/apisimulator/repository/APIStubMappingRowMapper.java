package mock.develop.apisimulator.repository;

import mock.develop.apisimulator.model.APIStubMapping;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class APIStubMappingRowMapper implements RowMapper<APIStubMapping> {

    @Override
    public APIStubMapping mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new APIStubMapping(rs.getLong("id"),
                rs.getString("request_url"),
                rs.getString("request_method"),
                rs.getString("request_body"),
                rs.getString("response_body"),
                rs.getString("request_type")
        );
    }
}