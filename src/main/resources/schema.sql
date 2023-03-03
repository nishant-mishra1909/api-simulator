CREATE TABLE wiremock_mapping (
  id INT NOT NULL AUTO_INCREMENT,
  request_method VARCHAR(10) NOT NULL,
  request_url VARCHAR(255) NOT NULL,
  request_body TEXT,
  request_type VARCHAR(255) NOT NULL,
  response_body TEXT,
  PRIMARY KEY (id)
);
