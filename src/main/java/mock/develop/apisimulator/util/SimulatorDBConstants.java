package mock.develop.apisimulator.util;

public interface SimulatorDBConstants {
    String findAllQuery = "SELECT id, request_method, request_url, request_body, request_type, response_body FROM wiremock_mapping";
    String findSimulationByIdQuery = "SELECT id, request_method, request_url, request_body, request_type, response_body FROM wiremock_mapping where id = ?";

    String insertQuery = "INSERT INTO wiremock_mapping (request_method, request_url, request_body, response_body, request_type) VALUES (?, ?, ?, ?, ?)";

    String deleteAPISimulationQuery = "delete from wiremock_mapping where id = ?";

}
