CREATE TABLE IF NOT EXISTS "caminhonete"
(
    "id"                BIGINT           NOT NULL,
    "ano"               INTEGER          NULL DEFAULT NULL,
    "chassi"            VARCHAR(255)     NULL DEFAULT NULL,
    "cor"               VARCHAR(255)     NULL DEFAULT NULL,
    "marca"             VARCHAR(255)     NULL DEFAULT NULL,
    "modelo"            VARCHAR(255)     NULL DEFAULT NULL,
    "placa"             VARCHAR(255)     NULL DEFAULT NULL,
    "valor_fipe"        DOUBLE PRECISION NULL DEFAULT NULL,
    "carroceria_dupla"  BOOLEAN          NOT NULL,
    "cavalos_potencia"  DOUBLE PRECISION NULL DEFAULT NULL,
    "quatro_por_quatro" BOOLEAN          NOT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "carro"
(
    "id"                BIGINT           NOT NULL,
    "ano"               INTEGER          NULL DEFAULT NULL,
    "chassi"            VARCHAR(255)     NULL DEFAULT NULL,
    "cor"               VARCHAR(255)     NULL DEFAULT NULL,
    "marca"             VARCHAR(255)     NULL DEFAULT NULL,
    "modelo"            VARCHAR(255)     NULL DEFAULT NULL,
    "placa"             VARCHAR(255)     NULL DEFAULT NULL,
    "valor_fipe"        DOUBLE PRECISION NULL DEFAULT NULL,
    "cavalos_potencia"  DOUBLE PRECISION NOT NULL,
    "quantidade_portas" INTEGER          NOT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "cliente"
(
    "id"              BIGINT       NOT NULL,
    "cpf"             VARCHAR(255) NULL DEFAULT NULL,
    "data_nascimento" DATE         NULL DEFAULT NULL,
    "endereco"        VARCHAR(255) NULL DEFAULT NULL,
    "genero"          INTEGER      NULL DEFAULT NULL,
    "nome"            VARCHAR(255) NULL DEFAULT NULL,
    "caminhonetes"    VARCHAR(255) NULL DEFAULT NULL,
    "carros"          VARCHAR(255) NULL DEFAULT NULL,
    "motos"           VARCHAR(255) NULL DEFAULT NULL,
    "seguros"         VARCHAR(255) NULL DEFAULT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "contrato"
(
    "id"            BIGINT       NOT NULL,
    "clienteid"     BIGINT       NOT NULL,
    "data_validade" DATE         NULL DEFAULT NULL,
    "descricao"     VARCHAR(255) NOT NULL,
    "valor"         REAL         NOT NULL,
    "vendedorid"    BIGINT       NOT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "gerente"
(
    "id"              BIGINT       NOT NULL,
    "cpf"             VARCHAR(255) NULL DEFAULT NULL,
    "data_nascimento" DATE         NULL DEFAULT NULL,
    "endereco"        VARCHAR(255) NULL DEFAULT NULL,
    "genero"          INTEGER      NULL DEFAULT NULL,
    "nome"            VARCHAR(255) NULL DEFAULT NULL,
    "login"           VARCHAR(255) NOT NULL,
    "seguros"         VARCHAR(255) NULL DEFAULT NULL,
    "senha"           VARCHAR(255) NOT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "moto"
(
    "id"         BIGINT           NOT NULL,
    "ano"        INTEGER          NULL DEFAULT NULL,
    "chassi"     VARCHAR(255)     NULL DEFAULT NULL,
    "cor"        VARCHAR(255)     NULL DEFAULT NULL,
    "marca"      VARCHAR(255)     NULL DEFAULT NULL,
    "modelo"     VARCHAR(255)     NULL DEFAULT NULL,
    "placa"      VARCHAR(255)     NULL DEFAULT NULL,
    "valor_fipe" DOUBLE PRECISION NULL DEFAULT NULL,
    "categoria"  VARCHAR(255)     NOT NULL,
    "cilindrada" DOUBLE PRECISION NOT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "seguro"
(
    "id"          BIGINT       NOT NULL,
    "apolice"     VARCHAR(255) NULL DEFAULT NULL,
    "automovel"   VARCHAR(255) NULL DEFAULT NULL,
    "cliente"     VARCHAR(255) NULL DEFAULT NULL,
    "contrato"    VARCHAR(255) NULL DEFAULT NULL,
    "data_fim"    TIMESTAMP    NULL DEFAULT NULL,
    "data_inicio" TIMESTAMP    NULL DEFAULT NULL,
    "sinitro"     VARCHAR(255) NULL DEFAULT NULL,
    "automovelid" BIGINT       NULL DEFAULT NULL,
    "clienteid"   BIGINT       NULL DEFAULT NULL,
    "contratoid"  BIGINT       NULL DEFAULT NULL,
    "gerenteid"   BIGINT       NULL DEFAULT NULL,
    "sinitroid"   BIGINT       NULL DEFAULT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "servico"
(
    "id"                    BIGINT           NOT NULL,
    "data_servico_prestado" DATE             NULL DEFAULT NULL,
    "descricao"             VARCHAR(255)     NOT NULL,
    "seguro"                VARCHAR(255)     NULL DEFAULT NULL,
    "valor"                 DOUBLE PRECISION NOT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "sinistro"
(
    "id"            BIGINT       NOT NULL,
    "descricao"     VARCHAR(255) NOT NULL,
    "perda_parcial" BOOLEAN      NULL DEFAULT NULL,
    "perda_total"   BOOLEAN      NULL DEFAULT NULL,
    "cliente_id"    BIGINT       NULL DEFAULT NULL,
    "contrato_id"   BIGINT       NULL DEFAULT NULL,
    "seguro_id"     BIGINT       NULL DEFAULT NULL,
    PRIMARY KEY ("id"),
    CONSTRAINT "fk5g9e8pihaiky7pg454d0207vr" FOREIGN KEY ("contrato_id") REFERENCES "contrato" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT "fkgh47fbbd0b9p9nax4c4atcem9" FOREIGN KEY ("seguro_id") REFERENCES "seguro" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT "fkowna2a0hocwtcn1ogmqiynijf" FOREIGN KEY ("cliente_id") REFERENCES "cliente" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION
)
;
CREATE TABLE IF NOT EXISTS "terceirizado"
(
    "id"           BIGINT       NOT NULL,
    "cnpj"         VARCHAR(255) NOT NULL,
    "razao_social" VARCHAR(255) NOT NULL,
    "servico"      VARCHAR(255) NULL DEFAULT NULL,
    "telefone"     VARCHAR(255) NOT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "vendedor"
(
    "id"              BIGINT           NOT NULL,
    "cpf"             VARCHAR(255)     NULL DEFAULT NULL,
    "data_nascimento" DATE             NULL DEFAULT NULL,
    "endereco"        VARCHAR(255)     NULL DEFAULT NULL,
    "genero"          INTEGER          NULL DEFAULT NULL,
    "nome"            VARCHAR(255)     NULL DEFAULT NULL,
    "login"           VARCHAR(255)     NOT NULL,
    "salario"         DOUBLE PRECISION NOT NULL,
    "senha"           VARCHAR(255)     NOT NULL,
    PRIMARY KEY ("id")
)
;