package fr.nro.poc.postgres.fulltextsearch.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class Address {

    @Column(name="address_line1")
    private String line1;

    @Column(name="address_line2")
    private String line2;

    @Column(name="address_zip_code")
    private String zipCode;

    @Column(name="address_city")
    private String city;
}
