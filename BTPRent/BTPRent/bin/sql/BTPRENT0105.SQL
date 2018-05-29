DROP DATABASE IF EXISTS BTPRent;

CREATE DATABASE IF NOT EXISTS BTPRent;
USE BTPRent;
# -----------------------------------------------------------------------------
#       TABLE : LOCALISATION
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS LOCALISATION
 (
   ID_LOCALISATION INTEGER(2) NOT NULL auto_increment ,
   LIEUX VARCHAR(128) NULL  ,
   CP CHAR(5) NULL  ,
   rue_c VARCHAR(128) NULL  
   , PRIMARY KEY (ID_LOCALISATION) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : TYPE_MATERIEL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TYPE_MATERIEL
 (
   ID_TYPE CHAR(5) NOT NULL  ,
   LIBELLE CHAR(32) NULL  
   , PRIMARY KEY (ID_TYPE) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : MATERIEL
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS MATERIEL
 (
   ID_M INTEGER(2) NOT NULL auto_increment ,
   ID_LOCALISATION INTEGER(2) NOT NULL  ,
   ID_TYPE CHAR(5) NOT NULL  ,
   ID_ETAT INTEGER(2) NOT NULL  ,
   NOM_M CHAR(32) NULL  ,
   PRIX_M DECIMAL(10,2) NULL  ,
   DATE_DEB CHAR(32) NULL  ,
   DATE_FIN CHAR(32) NULL  
   , PRIMARY KEY (ID_M) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ETAT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ETAT
 (
   ID_ETAT INTEGER(2) NOT NULL  ,
   NOM_ETAT CHAR(32) NULL  
   , PRIMARY KEY (ID_ETAT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CONTRAT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CONTRAT
 (
   ID_CONT INTEGER(2) NOT NULL auto_increment ,
   ID_M INTEGER(2) NULL  ,
   ID_S INTEGER(2) NOT NULL  ,
   ID_C INTEGER(2) NOT NULL  ,
   DATE_DEB DATE NULL  ,
   DATE_F DATE NULL  
   , PRIMARY KEY (ID_CONT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : CLIENT
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS CLIENT
 (
   ID_C INTEGER(2) NOT NULL default 0 ,
   NOM_C VARCHAR(50) NOT NULL  ,
   PRENOM_C VARCHAR(50) NOT NULL  ,
   VILLE_C CHAR(32) NULL  ,
   CP_C CHAR(32) NULL  ,
   RUE_C VARCHAR(128) NULL  ,
   TELEPHONE CHAR(10) NULL  ,
   MAIL VARCHAR(128) NOT NULL  ,
   MDP CHAR(100) NOT NULL
   , PRIMARY KEY (ID_C) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : TECHNICIEN
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS TECHNICIEN
 (
   IDT INTEGER(2) NOT NULL auto_increment ,
   NOMT CHAR(32) NULL  ,
   PRENOMT CHAR(32) NULL  ,
   MAIL CHAR(100) NOT NULL  ,
   MDP CHAR(100) NOT NULL  
   , PRIMARY KEY (IDT) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : ENTREPRISE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS ENTREPRISE
 (
   ID_C INTEGER(2) NOT NULL default 0 ,
   RAISON VARCHAR(50) NULL  ,
   DOMAINE VARCHAR(50) NULL  ,
   SIRET CHAR(14) NULL  ,
   NOM_C VARCHAR(50) NOT NULL  ,
   PRENOM_C VARCHAR(50) NOT NULL  ,
   VILLE_C CHAR(32) NULL  ,
   CP_C CHAR(32) NULL  ,
   RUE_C VARCHAR(128) NULL  ,
   TELEPHONE CHAR(10) NULL  ,
   MAIL VARCHAR(128) NOT NULL  ,
   MDP CHAR(100) NOT NULL   
   , PRIMARY KEY (ID_C) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : SALARIE
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS SALARIE
 (
   ID_S INTEGER(2) NOT NULL auto_increment ,
   NOM_S CHAR(32) NULL  ,
   PRENOM_S CHAR(32) NULL  ,
   RUE_S VARCHAR(128) NULL  ,
   CP_S CHAR(5) NULL  ,
   VILLE_S VARCHAR(128) NULL  ,
   MAIL CHAR(32) NULL  ,
   MDP CHAR(32) NULL  ,
   DROITS ENUM('admin','util') NULL  
   , PRIMARY KEY (ID_S) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : PARTICULIER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS PARTICULIER
 (
   ID_C INTEGER(2) NOT NULL default 0 ,
   DATENAISS DATE NULL  ,
   NOM_C VARCHAR(50) NOT NULL  ,
   PRENOM_C VARCHAR(50) NOT NULL  ,
   VILLE_C CHAR(32) NULL  ,
   CP_C CHAR(32) NULL  ,
   rue_c VARCHAR(128) NULL  ,
   TELEPHONE CHAR(10) NULL  ,
   MAIL VARCHAR(128) NOT NULL  ,
   MDP CHAR(100) NOT NULL  
   , PRIMARY KEY (ID_C) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : INTERVENIR
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS INTERVENIR
 (
   IDT CHAR(32) NOT NULL  ,
   ID_M INTEGER(2) NOT NULL  ,
   DATE_DEBUT DATE NULL  ,
   DATE_FIN DATE NULL  
   , PRIMARY KEY (IDT,ID_M) 
 ) 
 comment = "";

# -----------------------------------------------------------------------------
#       TABLE : AFFILIER
# -----------------------------------------------------------------------------

CREATE TABLE IF NOT EXISTS AFFILIER
 (
   IDT CHAR(32) NOT NULL  ,
   ID_CONT INTEGER(2) NOT NULL  
   , PRIMARY KEY (IDT,ID_CONT) 
 ) 
 comment = "";


# -----------------------------------------------------------------------------
#       CREATION DES REFERENCES DE TABLE
# -----------------------------------------------------------------------------


ALTER TABLE MATERIEL 
  ADD FOREIGN KEY FK_MATERIEL_LOCALISATION (ID_LOCALISATION)
      REFERENCES LOCALISATION (ID_LOCALISATION) ;


ALTER TABLE MATERIEL 
  ADD FOREIGN KEY FK_MATERIEL_TYPE_MATERIEL (ID_TYPE)
      REFERENCES TYPE_MATERIEL (ID_TYPE) ;


ALTER TABLE MATERIEL 
  ADD FOREIGN KEY FK_MATERIEL_ETAT (ID_ETAT)
      REFERENCES ETAT (ID_ETAT) ;


ALTER TABLE CONTRAT 
  ADD FOREIGN KEY FK_CONTRAT_MATERIEL (ID_M)
      REFERENCES MATERIEL (ID_M) ;


ALTER TABLE CONTRAT 
  ADD FOREIGN KEY FK_CONTRAT_SALARIE (ID_S)
      REFERENCES SALARIE (ID_S) ;


ALTER TABLE CONTRAT 
  ADD FOREIGN KEY FK_CONTRAT_CLIENT (ID_C)
      REFERENCES CLIENT (ID_C) ;


ALTER TABLE ENTREPRISE 
  ADD FOREIGN KEY FK_ENTREPRISE_CLIENT (ID_C)
      REFERENCES CLIENT (ID_C) ;


ALTER TABLE PARTICULIER 
  ADD FOREIGN KEY FK_PARTICULIER_CLIENT (ID_C)
      REFERENCES CLIENT (ID_C) ;


ALTER TABLE INTERVENIR 
  ADD FOREIGN KEY FK_INTERVENIR_TECHNICIEN (IDT)
      REFERENCES TECHNICIEN (IDT) ;


ALTER TABLE INTERVENIR 
  ADD FOREIGN KEY FK_INTERVENIR_MATERIEL (ID_M)
      REFERENCES MATERIEL (ID_M) ;


ALTER TABLE AFFILIER 
  ADD FOREIGN KEY FK_AFFILIER_TECHNICIEN (IDT)
      REFERENCES TECHNICIEN (IDT) ;


ALTER TABLE AFFILIER 
  ADD FOREIGN KEY FK_AFFILIER_CONTRAT (ID_CONT)
      REFERENCES CONTRAT (ID_CONT) ;

