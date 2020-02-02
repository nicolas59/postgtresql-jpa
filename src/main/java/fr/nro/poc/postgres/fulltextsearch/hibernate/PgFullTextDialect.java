package fr.nro.poc.postgres.fulltextsearch.hibernate;

import org.hibernate.dialect.PostgreSQL9Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.BigDecimalType;
import org.hibernate.type.ObjectType;

public class PgFullTextDialect extends PostgreSQL9Dialect {

    public PgFullTextDialect() {
        registerFunction("fts", new PgFullTextFunction());
        registerFunction("ts_rank", new StandardSQLFunction("ts_rank", BigDecimalType.INSTANCE));
        registerFunction("to_tsquery", new StandardSQLFunction("to_tsquery", ObjectType.INSTANCE));
    }
}
