package fr.nro.poc.postgres.fulltextsearch.repository;

import fr.nro.poc.postgres.fulltextsearch.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "select p  from Person p where fts(fullsearch, ?1) = true  order by ts_rank( fullsearch,to_tsquery(?2)) desc")
    Page<Person> findByFullsearch(String fullsearch, String order, Pageable pageable);
}
