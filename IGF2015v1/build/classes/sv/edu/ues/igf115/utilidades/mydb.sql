-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 24-10-2015 a las 06:11:48
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `mydb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_clase`
--

CREATE TABLE IF NOT EXISTS `as_clase` (
  `c_clase` int(11) NOT NULL AUTO_INCREMENT,
  `d_clase` varchar(50) NOT NULL,
  `c_tipo_clase` varchar(5) NOT NULL,
  `c_usuario` varchar(30) DEFAULT NULL,
  `f_ingreso` date NOT NULL,
  `c_aplicativo` varchar(5) NOT NULL,
  `c_clase_padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_clase`),
  KEY `fk_tipo_clase` (`c_tipo_clase`),
  KEY `fk_aplicativo` (`c_aplicativo`),
  KEY `fk_clase_padre` (`c_clase_padre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_clase_interface`
--

CREATE TABLE IF NOT EXISTS `as_clase_interface` (
  `c_clase_interface` int(11) NOT NULL AUTO_INCREMENT,
  `c_clase` int(11) NOT NULL,
  `c_interface` int(11) NOT NULL,
  PRIMARY KEY (`c_clase_interface`),
  KEY `fk_clase` (`c_clase`),
  KEY `fk_interface` (`c_interface`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_interface`
--

CREATE TABLE IF NOT EXISTS `as_interface` (
  `c_interface` int(11) NOT NULL AUTO_INCREMENT,
  `d_interface` varchar(50) DEFAULT NULL,
  `c_usuario` varchar(30) DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_interface`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_interface_implementa`
--

CREATE TABLE IF NOT EXISTS `as_interface_implementa` (
  `c_interface_implementa` int(11) NOT NULL AUTO_INCREMENT,
  `c_interface_hijo` int(11) NOT NULL,
  `c_interface_padre` int(11) NOT NULL,
  PRIMARY KEY (`c_interface_implementa`),
  KEY `fk_interface_hija` (`c_interface_hijo`),
  KEY `fk_interface_padre` (`c_interface_padre`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_metodo`
--

CREATE TABLE IF NOT EXISTS `as_metodo` (
  `c_clase` int(11) NOT NULL,
  `c_metodo` int(11) NOT NULL,
  `d_metodo` varchar(50) DEFAULT NULL,
  `d_tipo_retorno` varchar(50) DEFAULT NULL,
  `c_usuario` varchar(30) DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  `b_activo` int(11) DEFAULT NULL,
  `n_parametros` int(11) DEFAULT NULL,
  `c_tipo_metodo` varchar(1) NOT NULL,
  PRIMARY KEY (`c_clase`,`c_metodo`),
  KEY `fk_clase_metodo` (`c_clase`),
  KEY `fk_tipo_metodo` (`c_tipo_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_parametro`
--

CREATE TABLE IF NOT EXISTS `as_parametro` (
  `c_clase` int(11) NOT NULL DEFAULT '0',
  `c_metodo` int(11) NOT NULL DEFAULT '0',
  `c_parametro` int(11) NOT NULL DEFAULT '0',
  `d_parametro` varchar(50) DEFAULT NULL,
  `d_tipo_parametro` varchar(50) DEFAULT NULL,
  `c_usuario` varchar(30) DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_clase`,`c_metodo`,`c_parametro`),
  KEY `fk_metodo_parametro` (`c_clase`,`c_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_aplicativo`
--

CREATE TABLE IF NOT EXISTS `tb_aplicativo` (
  `c_aplicativo` varchar(5) NOT NULL,
  `d_aplicativo` varchar(100) DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_aplicativo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipo_atributo`
--

CREATE TABLE IF NOT EXISTS `tb_tipo_atributo` (
  `c_tipo_atributo` varchar(1) NOT NULL,
  `d_tipo_atributo` varchar(50) DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_tipo_atributo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tb_tipo_atributo`
--

INSERT INTO `tb_tipo_atributo` (`c_tipo_atributo`, `d_tipo_atributo`, `f_ingreso`) VALUES
('1', 'tipo atributo numero uno', '2015-05-05'),
('2', 'tipo atributo dos', '2014-05-05'),
('3', 'tipo atributo tres', '2014-05-05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipo_clase`
--

CREATE TABLE IF NOT EXISTS `tb_tipo_clase` (
  `c_tipo_clase` varchar(5) NOT NULL,
  `d_tipo_clase` varchar(50) DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_tipo_clase`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipo_metodo`
--

CREATE TABLE IF NOT EXISTS `tb_tipo_metodo` (
  `c_tipo_metodo` varchar(1) NOT NULL,
  `d_tipo_metodo` varchar(20) DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_tipo_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `as_clase`
--
ALTER TABLE `as_clase`
  ADD CONSTRAINT `fk_aplicativo` FOREIGN KEY (`c_aplicativo`) REFERENCES `tb_aplicativo` (`c_aplicativo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_clase_padre` FOREIGN KEY (`c_clase_padre`) REFERENCES `as_clase` (`c_clase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tipo_clase` FOREIGN KEY (`c_tipo_clase`) REFERENCES `tb_tipo_clase` (`c_tipo_clase`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `as_clase_interface`
--
ALTER TABLE `as_clase_interface`
  ADD CONSTRAINT `fk_clase` FOREIGN KEY (`c_clase`) REFERENCES `as_clase` (`c_clase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_interface` FOREIGN KEY (`c_interface`) REFERENCES `as_interface` (`c_interface`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `as_interface_implementa`
--
ALTER TABLE `as_interface_implementa`
  ADD CONSTRAINT `fk_interface_hija` FOREIGN KEY (`c_interface_hijo`) REFERENCES `as_interface` (`c_interface`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_interface_padre` FOREIGN KEY (`c_interface_padre`) REFERENCES `as_interface` (`c_interface`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `as_metodo`
--
ALTER TABLE `as_metodo`
  ADD CONSTRAINT `fk_clase_metodo` FOREIGN KEY (`c_clase`) REFERENCES `as_clase` (`c_clase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_tipo_metodo` FOREIGN KEY (`c_tipo_metodo`) REFERENCES `tb_tipo_metodo` (`c_tipo_metodo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `as_parametro`
--
ALTER TABLE `as_parametro`
  ADD CONSTRAINT `fk_metodo_parametro` FOREIGN KEY (`c_clase`, `c_metodo`) REFERENCES `as_metodo` (`c_clase`, `c_metodo`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
