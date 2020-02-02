package fr.nro.poc.postgres.fulltextsearch.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class FullSearchItem<T> {

    private T item;

    private BigDecimal rank;


}
