package mock.develop.apisimulator.controller;

import mock.develop.apisimulator.model.APIStubMapping;
import mock.develop.apisimulator.service.WireMockMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mappings")
public class WireMockMappingController {

    private final WireMockMappingService mappingService;

    @Autowired
    public WireMockMappingController(WireMockMappingService mappingService) {
        this.mappingService = mappingService;
    }

    @PostMapping
    public ResponseEntity<Void> createMapping(@RequestBody APIStubMapping mapping) {
        mappingService.saveMapping(mapping);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<APIStubMapping> listMappings(){
         return mappingService.getAllMappings();
    }

}
