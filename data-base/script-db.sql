SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE=TRADITIONAL,ALLOW_INVALID_DATES;

CREATE SCHEMA IF NOT EXISTS estudozolp DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE estudozolp ;

-- -----------------------------------------------------
-- Table estudozolp.TbUnidadePesquisa
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbUnidadePesquisa (
  idUnidadePesquisa INT NOT NULL AUTO_INCREMENT,
  dsUnidade VARCHAR(100) NOT NULL,
  siglaUnidade VARCHAR(20) NULL,
  telUnidade VARCHAR(13) NULL,
  endereco VARCHAR(100) NULL,
  cidade VARCHAR(100) NULL,
  uf CHAR(2) NULL,
  cep VARCHAR(10) NULL,
  investigador VARCHAR(100) NULL,
  coordenador VARCHAR(100) NULL,
  email VARCHAR(200) NULL,
  nuUnidade INT NULL,
  PRIMARY KEY (idUnidadePesquisa),
  UNIQUE INDEX idUnidadePesquisa_UNIQUE (idUnidadePesquisa ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table estudozolp.TbPaciente
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbPaciente (
  idPaciente INT NOT NULL AUTO_INCREMENT,
  idUnidadePesquisa INT NOT NULL,
  cpf VARCHAR(11) NOT NULL,
  nome VARCHAR(100) NULL,
  iniciaisNome VARCHAR(10) NOT NULL,
  nuRegistroProtocolo VARCHAR(45) NOT NULL,
  endereco VARCHAR(100) NULL,
  nuEndereco INT NULL,
  complEndereco VARCHAR(45) NULL,
  bairro VARCHAR(45) NULL,
  cidade VARCHAR(100) NULL,
  uf VARCHAR(2) NULL,
  cep VARCHAR(10) NULL,
  telResidencial VARCHAR(14) NULL,
  telCelular VARCHAR(14) NULL,
  telTrabalho VARCHAR(14) NULL,
  telRecado VARCHAR(14) NULL,
  pessoaRecado VARCHAR(45) NULL,
  profissao VARCHAR(45) NULL,
  dtNascimento DATE NULL,
  escolaridade INT NULL,
  raca INT NULL,
  sexo CHAR NULL,
  flAtivo CHAR NULL,
  dtInclusao TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (idPaciente),
  UNIQUE INDEX idPaciente_UNIQUE (idPaciente ASC),
  UNIQUE INDEX cpf_UNIQUE (cpf ASC),
  INDEX FKPacienteUnidadePesquisa (idUnidadePesquisa ASC),
  CONSTRAINT FKPacienteUnidadePesquisa
    FOREIGN KEY (idUnidadePesquisa)
    REFERENCES estudozolp.TbUnidadePesquisa (idUnidadePesquisa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table estudozolp.TbDoencaEvento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbDoencaEvento (
  idDoencaEvento INT NOT NULL AUTO_INCREMENT,
  dsDoenca VARCHAR(100) NOT NULL,
  siglaDoenca VARCHAR(10) NULL,
  PRIMARY KEY (idDoencaEvento),
  UNIQUE INDEX idDoencaEvento_UNIQUE (idDoencaEvento ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table estudozolp.TbEventoAdverso
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbEventoAdverso (
  idEventoAdverso INT NOT NULL AUTO_INCREMENT,
  idDoenca INT NOT NULL,
  idPaciente INT NOT NULL,
  dtInclusao TIMESTAMP NOT NULL,
  dtInicio DATE NULL,
  dtFim DATE NULL,
  PER_E01 CHAR(1) NULL COMMENT 'O evento adverso foi considerado sério?',
  PER_E02 VARCHAR(300) NULL COMMENT 'Providências Tomadas: ',
  PER_E03 VARCHAR(300) NULL COMMENT 'Evolução: ',
  PER_E04 CHAR(1) NULL COMMENT 'O evento adverso está relacionado aos tratamentos do estudo?',
  observacao VARCHAR(100) NULL,
  stAprovacao CHAR(1) NULL DEFAULT P,
  assinatura VARCHAR(20) NULL,
  dtAssinatura DATETIME NULL,
  nuVisita INT NULL,
  PRIMARY KEY (idEventoAdverso),
  UNIQUE INDEX idEventoAdverso_UNIQUE (idEventoAdverso ASC),
  INDEX FkEventoDoenca (idDoenca ASC),
  INDEX FkEventoPaciente (idPaciente ASC),
  CONSTRAINT FkEventoDoenca
    FOREIGN KEY (idDoenca)
    REFERENCES estudozolp.TbDoencaEvento (idDoencaEvento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FkEventoPaciente
    FOREIGN KEY (idPaciente)
    REFERENCES estudozolp.TbPaciente (idPaciente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table estudozolp.TbSaidaEstudo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbSaidaEstudo (
  idSaidaEstudo INT NOT NULL AUTO_INCREMENT,
  idPaciente INT NOT NULL,
  dtInclusao DATE NOT NULL,
  nuVisita INT(11) NULL,
  dtSaida DATE NOT NULL,
  dtOcorrencia DATE NULL,
  motivo INT NULL,
  flEvolucaoObito CHAR(1) NULL,
  stAprovacao CHAR(1) NULL,
  assinatura VARCHAR(20) NULL,
  dtAssinatura DATETIME NULL,
  observacao VARCHAR(200) NULL,
  PRIMARY KEY (idSaidaEstudo),
  UNIQUE INDEX idSaidaEstudo_UNIQUE (idSaidaEstudo ASC),
  INDEX FKSaidaEstudoPaciente (idPaciente ASC),
  CONSTRAINT FKSaidaEstudoPaciente
    FOREIGN KEY (idPaciente)
    REFERENCES estudozolp.TbPaciente (idPaciente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table estudozolp.TbPerfilAcesso
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbPerfilAcesso (
  idPerfilAcesso INT NOT NULL AUTO_INCREMENT,
  dsPerfil VARCHAR(45) NOT NULL,
  PRIMARY KEY (idPerfilAcesso),
  UNIQUE INDEX idPerfilAcesso_UNIQUE (idPerfilAcesso ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table estudozolp.TbUsuarioSistema
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbUsuarioSistema (
  idUsuarioSistema INT NOT NULL AUTO_INCREMENT,
  idUnidadePesquisa INT NULL,
  idPerfil INT NOT NULL,
  username VARCHAR(20) NOT NULL,
  nome VARCHAR(45) NOT NULL,
  senha VARCHAR(45) NOT NULL,
  email VARCHAR(100) NULL,
  flSenhaTemporaria CHAR(1) NOT NULL,
  flAtivo CHAR(1) NOT NULL,
  fone VARCHAR(14) NULL,
  dtInclusao DATE NULL DEFAULT CURRENT_TIMESTAMP,
  admin VARCHAR(45) NULL,
  PRIMARY KEY (idUsuarioSistema),
  UNIQUE INDEX idUsuarioSistema_UNIQUE (idUsuarioSistema ASC),
  INDEX FKUsuarioSistemaUnidadePesquisa (idUnidadePesquisa ASC),
  UNIQUE INDEX username_UNIQUE (username ASC),
  INDEX FKusuarioSistemaPerfilAcesso (idPerfil ASC),
  CONSTRAINT FKUsuarioSistemaUnidadePesquisa
    FOREIGN KEY (idUnidadePesquisa)
    REFERENCES estudozolp.TbUnidadePesquisa (idUnidadePesquisa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FKusuarioSistemaPerfilAcesso
    FOREIGN KEY (idPerfil)
    REFERENCES estudozolp.TbPerfilAcesso (idPerfilAcesso)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table estudozolp.TbAuditoriaEstudo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbAuditoriaEstudo (
  idAuditoriaEstudo INT NOT NULL AUTO_INCREMENT,
  username VARCHAR(20) NOT NULL,
  dtModificacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  tpModificacao CHAR(1) NOT NULL COMMENT 'U=Alteração | I=Inclusão | A=Aprovação | E=Exclusão',
  dsModificacao VARCHAR(200) NULL,
  tpEntidade CHAR(1) NOT NULL COMMENT 'V=Visita | E=Evento Adverso | S=Saída do Estudo',
  idPaciente INT NOT NULL,
  PRIMARY KEY (idAuditoriaEstudo),
  UNIQUE INDEX idAuditoriaVisita_UNIQUE (idAuditoriaEstudo ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table estudozolp.TbGrupoMedicamento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbGrupoMedicamento (
  idGrupoMedicamento INT NOT NULL AUTO_INCREMENT,
  dsGrupoMedicamento VARCHAR(100) NOT NULL,
  PRIMARY KEY (idGrupoMedicamento),
  UNIQUE INDEX idGrupoMedicamento_UNIQUE (idGrupoMedicamento ASC))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table estudozolp.TbMedicamento
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbMedicamento (
  idMedicamento INT NOT NULL AUTO_INCREMENT,
  dsMedicamento VARCHAR(45) NOT NULL,
  idGrupoMedicamento INT NOT NULL,
  PRIMARY KEY (idMedicamento),
  UNIQUE INDEX idMedicamento_UNIQUE (idMedicamento ASC),
  INDEX FKGrupoMedicamento (idGrupoMedicamento ASC),
  CONSTRAINT FKGrupoMedicamento
    FOREIGN KEY (idGrupoMedicamento)
    REFERENCES estudozolp.TbGrupoMedicamento (idGrupoMedicamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

