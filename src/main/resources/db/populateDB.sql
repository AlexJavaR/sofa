-- http://stackoverflow.com/questions/13223820/postgresql-delete-all-content
TRUNCATE branches CASCADE;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO departments (id) VALUES
  (nextval('global_seq')),
  (nextval('global_seq')),
  (nextval('global_seq')),
  (nextval('global_seq'));

INSERT INTO languages (name) VALUES
  ('ru'),
  ('fr'),
  ('he'),
  ('en');

INSERT INTO categories (id) VALUES
  (nextval('global_seq')),
  (nextval('global_seq')),
  (nextval('global_seq'));

INSERT INTO categories_translate (name, category_id, language_id) VALUES
  ('Банк', 100008, 100004),
  ('Министерство', 100009, 100004),
  ('Аптека', 100010, 100004),
  ('Bank', 100008, 100007),
  ('Ministry', 100009, 100007),
  ('Pharmacy', 100010, 100007);


INSERT INTO departments_translate (name, category_id, language_id, department_id) VALUES
  ('Хапоалим', 100008, 100004, 100000),
  ('Hapoalim', 100008, 100007, 100000),
  ('Леуми', 100008, 100004, 100001),
  ('Leumi', 100008, 100007, 100001),
  ('Абсорбции', 100009, 100004, 100002),
  ('Absorption', 100009, 100007, 100002),
  ('Суперфарм', 100010, 100004, 100003),
  ('Superpharm', 100010, 100007, 100003);

INSERT INTO tips (name, department_id, language_id) VALUES
  ('Банк Хапоалим', 100000, 100008),
  ('Банк Леуми', 100001, 100008),
  ('Министерство финансов', 100002, 100008),
  ('Министерство внутренних дел', 100003, 100008),
  ('Поликлиника', 100004, 100008),
  ('Больница', 100005, 100008),
  ('Министерство образования', 100006, 100008),
  ('Министерство обороны', 100007, 100008),
  ('Bank Hapoalim', 100000, 100011),
  ('Bank Leumi', 100001, 100011),
  ('Ministry of Finance', 100002, 100011),
  ('Ministry of Internal Affairs', 100003, 100011),
  ('Polyclinic', 100004, 100011),
  ('Hospital', 100005, 100011),
  ('Ministry of Education', 100006, 100011),
  ('Ministry of Defence', 100007, 100011);

INSERT INTO branches (place_id, latitude, longitude, department_id, phone, hour) VALUES
  ('D33eTgfaFFD54633Hgd2gsRHAethq5245thsetha', 34.55555, 55.32535, 100000, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSRHgf3aFFD54633Hgdgsey3543', 34.55555, 55.32535, 100000, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSRH4gfaFFD54633Hgdgs3412365', 34.55555, 55.32535, 100000, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSRH6gfaFFD54633Hgdgs23562', 34.55555, 55.32535, 100000, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425F7DSRHgfaFFD54633Hgdgs24727', 34.55555, 55.32535, 100000, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg24285FDSRHgfaFFD54633Hgdgs275257', 34.55555, 55.32535, 100001, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTgfaFFD54633Hgd2gsRHAethq5245thsetha', 34.55555, 55.32535, 100001, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDS0RHgfaFFD54633Hgdgssfjwsr434', 34.55555, 55.32535, 100001, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSRHgfa3FFD54633Hgdgsaeth356', 34.55555, 55.32535, 100001, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDS2RHgfaFFD54633Hgdgserha3553', 34.55555, 55.32535, 100001, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTgfaFFDg54633HgdgsRHAethq5245thsetha', 34.55555, 55.32535, 100002, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDbSRHgfaFFD54633Hgdgsey3543', 34.55555, 55.32535, 100002, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDdSRHgfaFFD54633Hgdgs3412365', 34.55555, 55.32535, 100002, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSsRHgfaFjFD54633Hgdgs23562', 34.55555, 55.32535, 100002, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSRHgfaFFdD54633Hgdgs24727', 34.55555, 55.32535, 100002, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSRHgfaFzFD54633Hgdgs275257', 34.55555, 55.32535, 100003, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSRHgfaFFD54633Hgdgsq6eyqet', 34.55555, 55.32535, 100003, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTgfaFFDg54633HgdgsRHAethq5245thsetha', 34.55555, 55.32535, 100003, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSRHgfaFFD54633Hgdgsa3eth356', 34.55555, 55.32535, 100003, '058-782-13-54', '8:00 - 16:00'),
  ('D33eTg2425FDSRHgfaFFsgD54633Hguwrydgserha3553', 34.55555, 55.32535, 100003, '058-782-13-54', '8:00 - 16:00');