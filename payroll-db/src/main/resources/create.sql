CREATE TABLE employe(
        ID SERIAL primary key not null ,
        NAME text,
        ADDRESS text  ,
        TYPE text,
        METHOD text,
        SCHEDULE text

);

CREATE TABLE mailMethod(
    ID SERIAL primary key  not null ,
    MAIL varchar[50],
    FOREIGN KEY (ID) REFERENCES employe(ID)

);

CREATE  TABLE directMethod(
    ID SERIAL PRIMARY KEY  not null ,
    BANK varchar[50],
    ACCOUNT varchar[50],
    FOREIGN KEY (ID) REFERENCES employe(ID)

);
CREATE  TABLE cashMethod(
    ID SERIAL primary key  not null,
    BANK varchar[50]

);

CREATE TABLE  sell(
    ID SERIAL primary key  not null ,
    NAME varchar[50],
    FOREIGN KEY (ID) REFERENCES  employe(ID)
);

CREATE TABLE salary(
        ID SERIAL primary key not null ,
        SALARY  int,
        FOREIGN KEY (ID) REFERENCES employe(ID)
);








--     private PayementMethod transaction;
--     private PayementSchedule payDay;
--     private PayementClassification classification;
--     private HashMap<Integer,Employe> listeEmploye;