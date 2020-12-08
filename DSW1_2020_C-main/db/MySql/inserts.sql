INSERT INTO `promocaoquartoshotel`.`estado` (`nome`, `sigla`) VALUES ('São Paulo', 'SP');
INSERT INTO `promocaoquartoshotel`.`estado` (`nome`, `sigla`) VALUES ('Rio de Janeiro', 'RJ');
INSERT INTO `promocaoquartoshotel`.`estado` (`nome`, `sigla`) VALUES ('Minas Gerais', 'MG');
INSERT INTO `promocaoquartoshotel`.`estado` (`nome`, `sigla`) VALUES ('Santa Catarina', 'SC');

INSERT INTO `promocaoquartoshotel`.`cidade` (`nome`, `estado_id`) VALUES ('São Paulo', '1');
INSERT INTO `promocaoquartoshotel`.`cidade` (`nome`, `estado_id`) VALUES ('São Carlos', '1');
INSERT INTO `promocaoquartoshotel`.`cidade` (`nome`, `estado_id`) VALUES ('Rio de Janeiro', '2');
INSERT INTO `promocaoquartoshotel`.`cidade` (`nome`, `estado_id`) VALUES ('Belo Horizonte', '3');
INSERT INTO `promocaoquartoshotel`.`cidade` (`nome`, `estado_id`) VALUES ('Florianópolis', '4');

INSERT INTO `promocaoquartoshotel`.`site` (`nome`, `url`, `email`) VALUES ('Booking', 'Booking.com', 'booking@email');
INSERT INTO `promocaoquartoshotel`.`site` (`nome`, `url`, `email`) VALUES ('Hurb', 'Hurb.com', 'hurb@email');
INSERT INTO `promocaoquartoshotel`.`site` (`nome`, `url`, `email`) VALUES ('Trivago', 'Trivago.com.br', 'trivago@email');

INSERT INTO `promocaoquartoshotel`.`hotel` (`nome`, `cep`, `logradouro`, `numero`, `bairro`, `email`, `cidade_id`) VALUES ('Bourbon Convention Ibirapuera', '04029-200', 'Av. Ibirapuera', '2927', 'Ibirapuera', 'ibirapuera@email', '1');
INSERT INTO `promocaoquartoshotel`.`hotel` (`nome`, `cep`, `logradouro`, `numero`, `bairro`, `email`, `cidade_id`) VALUES ('Ibis São Carlos', '13561-385', 'Rua Passeio Dos Ipês', '140', 'Parque Faber Castell I', 'ibis@email', '2');
INSERT INTO `promocaoquartoshotel`.`hotel` (`nome`, `cep`, `logradouro`, `numero`, `bairro`, `email`, `cidade_id`) VALUES ('Indaiá Hotel Residence', '13560-515', 'R. Jacinto Favoreto', '789', 'Jardim Lutfalla', 'indaia@email', '2');
INSERT INTO `promocaoquartoshotel`.`hotel` (`nome`, `cep`, `logradouro`, `numero`, `bairro`, `email`, `cidade_id`) VALUES ('Sleep Inn São Carlos', '13561-110', 'R. Cons João Alfredo', '455', 'Jardim Paraiso', 'sleep@email', '2');
INSERT INTO `promocaoquartoshotel`.`hotel` (`nome`, `cep`, `logradouro`, `numero`, `bairro`, `email`, `cidade_id`) VALUES ('Royal Rio Palace Hotel', '22020-020', 'R. Duvivier', '82', 'Copacabana', 'royal@email', '3');
INSERT INTO `promocaoquartoshotel`.`hotel` (`nome`, `cep`, `logradouro`, `numero`, `bairro`, `email`, `cidade_id`) VALUES ('Hotel Atlantico Tower', '20091-007', 'Rua Visconde de Inhauma', '95', 'Centro', 'atlantico@email', '3');

INSERT INTO `promocaoquartoshotel`.`promocao` (`quarto`, `hotel_id`, `site_id`, `dataInicial`, `dataFinal`, `valor`) VALUES ('Suite A-98', '1', '1', '2020-12-25', '2020-12-27', '300');

INSERT INTO `promocaoquartoshotel`.`usuario` (`email`, `senha`, `papel`) VALUES ('booking@email', '123', 'SITE');
INSERT INTO `promocaoquartoshotel`.`usuario` (`email`, `senha`, `papel`) VALUES ('ibirapuera@email', '123', 'HOTEL');
INSERT INTO `promocaoquartoshotel`.`usuario` (`email`, `senha`, `papel`) VALUES ('admin@admin', 'admin', 'ADMIN');
