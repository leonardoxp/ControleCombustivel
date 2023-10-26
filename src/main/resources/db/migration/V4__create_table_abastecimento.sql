CREATE TABLE `abastecimento` (
   `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,
   `id_abast` INTEGER,
   `data_abast` DATE,
   `combustivel` VARCHAR (50)  NOT NULL,
   `qtd_litros` FLOAT,
   `valor_abast` DECIMAL(7,3)  NOT NULL,
   `km_atual` FLOAT,
   `posto_id` bigint NOT NULL,
   `veiculo_id` bigint NOT NULL,
	FOREIGN KEY (`posto_id`)  REFERENCES `posto` (`id`),
	FOREIGN KEY (`veiculo_id`)     REFERENCES `veiculo` (`id`)
);