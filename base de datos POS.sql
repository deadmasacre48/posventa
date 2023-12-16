-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbsistemsale
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dbsistemsale
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbsistemsale` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `dbsistemsale` ;

-- -----------------------------------------------------
-- Table `dbsistemsale`.`tbcabezeraventa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbsistemsale`.`tbcabezeraventa` (
  `idcabezeraventa` INT NOT NULL AUTO_INCREMENT,
  `idcliente` INT NOT NULL,
  `valorPagar` DOUBLE(10,2) NOT NULL,
  `fechaVenta` DATE NOT NULL,
  `estado` INT NOT NULL,
  PRIMARY KEY (`idcabezeraventa`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbsistemsale`.`tbcategoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbsistemsale`.`tbcategoria` (
  `idcategoria` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(200) NOT NULL,
  `estado` INT NOT NULL,
  PRIMARY KEY (`idcategoria`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbsistemsale`.`tbcliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbsistemsale`.`tbcliente` (
  `idcliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  `cedula` VARCHAR(15) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `direccion` VARCHAR(100) NOT NULL,
  `estado` INT NOT NULL,
  PRIMARY KEY (`idcliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbsistemsale`.`tbdetalleventa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbsistemsale`.`tbdetalleventa` (
  `iddetalleventa` INT NOT NULL AUTO_INCREMENT,
  `idcabezeraventa` INT NOT NULL,
  `idproducto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  `precioUnidad` DOUBLE(10,2) NOT NULL,
  `subTotal` DOUBLE(10,2) NOT NULL,
  `descuento` DOUBLE(10,2) NOT NULL,
  `iva` DOUBLE(10,2) NOT NULL,
  `totalPagar` DOUBLE(10,2) NOT NULL,
  `estado` INT NOT NULL,
  PRIMARY KEY (`iddetalleventa`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbsistemsale`.`tbproducto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbsistemsale`.`tbproducto` (
  `idproducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(100) NOT NULL,
  `cantidad` INT NOT NULL,
  `precio` DOUBLE(10,2) NOT NULL,
  `descripcion` VARCHAR(200) NOT NULL,
  `porcentajeIva` DOUBLE(10,2) NOT NULL,
  `idcategoria` INT NOT NULL,
  `estado` INT NOT NULL,
  PRIMARY KEY (`idproducto`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `dbsistemsale`.`tbusuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbsistemsale`.`tbusuarios` (
  `idusuarios` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(15) NOT NULL,
  `apellido` VARCHAR(30) NOT NULL,
  `usuario` VARCHAR(15) NOT NULL,
  `clave` VARCHAR(15) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `estado` INT NOT NULL,
  PRIMARY KEY (`idusuarios`))
ENGINE = InnoDB
AUTO_INCREMENT = 0
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
