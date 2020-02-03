package fr.nro.poc.postgres.fulltextsearch.service;

import fr.nro.poc.postgres.fulltextsearch.domain.OrganizationUnit;
import fr.nro.poc.postgres.fulltextsearch.repository.OrganizationUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Service
public class OrganizationUnitService {

    @Autowired
    private OrganizationUnitRepository organizationUnitRepository;


    public List<OrganizationUnit> findByPath(@NotEmpty String path){
        return this.organizationUnitRepository.findByPath(path);
    }

    public List<OrganizationUnit> findAncestorByPath(@NotEmpty String path){
        return this.organizationUnitRepository.findByAncestors(path);
    }

    public void save(OrganizationUnit uo){
        this.organizationUnitRepository.save(uo);
    }
}
