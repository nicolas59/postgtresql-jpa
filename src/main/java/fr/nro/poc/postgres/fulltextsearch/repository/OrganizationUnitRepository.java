package fr.nro.poc.postgres.fulltextsearch.repository;

import fr.nro.poc.postgres.fulltextsearch.domain.OrganizationUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganizationUnitRepository extends JpaRepository<OrganizationUnit, Long> {

    @Query(value = "select * from organization_unit uo where uo.path<@text2ltree(?1) order by path", nativeQuery = true)
    List<OrganizationUnit> findByPath(String path);


    @Query(value = "select * from organization_unit uo where uo.path@>text2ltree(?1) order by path", nativeQuery = true)
    List<OrganizationUnit> findByAncestors(String path);
}
