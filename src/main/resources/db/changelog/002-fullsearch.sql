alter TABLE person add column fullsearch tsvector NULL;
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