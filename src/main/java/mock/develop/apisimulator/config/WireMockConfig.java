package mock.develop.apisimulator.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.MappingBuilder;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.common.SingleRootFileSource;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.standalone.JsonFileMappingsSource;
import mock.develop.apisimulator.repository.JdbcWireMockMappingRepository;
import mock.develop.apisimulator.repository.WireMockMappingRepository;
import mock.develop.apisimulator.service.WireMockMappingService;
import mock.develop.apisimulator.transformers.BasicResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class WireMockConfig {

    @Value("${wiremock.port}")
    private int wireMockPort;

    @Value("${wiremock.mappings-path}")
    private String mappingsPath;

    @Autowired
    private DataSource dataSource;

    @Bean
    public WireMockServer wireMockServer() {
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options()
                .usingFilesUnderClasspath("mappings")
                .notifier(new ConsoleNotifier(true))
                .port(wireMockPort));
        wireMockServer.loadMappingsUsing(new JsonFileMappingsSource(new SingleRootFileSource(mappingsPath)));
        return wireMockServer;
    }

/*    @Bean
    public WireMockConfiguration wireMockConfigurat() {
        return WireMockConfiguration.options()
                .usingFilesUnderClasspath("mappings")
                .notifier(new ConsoleNotifier(true))
                .extensions(BasicResponseTransformer.class);
    }*/

/*    @Bean
    public WireMockMappingRepository wireMockMappingRepository() {
        return new JdbcWireMockMappingRepository(new JdbcTemplate(dataSource));
    }*/

/*    @Bean(initMethod = "initializeMappings")
    public WireMockMappingService wireMockMappingService(WireMockServer wireMockServer, WireMockMappingRepository mappingRepository
            , MappingBuilder mappingBuilder) {
        WireMockMappingService mappingService = new WireMockMappingService(mappingRepository, wireMockServer);
        mappingService.initializeMappings();
        return mappingService;
    }*/

}
