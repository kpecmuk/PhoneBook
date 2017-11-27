CREATE TABLE names
(
  contact VARCHAR(50) NOT NULL,
  phone   VARCHAR(50) NOT NULL,
  CONSTRAINT names_contact_phone_pk
  UNIQUE (contact, phone)
);