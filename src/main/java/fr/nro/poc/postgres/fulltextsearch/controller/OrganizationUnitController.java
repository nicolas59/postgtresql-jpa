package fr.nro.poc.postgres.fulltextsearch.controller;

import fr.nro.poc.postgres.fulltextsearch.domain.OrganizationUnit;
import fr.nro.poc.postgres.fulltextsearch.service.OrganizationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/uo")
public class OrganizationUnitController {

    @Autowired
    private OrganizationUnitService organizationUnitService;

    @GetMapping("/path")
    private List<OrganizationUnit> findByPath(@RequestParam String path){
        return this.organizationUnitService.findByPath(path);
    }


    @GetMapping("/ancestors")
    private List<OrganizationUnit> findAncestorsByPath(@RequestParam String path){
        return this.organizationUnitService.findAncestorByPath(path);
    }

    @Transactional
    @PostMapping
    private ResponseEntity<Void> create(@RequestBody OrganizationUnit uo){
        this.organizationUnitService.save(uo);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/uo/{id}").build(uo.getId())).build();
    }
}
