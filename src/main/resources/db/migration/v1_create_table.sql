create table appliquart_agency(
  main_uuid BINARY(16) NOT NULL,
   published BIT(1) NULL,
   version INT NOT NULL,
   created datetime NULL,
   edited datetime NULL,
   creator VARCHAR(255) NULL,
   editor VARCHAR(255) NULL,
   code VARCHAR(255) NOT NULL,
   name VARCHAR(255) NOT NULL,
   address VARCHAR(255) NOT NULL,
   picture VARCHAR(255) NULL,
   about VARCHAR(255) NULL,
   constraint pk_agency PRIMARY KEY (main_uuid)
);

alter table agency add constraint uc_agency_code unique(code);