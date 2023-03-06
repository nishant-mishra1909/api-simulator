package mock.develop.apisimulator.service;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import mock.develop.apisimulator.model.APIStubMapping;
import mock.develop.apisimulator.repository.WireMockMappingRepository;
import mock.develop.apisimulator.util.SimulatorUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import java.util.List;
import java.util.Map;

@Service
public class WireMockMappingService {

    private final WireMockMappingRepository mappingRepository;
    private final WireMockServer wireMockServer;

    @Autowired
    public WireMockMappingService(WireMockMappingRepository mappingRepository, WireMockServer wireMockServer) {
        this.mappingRepository = mappingRepository;
        this.wireMockServer = wireMockServer;
    }


    public void saveMapping(APIStubMapping mapping) {
        mappingRepository.save(mapping);
        resetMappings();

    }

    public List<APIStubMapping> getAllMappings() {
        return mappingRepository.findAll();
    }


    @PostConstruct
    public void initializeMappings() {
        List<APIStubMapping> mappings = mappingRepository.findAll();
        mappings.forEach(mapping -> wireMockServer.stubFor(SimulatorUtil.getStubMapping(mapping)));
    }

    public void resetMappings() {

        wireMockServer.resetMappings();
        initializeMappings();
    }

    public APIStubMapping getMappingById(Long id) {
        return mappingRepository.findById(id).orElse(null);
    }

    public void deleteMappingById(Long id) {
        mappingRepository.deleteById(id);
    }
}
