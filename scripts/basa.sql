-- Table: website

DROP TABLE IF EXISTS website CASCADE;

CREATE TABLE website
(
  id serial NOT NULL,
  url text,
  CONSTRAINT "PrimaryKEYWebSite" PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE website
  OWNER TO postgres;
  
-- Table: "authors"

DROP TABLE IF EXISTS "authors";

CREATE TABLE "authors"
(
  "id" serial NOT NULL,
  "fio" text,
  "websiteid" smallint,
  CONSTRAINT "PrimaryKEYAuthors" PRIMARY KEY ("id"),
  CONSTRAINT "ForeignKEYWebsite" FOREIGN KEY (websiteid)
      REFERENCES website (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT websiteconstraint UNIQUE (websiteid)    
)
WITH (
  OidS=FALSE
);
ALTER TABLE "authors"
  OWNER TO postgres;

-- Table: "authorsbooks"

DROP TABLE IF EXISTS "authorsbooks";

CREATE TABLE "authorsbooks"
(

)
WITH (
  OidS=FALSE
);
ALTER TABLE "authorsbooks"
  OWNER TO postgres;

-- Table: "books"

DROP TABLE IF EXISTS "books";

CREATE TABLE "books"
(
  "id" serial NOT NULL,
  "title" text,
  "description" text,
  CONSTRAINT "PrimaryKEYBooks" PRIMARY KEY ("id")
)
WITH (
  OidS=FALSE
);
ALTER TABLE "books"
  OWNER TO postgres;




insert into website (url) values ('www.tut.by');
insert into website (url) values ('www.mail.ru');
insert into website (url) values ('www.yandex.com');
insert into website (url) values ('www.google.com');

insert into authors (fio, websiteid) values ('Иванов И.И.', 1);
insert into authors (fio, websiteid) values ('Петров П.П.', 2);
insert into authors (fio, websiteid) values ('Сидоров С.С.', 3);
insert into authors (fio, websiteid) values ('Пупкин В.В.', 4);
insert into authors (fio, websiteid) values ('Галкин Н.Н.', null);
insert into authors (fio, websiteid) values ('Пугачев А.А.', null);