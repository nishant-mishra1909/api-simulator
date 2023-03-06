package mock.develop.apisimulator.controller;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import mock.develop.apisimulator.model.APIStubMapping;
import mock.develop.apisimulator.service.WireMockMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mappings")
public class WireMockMappingController {

    private final WireMockMappingService mappingService;
    private final WireMockServer server;
    private final MeterRegistry meterRegistry;

    @Autowired
    public WireMockMappingController(WireMockMappingService mappingService, WireMockServer server,
                                     MeterRegistry meterRegistry) {
        this.mappingService = mappingService;
        this.server = server;
        this.meterRegistry = meterRegistry;
    }

    @PostMapping("/api/save")
    @Timed(value = "simulation_add_rest", description = "Time taken to execute save endpoint")
    public ResponseEntity<Void> createMapping(@RequestBody APIStubMapping mapping) {
        mappingService.saveMapping(mapping);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @Timed(value = "simulation_list", description = "Time taken to execute save endpoint")
    public String listMappings(Model model) {
        List<APIStubMapping> mappings = mappingService.getAllMappings();
        model.addAttribute("mappings", mappings);
        return "mappings";
    }


    @PostMapping("")
    @Timed(value = "simulation_save", description = "Time taken to execute save endpoint")
    public String saveMapping(@ModelAttribute APIStubMapping mapping) {
        mappingService.saveMapping(mapping);
        return "redirect:/mappings";
    }

    @GetMapping("/{id}/edit")
    @Timed(value = "simulation_edit", description = "Time taken to execute save endpoint")
    public String editMapping(@PathVariable Long id, Model model) {
        APIStubMapping mapping = mappingService.getMappingById(id);
        model.addAttribute("mapping", mapping);
        return "form";
    }

    @GetMapping("/add")
    @Timed(value = "simulation_add_ui_duration", description = "Time taken to execute save endpoint")
    public String addMapping(Model model) {
        model.addAttribute("mapping", new APIStubMapping());
        return "form";
    }



    @PostMapping("/{id}/delete")
    @Timed(value = "simulation_delete_endpoint_duration", description = "Time taken to execute save endpoint")
    public String deleteMapping(@PathVariable Long id) {
        mappingService.deleteMappingById(id);
        return "redirect:/mappings";
    }


}
