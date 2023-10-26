CREATE TABLE `veiculo` (
	`id` bigint NOT NULL  AUTO_INCREMENT PRIMARY KEY,
    `id_veiculo` INTEGER,
    `categoria` VARCHAR (50)  NOT NULL,
    `ano` DATE,
    `cor` VARCHAR (50)  NOT NULL,
    `desc_marca` VARCHAR (100)  NOT NULL,
    `descricao` VARCHAR (100)  NOT NULL,
    `potencia` FLOAT,
    `cons_cid` FLOAT,
    `cons_estrada` FLOAT,
    `combustivel` VARCHAR (50)  NOT NULL,
    `tipo_id` bigint NOT NULL,
     FOREIGN KEY (`tipo_id`) REFERENCES tipo (`id`)
);