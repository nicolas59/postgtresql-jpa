CREATE TABLE person (
	id serial NOT NULL,
	lastname varchar(50) NULL,
	firstname varchar(50) NULL,
	address_line1 varchar(50) NULL,
	address_line2 varchar(50) NULL,
	address_zip_code varchar(10) NULL,
	address_city varchar(100) NULL,
	fulltext text NULL,
	fullsearch tsvector NULL
);

ALTER TABLE person ADD CONSTRAINT person_pk PRIMARY KEY (id);
CREATE INDEX person_fullsearch_idx ON person (fullsearch);

CREATE OR REPLACE FUNCTION person_vector_update()
  RETURNS trigger AS
$BODY$
BEGIN
    IF TG_OP = 'INSERT' OR  TG_OP = 'UPDATE' THEN
        new.fullsearch = to_tsvector(COALESCE(NEW.fulltext, ''));
    END IF;
    RETURN NEW;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;

CREATE TRIGGER tsvectorupdate_person BEFORE INSERT OR UPDATE ON person
FOR EACH ROW EXECUTE PROCEDURE person_vector_update();