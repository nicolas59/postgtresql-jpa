package fr.nro.poc.postgres.fulltextsearch.domain;

import ch.qos.logback.classic.boolex.GEventEvaluator;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.print.DocFlavor;

@Entity
@Data
public class OrganizationUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String label;

    private String code;

    @Column(name = "path", nullable = false, columnDefinition = "ltree")
    @Type(type = "fr.nro.poc.postgres.fulltextsearch.hibernate.LTreeType")
    private String path;



}
