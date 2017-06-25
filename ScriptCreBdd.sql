#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Niveau
#------------------------------------------------------------

CREATE TABLE Niveau(
        Id_Carte   Int NOT NULL ,
        Difficulte Int NOT NULL ,
        TargetD    Int ,
        TotalD     Int ,
        TargetTime Int ,
        CooXStart  Int ,
        CooYStart  Int ,
        PRIMARY KEY (Id_Carte )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Type
#------------------------------------------------------------

CREATE TABLE Type(
        Id_Type  Int NOT NULL ,
        Solide   Bool NOT NULL ,
        NomObjet Varchar (25) ,
        PRIMARY KEY (Id_Type )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: Carré
#------------------------------------------------------------

CREATE TABLE Carre(
        Id       int (11) Auto_increment  NOT NULL ,
        CooX     Int NOT NULL ,
        CooY     Int NOT NULL ,
        Id_Carte Int NOT NULL ,
        Id_Type  Int NOT NULL ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;

ALTER TABLE Carre ADD CONSTRAINT FK_Carre_Id_Carte FOREIGN KEY (Id_Carte) REFERENCES Niveau(Id_Carte);
ALTER TABLE Carre ADD CONSTRAINT FK_Carre_Id_Type FOREIGN KEY (Id_Type) REFERENCES Type(Id_Type);

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `GetLevel`(IN `lvl` INT(4))
    READS SQL DATA
SELECT CooX, CooY, Id_Type FROM carré WHERE Id_Carte = lvl$$
DELIMITER ;