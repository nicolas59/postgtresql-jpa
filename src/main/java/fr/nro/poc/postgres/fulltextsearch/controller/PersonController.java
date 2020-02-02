package fr.nro.poc.postgres.fulltextsearch.controller;

import fr.nro.poc.postgres.fulltextsearch.domain.Person;
import fr.nro.poc.postgres.fulltextsearch.repository.PersonRepository;
import fr.nro.poc.postgres.fulltextsearch.service.PersonService;
import org.aspectj.weaver.patterns.PerObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
public class PersonController {


    @Autowired
    private PersonService personService;

    @GetMapping
    public Page<Person> findAll(@RequestParam(required = true) String search, @RequestParam(defaultValue = "0") int pageIndex, @RequestParam(defaultValue = "10") int pageSize) {
        return this.personService.findByFullsearch(search, pageIndex, pageSize);
    }

    @Transactional
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> create(@RequestBody Person p) {
        this.personService.save(p);
        return ResponseEntity.created(UriComponentsBuilder.fromPath("/person/{id}").build(p.getId())).build();

    }
}
