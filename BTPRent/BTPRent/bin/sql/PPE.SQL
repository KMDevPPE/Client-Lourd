DROP DATABASE IF EXISTS PPE;

CREATE DATABASE IF NOT EXISTS PPE;
USE PPE;
# -----------------------------------------------------------------------------
#       TABLE : ENTREPRISE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ENTREPRISE
 (
   ID_C INTEGER(2) NOT NULL auto_increment,
   RAISON VARCHAR(32) NULL  ,
   REPRESENTANT VARCHAR(32) NULL  ,
   ADRESSE VARCHAR(32) NULL  ,
   TELEPHONE VARCHAR(10) NULL  ,
   MAIL VARCHAR(32) not null,
   MDP VARCHAR(32) not NULL  
   , PRIMARY KEY (ID_C) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SALAIRIE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SALAIRIE
 (
   ID_S INTEGER(2) NOT NULL auto_increment ,
   NOM_S VARCHAR(32) NULL  ,
   MAIL VARCHAR(32) not null,
   PRENOM_S VARCHAR(32) not NULL 
   , PRIMARY KEY (ID_S) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : MATERIEL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MATERIEL
 (
   ID_M INTEGER(2) NOT NULL auto_increment ,
   ID_LOCATION INTEGER(2)  ,
   ID_TYPE VARCHAR(5) NOT NULL  ,
   ID_ETAT INTEGER(2) ,
   NOM_M VARCHAR(32) NULL  ,
   IMAGE_M VARCHAR(100) ,
   PRIX DECIMAL(10,2)
   , PRIMARY KEY (ID_M) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE MATERIEL
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_MATERIEL_LOCATION
     ON MATERIEL (ID_LOCATION ASC);

CREATE  INDEX I_FK_MATERIEL_TYPE_MATERIEL
     ON MATERIEL (ID_TYPE ASC);

CREATE  INDEX I_FK_MATERIEL_ETAT
     ON MATERIEL (ID_ETAT ASC);

# -----------------------------------------------------------------------------
#       TABLE : TYPE_MATERIEL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TYPE_MATERIEL
 (
   ID_TYPE INT(3) NOT NULL auto_increment ,
   LIBELLE VARCHAR(32) NULL  
   , PRIMARY KEY (ID_TYPE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ETAT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ETAT
 (
   ID_ETAT INTEGER(2) NOT NULL auto_increment ,
   NOM_ETAT VARCHAR(32) NULL  
   , PRIMARY KEY (ID_ETAT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
   ID_C INTEGER(2) NOT NULL auto_increment ,
   ADRESSE VARCHAR(32) NULL  ,
   TELEPHONE VARCHAR(10) NULL  ,
   MAIL VARCHAR(32) not null,
   MDP VARCHAR(32) not null
   , PRIMARY KEY (ID_C) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CONTRAT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONTRAT
 (
   ID_CONT INTEGER(2) NOT NULL auto_increment ,
   ID_S INTEGER(2) NOT NULL  ,
   ID_C INTEGER(2) NOT NULL  ,
   ID_T INTEGER(2) NOT NULL  
   , PRIMARY KEY (ID_CONT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE CONTRAT
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_CONTRAT_SALAIRIE
     ON CONTRAT (ID_S ASC);

CREATE  INDEX I_FK_CONTRAT_CLIENT
     ON CONTRAT (ID_C ASC);

CREATE  INDEX I_FK_CONTRAT_TECHNICIEN
     ON CONTRAT (ID_T ASC);

# -----------------------------------------------------------------------------
#       TABLE : TECHNICIEN
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TECHNICIEN
 (
   ID_T INTEGER(2) NOT NULL auto_increment ,
   NOM_T VARCHAR(32) NULL  ,
   PRENOM_T VARCHAR(32) NULL  
   , PRIMARY KEY (ID_T) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : LOCATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LOCATION
 (
   LIEUX VARCHAR(32) NULL ,
   ID_LOCATION INTEGER(2) NOT NULL  
   , PRIMARY KEY (ID_LOCATION) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PARTICULIER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTICULIER
 (
   ID_C INTEGER(2) NOT NULL auto_increment ,
   NOM_P VARCHAR(32) NULL  ,
   PRENOM_P VARCHAR(32) NULL  ,
   ADRESSE VARCHAR(32) NULL  ,
   TELEPHONE VARCHAR(10) NULL  ,
   MAIL VARCHAR (100) NULL, 
   MDP VARCHAR(32) NULL  
   , PRIMARY KEY (ID_C) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : LOUER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LOUER
 (
   ID_CONT INTEGER(2) NOT NULL auto_increment ,
   ID_M INTEGER(2) NOT NULL  ,
   DATE_DEB DATE NULL  ,
   DATE_FIN DATE NULL  
   , PRIMARY KEY (ID_CONT,ID_M) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE LOUER
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_LOUER_CONTRAT
     ON LOUER (ID_CONT ASC);

CREATE  INDEX I_FK_LOUER_MATERIEL
     ON LOUER (ID_M ASC);

# -----------------------------------------------------------------------------
#       TABLE : INTERVENIR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS INTERVENIR
 (
   ID_T INTEGER(2) NOT NULL auto_increment ,
   ID_M INTEGER(2) NOT NULL  
   , PRIMARY KEY (ID_T,ID_M) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       INDEX DE LA TABLE INTERVENIR
# -----------------------------------------------------------------------------


CREATE  INDEX I_FK_INTERVENIR_TECHNICIEN
     ON INTERVENIR (ID_T ASC);

CREATE  INDEX I_FK_INTERVENIR_MATERIEL
     ON INTERVENIR (ID_M ASC);


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE ENTREPRISE 
  ADD FOREIGN KEY FK_ENTREPRISE_CLIENT (ID_C)
      REFERENCES CLIENT (ID_C) ;


ALTER TABLE MATERIEL 
  ADD FOREIGN KEY FK_MATERIEL_LOCATION (ID_LOCATION)
      REFERENCES LOCATION (ID_LOCATION) ;


ALTER TABLE MATERIEL 
  ADD FOREIGN KEY FK_MATERIEL_TYPE_MATERIEL (ID_TYPE)
      REFERENCES TYPE_MATERIEL (ID_TYPE) ;


ALTER TABLE MATERIEL 
  ADD FOREIGN KEY FK_MATERIEL_ETAT (ID_ETAT)
      REFERENCES ETAT (ID_ETAT) ;


ALTER TABLE CONTRAT 
  ADD FOREIGN KEY FK_CONTRAT_SALAIRIE (ID_S)
      REFERENCES SALAIRIE (ID_S) ;


ALTER TABLE CONTRAT 
  ADD FOREIGN KEY FK_CONTRAT_CLIENT (ID_C)
      REFERENCES CLIENT (ID_C) ;


ALTER TABLE CONTRAT 
  ADD FOREIGN KEY FK_CONTRAT_TECHNICIEN (ID_T)
      REFERENCES TECHNICIEN (ID_T) ;


ALTER TABLE PARTICULIER 
  ADD FOREIGN KEY FK_PARTICULIER_CLIENT (ID_C)
      REFERENCES CLIENT (ID_C) ;


ALTER TABLE LOUER 
  ADD FOREIGN KEY FK_LOUER_CONTRAT (ID_CONT)
      REFERENCES CONTRAT (ID_CONT) ;


ALTER TABLE LOUER 
  ADD FOREIGN KEY FK_LOUER_MATERIEL (ID_M)
      REFERENCES MATERIEL (ID_M) ;


ALTER TABLE INTERVENIR 
  ADD FOREIGN KEY FK_INTERVENIR_TECHNICIEN (ID_T)
      REFERENCES TECHNICIEN (ID_T) ;


ALTER TABLE INTERVENIR 
  ADD FOREIGN KEY FK_INTERVENIR_MATERIEL (ID_M)
      REFERENCES MATERIEL (ID_M) ;



