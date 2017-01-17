CREATE TABLE OSORNOUSR.CAT_STATES (
    ID      NUMBER(10) PRIMARY KEY,
    NAME    VARCHAR2(50) NOT NULL
);

CREATE SEQUENCE OSORNOUSR.CAT_STATES_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Aguascalientes');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Baja California');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Baja California Sur');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Campeche');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Coahuila');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Colima');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Chiapas');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Chihuahua');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Distrito Federal');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Durango');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Guanajuato');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Guerrero');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Hidalgo');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Jalisco');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'M�xico');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Michoac�n');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Morelos');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Nayarit');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Nuevo Le�n');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Oaxaca');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Puebla');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Quer�taro');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Quintana Roo');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'San Luis Potos�');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Sinaloa');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Sonora');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Tabasco');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Tamaulipas');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Tlaxcala');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Veracruz');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Yucat�n');
INSERT INTO OSORNOUSR.CAT_STATES(ID, NAME) VALUES(OSORNOUSR.CAT_STATES_SEQ.nextval, 'Zacatecas');

CREATE TABLE OSORNOUSR.CAT_INDUSTRIES (
    ID                      NUMBER(10) PRIMARY KEY,
    NAME                    VARCHAR2(50) NOT NULL
);
CREATE SEQUENCE OSORNOUSR.CAT_INDUSTRIES_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Textil');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'El�ctrica');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Cinematogr�fica');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Azucarera');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Minera');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Metal�rgica');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Sider�rgica');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Hidrocarburos');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Petroqu�mica');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Cementera');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Qu�mica');
INSERT INTO OSORNOUSR.CAT_INDUSTRIES(ID, NAME) VALUES(OSORNOUSR.CAT_INDUSTRIES_SEQ.nextval, 'Otra');

CREATE TABLE OSORNOUSR.TB_SUSCRIPTOR (
    ID                      NUMBER(10) PRIMARY KEY,
    NAME                    VARCHAR2(50) NOT NULL,
    EMAIL                   VARCHAR2(50) NOT NULL,
    LAST_NAME               VARCHAR2(50) NOT NULL,
    MATERNAL_LAST_NAME      VARCHAR2(50),  
    STATE_ID                NUMBER(10) NOT NULL CONSTRAINT FK_TB_SUSCRIPTOR_STATE_ID REFERENCES OSORNOUSR.CAT_STATES (Id), 
    INDUSTRY_ID             NUMBER(10) NOT NULL CONSTRAINT FK_TB_SUSCRIPTOR_IDUSTRY_ID REFERENCES OSORNOUSR.CAT_INDUSTRIES (Id), 
    INSERT_DATE             DATE DEFAULT (sysdate)
);
CREATE SEQUENCE OSORNOUSR.TB_SUSCRIPTOR_SEQ
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
