DROP TABLE IF EXISTS branches;
DROP TABLE IF EXISTS tips;
DROP TABLE IF EXISTS key_words;
DROP TABLE IF EXISTS real_words;
DROP TABLE IF EXISTS departments_translate;
DROP TABLE IF EXISTS categories_translate;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS departments;
DROP TABLE IF EXISTS languages;
DROP SEQUENCE IF EXISTS global_seq;

CREATE EXTENSION postgis;
CREATE EXTENSION btree_gist;
CREATE SEQUENCE global_seq START 100000;

CREATE TABLE languages
(
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name        VARCHAR NOT NULL
);

CREATE TABLE departments
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq')
);

CREATE TABLE categories
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq')
);

CREATE TABLE categories_translate
(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name           VARCHAR NOT NULL,
  category_id    INTEGER NOT NULL,
  language_id    INTEGER NOT NULL,
  FOREIGN KEY (language_id) REFERENCES languages (id) ON DELETE CASCADE
);

CREATE TABLE departments_translate
(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name           VARCHAR NOT NULL,
  category_id    INTEGER NOT NULL,
  language_id    INTEGER NOT NULL,
  department_id  INTEGER NOT NULL,
  FOREIGN KEY (category_id) REFERENCES categories (id) ON DELETE CASCADE,
  FOREIGN KEY (department_id) REFERENCES departments (id) ON DELETE CASCADE,
  FOREIGN KEY (language_id) REFERENCES languages (id) ON DELETE CASCADE
);

CREATE TABLE real_words
(
  name                     VARCHAR NOT NULL,
  department_translate_id  INTEGER NOT NULL,
  language_id    INTEGER NOT NULL,
  FOREIGN KEY (language_id) REFERENCES languages (id) ON DELETE CASCADE,
  FOREIGN KEY (department_translate_id) REFERENCES departments_translate (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX real_words_unique_name ON real_words (name);

CREATE TABLE key_words
(
  name             VARCHAR NOT NULL,
  real_word_name   VARCHAR NOT NULL,
  language_id    INTEGER NOT NULL,
  FOREIGN KEY (language_id) REFERENCES languages (id) ON DELETE CASCADE,
  FOREIGN KEY (real_word_name) REFERENCES real_words (name) ON DELETE CASCADE
);

CREATE TABLE tips
(
  name           VARCHAR NOT NULL,
  department_id  INTEGER NOT NULL,
  language_id    INTEGER NOT NULL,
  FOREIGN KEY (department_id) REFERENCES departments (id) ON DELETE CASCADE,
  FOREIGN KEY (language_id) REFERENCES languages (id) ON DELETE CASCADE
);

CREATE TABLE branches
(
  id             INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  department_id  INTEGER NOT NULL,
  place_id       VARCHAR NOT NULL,
  latitude       DOUBLE PRECISION NOT NULL CHECK(latitude > -90 and latitude <= 90),
  longitude      DOUBLE PRECISION NOT NULL CHECK(longitude > -180 and longitude <= 180),
  phone          TEXT NOT NULL,
  hour           TEXT NOT NULL,
  location       geography(POINT, 4326) NOT NULL, -- PostGIS geom field with SRID 4326
  FOREIGN KEY (department_id) REFERENCES departments (id) ON DELETE CASCADE
);
CREATE UNIQUE INDEX branches_unique_place_department_idx ON branches (place_id, department_id);
CREATE INDEX branches_location_idx ON branches USING GIST(location);