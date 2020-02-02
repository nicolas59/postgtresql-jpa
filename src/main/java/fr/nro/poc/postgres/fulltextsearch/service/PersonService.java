package fr.nro.poc.postgres.fulltextsearch.service;

import fr.nro.poc.postgres.fulltextsearch.domain.FullSearchItem;
import fr.nro.poc.postgres.fulltextsearch.domain.Person;
import fr.nro.poc.postgres.fulltextsearch.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Component
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Page<Person> findByFullsearch(String fullsearch, int pageIndex, int pageSize) {

        String criteria = fullsearch.trim().replaceAll(":|\\+*", "")
                .replaceAll(" +", ":\\*|")
                .concat(":*");


        String order = fullsearch.trim().replaceAll(":|\\+*", "")
                .replaceAll(" +", ":\\*&")
                .concat(":*");

        log.debug("Search criteria : {}", criteria);
        log.debug("Rank criteria : {}", order);

        return this.personRepository.findByFullsearch(criteria, order, PageRequest.of(pageIndex, pageSize));
    }

    public void save(Person p) {
        this.personRepository.save(p);
    }
}
