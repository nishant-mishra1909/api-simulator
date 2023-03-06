package mock.develop.apisimulator.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.micrometer.core.instrument.Measurement;
import io.micrometer.core.instrument.Meter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class WireMockStatsController {

    private final WireMockServer server;
    private final MeterRegistry meterRegistry;

    @Autowired
    public WireMockStatsController(WireMockServer server, MeterRegistry meterRegistry) {
        this.server = server;
        this.meterRegistry = meterRegistry;
    }

    @GetMapping("/metrics")
    public Map<Meter.Id, Iterable<Measurement>> metrics() {
        return meterRegistry.getMeters().stream()
                .collect(Collectors.toMap(Meter::getId, Meter::measure));
    }

}
