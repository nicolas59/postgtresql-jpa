package fr.nro.poc.postgres.fulltextsearch.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vladmihalcea.hibernate.type.search.PostgreSQLTSVectorType;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.StringJoiner;

@Entity
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lastname;

    private String firstname;

    @Embedded
    private Address  address;


    @JsonIgnore
    @Column(name="fulltext")
    private String fullText;

    @JsonIgnore
    @Column(name="fullsearch")
    private transient String fullsearch;

    @PrePersist
    @PreUpdate
    public void prePersist(){
        StringJoiner joiner = new StringJoiner(" ");
        joiner.add(this.lastname);
        joiner.add(this.firstname);
        if(address != null){
            joiner.add(address.getLine1());
            joiner.add(address.getLine2());
            joiner.add(address.getCity());
            joiner.add(address.getZipCode());
        }
        this.fullText= joiner.toString();
    }


}
