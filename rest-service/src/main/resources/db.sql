USE TEST;

DROP TABLE IF EXISTS MD_MAPPING;

CREATE TABLE MD_MAPPING(
	OBJECTTYPE VARCHAR(50),
    VERSION INT,
    COLUMN_NAME VARCHAR(50),
    COLUMN_ALIAS VARCHAR(50),
    FIELD VARCHAR(200)
);

DROP TABLE IF EXISTS MD_OBJECTTYPE;

CREATE TABLE MD_OBJECTTYPE(
	OBJECTTYPE VARCHAR(50),
    VERSION INT,
    VIEW_NAME VARCHAR(50),
    PRIMARY KEY (OBJECTTYPE, VERSION)
);



alter table md_mapping add foreign key (objecttype,version) references md_objecttype(objecttype,version);

insert into md_objecttype VALUES ('EMP',1, 'EMPLOYEE');

INSERT INTO MD_MAPPING VALUES('EMP',1, 'NAME','NAME','employee_name');
INSERT INTO MD_MAPPING VALUES('EMP',1, 'AGE','AGE','employee_age');
INSERT INTO MD_MAPPING VALUES('EMP',1, 'SALARY','SALARY','employee_salary');

select demo_id,demo_version,demo_isin from V_DEMO;

select o.objecttype,o.version,o.view_name,m.column_name,m.column_alias,m.field
 from md_objecttype o join md_mapping m on o.objecttype = m.objecttype and o.version=m.version; 