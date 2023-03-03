package mock.develop.apisimulator.util;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder;
import com.github.tomakehurst.wiremock.matching.RequestPatternBuilder;
import mock.develop.apisimulator.model.APIStubMapping;

import static com.github.tomakehurst.wiremock.client.WireMock.*;


public class SimulatorUtil {

    public static MappingBuilder getStubMapping(APIStubMapping mapping) {
        return request(mapping.getRequestMethod(), urlEqualTo(mapping.getRequestUrl()))
                .willReturn(aResponse()
                            .withStatus(200)
                            .withHeader("myHeader", "simulateItUP!!")
                            .withBody(mapping.getResponseBody()));
    }
}
