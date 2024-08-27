CREATE USER maiphysical WITH PASSWORD 'maiphysical';
GRANT maiphysical TO postgres;
CREATE SCHEMA AUTHORIZATION maiphysical;
GRANT ALL ON TABLESPACE pg_default TO maiphysical;
