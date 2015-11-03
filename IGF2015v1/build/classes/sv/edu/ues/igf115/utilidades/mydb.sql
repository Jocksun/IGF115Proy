-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 03-11-2015 a las 05:12:59
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
-- Estructura de tabla para la tabla `as_atributo`
--

CREATE TABLE IF NOT EXISTS `as_atributo` (
  `c_clase` int(11) NOT NULL,
  `c_atributo` int(11) NOT NULL,
  `c_metodo` int(11) DEFAULT NULL,
  `d_atributo` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `d_tipo_dato_atributo` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `c_usuario` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  `c_tipo_atributo` varchar(1) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`c_clase`),
  KEY `fk_clase_atributo` (`c_clase`),
  KEY `fk_tipo_atributo` (`c_tipo_atributo`),
  KEY `fk_metodo_atributo` (`c_clase`,`c_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `as_atributo`
--

INSERT INTO `as_atributo` (`c_clase`, `c_atributo`, `c_metodo`, `d_atributo`, `d_tipo_dato_atributo`, `c_usuario`, `f_ingreso`, `c_tipo_atributo`) VALUES
(1, 1, 2, 'de2', 'desas2', 'joao', '2015-11-02', '2'),
(2, 2, 2, 'descipcion de prueba', 'dato2', 'joaito', '2015-11-02', '8');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_clase`
--

CREATE TABLE IF NOT EXISTS `as_clase` (
  `c_clase` int(11) NOT NULL,
  `d_clase` varchar(50) COLLATE utf8_bin NOT NULL,
  `c_tipo_clase` varchar(5) COLLATE utf8_bin NOT NULL,
  `c_usuario` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date NOT NULL,
  `c_aplicativo` varchar(5) COLLATE utf8_bin NOT NULL,
  `c_clase_padre` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_clase`),
  KEY `fk_tipo_clase` (`c_tipo_clase`),
  KEY `fk_aplicativo` (`c_aplicativo`),
  KEY `fk_clase_padre` (`c_clase_padre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `as_clase`
--

INSERT INTO `as_clase` (`c_clase`, `d_clase`, `c_tipo_clase`, `c_usuario`, `f_ingreso`, `c_aplicativo`, `c_clase_padre`) VALUES
(1, 'dclass', '1', '2', '2015-02-02', '1', 1),
(2, 'dclass2', '2', '2', '2015-01-01', '2', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_clase_interface`
--

CREATE TABLE IF NOT EXISTS `as_clase_interface` (
  `c_clase_interface` int(11) NOT NULL,
  `c_clase` int(11) NOT NULL,
  `c_interface` int(11) NOT NULL,
  PRIMARY KEY (`c_clase_interface`),
  KEY `fk_clase` (`c_clase`),
  KEY `fk_interface` (`c_interface`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_interface`
--

CREATE TABLE IF NOT EXISTS `as_interface` (
  `c_interface` int(11) NOT NULL,
  `d_interface` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `c_usuario` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_interface`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_interface_implementa`
--

CREATE TABLE IF NOT EXISTS `as_interface_implementa` (
  `c_interface_implementa` int(11) NOT NULL,
  `c_interface_hijo` int(11) NOT NULL,
  `c_interface_padre` int(11) NOT NULL,
  PRIMARY KEY (`c_interface_implementa`),
  KEY `fk_interface_hija` (`c_interface_hijo`),
  KEY `fk_interface_padre` (`c_interface_padre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_metodo`
--

CREATE TABLE IF NOT EXISTS `as_metodo` (
  `c_clase` int(11) NOT NULL,
  `c_metodo` int(11) NOT NULL,
  `d_metodo` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `d_tipo_retorno` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `c_usuario` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  `b_activo` int(11) DEFAULT NULL,
  `n_parametros` int(11) DEFAULT NULL,
  `c_tipo_metodo` varchar(1) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`c_clase`,`c_metodo`),
  KEY `fk_tipo_metodo` (`c_tipo_metodo`),
  KEY `fk_clase_metodo` (`c_clase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `as_metodo`
--

INSERT INTO `as_metodo` (`c_clase`, `c_metodo`, `d_metodo`, `d_tipo_retorno`, `c_usuario`, `f_ingreso`, `b_activo`, `n_parametros`, `c_tipo_metodo`) VALUES
(1, 1, 'dmetodo1', 'dtiporetorno 1', '1', '2015-08-09', 0, 2, '1'),
(2, 2, 'dmetodo2', 'dtiporetorno 2', '2', '2015-04-02', 0, 3, '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_observacion`
--

CREATE TABLE IF NOT EXISTS `as_observacion` (
  `c_observacion` int(11) NOT NULL,
  `d_observacion` varchar(4000) COLLATE utf8_bin DEFAULT NULL,
  `c_usuario` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  `b_activo` int(11) DEFAULT NULL,
  `c_clase` int(11) NOT NULL,
  `c_atributo` int(11) DEFAULT NULL,
  `c_metodo` int(11) DEFAULT NULL,
  `c_parametro` int(11) DEFAULT NULL,
  PRIMARY KEY (`c_observacion`),
  KEY `fk_clase_observacion` (`c_clase`),
  KEY `fk_metodo_observacion` (`c_clase`,`c_metodo`),
  KEY `fk_atributo_observacion` (`c_clase`,`c_atributo`),
  KEY `fk_parametro_observacion` (`c_clase`,`c_metodo`,`c_parametro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `as_parametro`
--

CREATE TABLE IF NOT EXISTS `as_parametro` (
  `c_clase` int(11) NOT NULL DEFAULT '0',
  `c_metodo` int(11) NOT NULL DEFAULT '0',
  `c_parametro` int(11) NOT NULL DEFAULT '0',
  `d_parametro` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `d_tipo_parametro` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `c_usuario` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_clase`,`c_metodo`,`c_parametro`),
  KEY `fk_metodo_parametro` (`c_clase`,`c_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_aplicativo`
--

CREATE TABLE IF NOT EXISTS `tb_aplicativo` (
  `c_aplicativo` varchar(5) COLLATE utf8_bin NOT NULL,
  `d_aplicativo` varchar(100) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_aplicativo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tb_aplicativo`
--

INSERT INTO `tb_aplicativo` (`c_aplicativo`, `d_aplicativo`, `f_ingreso`) VALUES
('1', 'aplicativo 1', '2015-02-08'),
('2', 'aplicativo 2', '2015-04-03');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipo_atributo`
--

CREATE TABLE IF NOT EXISTS `tb_tipo_atributo` (
  `c_tipo_atributo` varchar(1) COLLATE utf8_bin NOT NULL,
  `d_tipo_atributo` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_tipo_atributo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tb_tipo_atributo`
--

INSERT INTO `tb_tipo_atributo` (`c_tipo_atributo`, `d_tipo_atributo`, `f_ingreso`) VALUES
('1', 'despcricion 1', '2015-11-02'),
('2', 'sfgdgdfgfdgdf', '2014-11-01'),
('8', 'te hubieras ido antes', '2015-11-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipo_clase`
--

CREATE TABLE IF NOT EXISTS `tb_tipo_clase` (
  `c_tipo_clase` varchar(5) COLLATE utf8_bin NOT NULL,
  `d_tipo_clase` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_tipo_clase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tb_tipo_clase`
--

INSERT INTO `tb_tipo_clase` (`c_tipo_clase`, `d_tipo_clase`, `f_ingreso`) VALUES
('1', 'clase 1', '2015-02-01'),
('2', 'clase 2', '2015-03-02'),
('3', 'clase 3', '2015-07-01');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_tipo_metodo`
--

CREATE TABLE IF NOT EXISTS `tb_tipo_metodo` (
  `c_tipo_metodo` varchar(1) COLLATE utf8_bin NOT NULL,
  `d_tipo_metodo` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `f_ingreso` date DEFAULT NULL,
  PRIMARY KEY (`c_tipo_metodo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `tb_tipo_metodo`
--

INSERT INTO `tb_tipo_metodo` (`c_tipo_metodo`, `d_tipo_metodo`, `f_ingreso`) VALUES
('1', 'metodo 1', '2015-02-03'),
('2', 'metodo 2', '2015-02-04'),
('4', 'Metodo 4', '2015-11-02');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) DEFAULT NULL,
  `lastname` varchar(45) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`userid`, `firstname`, `lastname`, `dob`, `email`) VALUES
(1, '2', '3', '0000-00-00', 'dfhfgh');

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
