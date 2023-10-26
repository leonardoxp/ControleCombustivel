CREATE TABLE `posto` (
   `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `id_posto` INTEGER,
   `desc_posto` VARCHAR (50)  NOT NULL,
   `preco` DECIMAL(5,2)		 NOT NULL,
   `tipo_combustivel` VARCHAR (20) NOT NULL
);