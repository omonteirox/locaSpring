CREATE TABLE IF NOT EXISTS "automovel"
(
    "id"                serial           NOT NULL ,
    "ano"               INTEGER          NULL DEFAULT NULL,
    "carroceria_dupla"  BOOLEAN          NOT NULL,
    "categoria"         VARCHAR(255)     NULL DEFAULT NULL,
    "cavalos_potencia"  DOUBLE PRECISION NOT NULL,
    "chassi"            VARCHAR(255)     NULL DEFAULT NULL,
    "cilindrada"        DOUBLE PRECISION NULL DEFAULT NULL,
    "cor"               VARCHAR(255)     NULL DEFAULT NULL,
    "marca"             VARCHAR(255)     NULL DEFAULT NULL,
    "modelo"            VARCHAR(255)     NULL DEFAULT NULL,
    "placa"             VARCHAR(255)     NULL DEFAULT NULL,
    "quantidade_portas" INTEGER          NULL DEFAULT NULL,
    "quatro_por_quatro" BOOLEAN          NOT NULL,
    "tipo_automovel"    INTEGER          NULL DEFAULT NULL,
    "valor_fipe"        DOUBLE PRECISION NULL DEFAULT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "caminhonete"
(
    "id"                serial           NOT NULL,
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
    "id"                serial           NOT NULL,
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
    "id"              serial       NOT NULL,
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
    "id"            serial       NOT NULL,
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
    "id"              serial       NOT NULL,
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
    "id"         serial           NOT NULL,
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
    "id"          serial       NOT NULL,
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
    "id"                    serial           NOT NULL,
    "data_servico_prestado" DATE             NULL DEFAULT NULL,
    "descricao"             VARCHAR(255)     NOT NULL,
    "seguro"                VARCHAR(255)     NULL DEFAULT NULL,
    "valor"                 DOUBLE PRECISION NOT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "sinistro"
(
    "id"            serial       NOT NULL,
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
    "id"           serial       NOT NULL,
    "cnpj"         VARCHAR(255) NOT NULL,
    "razao_social" VARCHAR(255) NOT NULL,
    "servico"      VARCHAR(255) NULL DEFAULT NULL,
    "telefone"     VARCHAR(255) NOT NULL,
    PRIMARY KEY ("id")
)
;
CREATE TABLE IF NOT EXISTS "vendedor"
(
    "id"              serial           NOT NULL,
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
CREATE TABLE IF NOT EXISTS "cliente_automoveis" (
                                      "cliente_id" SERIAL NOT NULL,
                                      "automoveis_id" SERIAL NOT NULL,
                                      CONSTRAINT "fkapms6q4o4avhhg3fjj8p4r961" FOREIGN KEY ("automoveis_id") REFERENCES "automovel" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION,
                                      CONSTRAINT "fkfgfgf2c4j3w2vr23wvpajn6em" FOREIGN KEY ("cliente_id") REFERENCES "cliente" ("id") ON UPDATE NO ACTION ON DELETE NO ACTION
)
;