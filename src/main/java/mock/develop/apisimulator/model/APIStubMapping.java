package mock.develop.apisimulator.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "wiremock_mapping")
public class APIStubMapping {
    @Id
    @GeneratedValue
    Long id;
    @Column(name = "request_url")
    String requestUrl;
    @Column(name = "request_method")
    String requestMethod;
    @Column(name = "request_body", length = 1000000000)
    String requestBody;
    @Column(name = "response_body", length = 1000000000)
    String responseBody;
    @Column(name = "request_type")
    String apiType;
}

