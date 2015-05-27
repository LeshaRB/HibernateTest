-- Table: "authors"

DROP TABLE IF EXISTS "authors";

CREATE TABLE "authors"
(
  "id" serial NOT NULL,
  "fio" text,
  CONSTRAINT "PrimaryKEYAuthors" PRIMARY KEY ("id")
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
