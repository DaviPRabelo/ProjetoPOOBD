-- MySQL Workbench Forward Engineering

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Streaming`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Streaming` (
  `idStreaming` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idStreaming`));



-- -----------------------------------------------------
-- Table `mydb`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Login` (
  `idLogin` INT NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `senha` VARCHAR(45) NOT NULL,
  `Streaming_idStreaming` INT NOT NULL,
  PRIMARY KEY (`idLogin`),
  CONSTRAINT `fk_Login_Streaming1`
    FOREIGN KEY (`Streaming_idStreaming`)
    REFERENCES `mydb`.`Streaming` (`idStreaming`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `mydb`.`Filmes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Filmes` (
  `idFilmes` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Genero` VARCHAR(45) NOT NULL,
  `Duracao` DOUBLE NOT NULL,
  `Nota` DOUBLE NOT NULL,
  `Diretor` VARCHAR(45) NOT NULL,
  `Streaming_idStreaming` INT NOT NULL,
  PRIMARY KEY (`idFilmes`),
  CONSTRAINT `fk_Filmes_Streaming1`
    FOREIGN KEY (`Streaming_idStreaming`)
    REFERENCES `mydb`.`Streaming` (`idStreaming`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `mydb`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Usuario` (
  `idUsuario` INT NOT NULL,
  `Nome` VARCHAR(45) NULL,
  `Login_idLogin` INT NOT NULL,
`Streaming_idStreaming` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
  CONSTRAINT `fk_Usuario_Login1`
    FOREIGN KEY (`Login_idLogin`)
    REFERENCES `mydb`.`Login` (`idLogin`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
     CONSTRAINT `fk_Login_Streaming2`
    FOREIGN KEY (`Streaming_idStreaming`)
    REFERENCES `mydb`.`Streaming` (`idStreaming`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `mydb`.`Series`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Series` (
  `idSeries` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `qntEp` INT NOT NULL,
  `genero` VARCHAR(45) NOT NULL,
  `Diretor` VARCHAR(45) NOT NULL,
  `Nota` DOUBLE NOT NULL,
  `Streaming_idStreaming` INT NOT NULL,
  PRIMARY KEY (`idSeries`),
  CONSTRAINT `fk_Series_Streaming1`
    FOREIGN KEY (`Streaming_idStreaming`)
    REFERENCES `mydb`.`Streaming` (`idStreaming`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `mydb`.`Ator`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ator` (
  `idAtor` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Idade` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idAtor`));



-- -----------------------------------------------------
-- Table `mydb`.`Ator_has_Filmes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ator_has_Filmes` (
  `Ator_idAtor` INT NOT NULL,
  `Filmes_idFilmes` INT NOT NULL,
  PRIMARY KEY (`Ator_idAtor`, `Filmes_idFilmes`),
  CONSTRAINT `fk_Ator_has_Filmes_Ator`
    FOREIGN KEY (`Ator_idAtor`)
    REFERENCES `mydb`.`Ator` (`idAtor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ator_has_Filmes_Filmes1`
    FOREIGN KEY (`Filmes_idFilmes`)
    REFERENCES `mydb`.`Filmes` (`idFilmes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `mydb`.`Ator_has_Series`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Ator_has_Series` (
  `Ator_idAtor` INT NOT NULL,
  `Series_idSeries` INT NOT NULL,
  PRIMARY KEY (`Ator_idAtor`, `Series_idSeries`),
  CONSTRAINT `fk_Ator_has_Series_Ator1`
    FOREIGN KEY (`Ator_idAtor`)
    REFERENCES `mydb`.`Ator` (`idAtor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ator_has_Series_Series1`
    FOREIGN KEY (`Series_idSeries`)
    REFERENCES `mydb`.`Series` (`idSeries`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

    


