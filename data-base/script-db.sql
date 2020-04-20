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
  escolaridade INT NULL, --(1 - Analfabeto / 2 - ler e Escrever / 3 - 1 grau completo / 4 - 1 grau incompleto / 5 - 2 grau completo / 6 - 2 grau incompleto / 7 - supoerior ou mais)
  raca INT NULL, -- (1 - Branco / 2 - Negro / 3 - Mulato / 4 - Oriental)
  sexo CHAR NULL, --(M - Masculino / F - Feminino)
  flAtivo CHAR NULL, --(S - Sim / N - Nao)
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



-- -----------------------------------------------------
-- Table estudozolp.TbQuestMedicamentoUso
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbQuestMedicamentoUso (
  idVisitaMedicamentoUso INT NOT NULL AUTO_INCREMENT,
  idVisita INT NOT NULL,
  idMedicamento INT NULL,
  dose VARCHAR(45) NULL,
  posologia VARCHAR(45) NULL,
  observacao VARCHAR(200) NULL,
  PRIMARY KEY (idVisitaMedicamentoUso),
  UNIQUE INDEX idVisitaMedicamentoUso_UNIQUE (idVisitaMedicamentoUso ASC),
  INDEX FKMedicamentoUsoVisita (idVisita ASC),
  INDEX FKMedicamentoUsoMedicamento (idMedicamento ASC),
  CONSTRAINT FKMedicamentoUsoVisita
    FOREIGN KEY (idVisita)
    REFERENCES estudomorpheos.TbVisita (idVisita)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT FKMedicamentoUsoMedicamento
    FOREIGN KEY (idMedicamento)
    REFERENCES estudomorpheos.TbMedicamento (idMedicamento)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table estudozolp.TbQuestPolissonografia
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbQuestPolissonografia (
  idPolissonografia INT NOT NULL AUTO_INCREMENT,
  idVisita INT NOT NULL,
  qtdEventos INT NULL,
  latencia VARCHAR(10) NULL,
  tst VARCHAR(10) NULL,
  pcs1 VARCHAR(10) NULL,
  pcs2 VARCHAR(10) NULL,
  pcs3 VARCHAR(10) NULL,
  pcRem VARCHAR(10) NULL,
  arquitetura VARCHAR(10) NULL,
  iah VARCHAR(10) NULL,
  satBasal VARCHAR(10) NULL,
  satMedia VARCHAR(10) NULL,
  satMinima VARCHAR(10) NULL,
  tsMenor90 VARCHAR(10) NULL,
  arousals VARCHAR(10) NULL,
  resultado INT NULL--,
  --pressaoCPAP VARCHAR(10) NULL,
  --flAplicaDilatador CHAR(1) NULL,
  --tmMascaraN CHAR(1) NULL,
  --tmMascaraNO CHAR(1) NULL,
  PRIMARY KEY (idPolissonografia),
  UNIQUE INDEX idPolissonografia_UNIQUE (idPolissonografia ASC),
  UNIQUE INDEX idVisita_UNIQUE (idVisita ASC),
  INDEX FKPolissonografiaVisita (idVisita ASC),
  CONSTRAINT FKPolissonografiaVisita
    FOREIGN KEY (idVisita)
    REFERENCES estudomorpheos.TbVisita (idVisita)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table estudozolp.TbQuestHabitosUltimoMes
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbQuestHabitosUltimoMes (
  idQuestHabitos INT NOT NULL AUTO_INCREMENT,
  idVisita INT NOT NULL,
  horaDormir TIME NULL,
  tempoParaAdormecer INT NULL,
  horaAcordar TIME NULL,
  horasSono INT NULL,
  problemasSono INT NULL, -- (1 - Não conseguia dormir em 30 minutos / 2 - Despertou no meio da noite ou de madrugada / 3 - Teve que levantar à noite para ir ao banheiro / 4 - Não conseguia respirar de forma satisfatória / 5 - Tossia ou roncava alto / 6 - Sentia muito frio / 7 - Sentia muito calor / 8 - Tinha sonhos ruins / 9 - Tinha dor / 10 - Outra razão (por favor, descreva em outro problema))
  tipoProblemaSono INT NULL, -- (1 - Nunca no ultimo mes / 2 - Menos de uma vez por semana / 3 - Uma ou Dusas Vezes por semana / 4 - Tres ou mais vezes por semana)
  outroProblemaSono VARCHAR(100) NULL,
  qualidadeSono INT NULL, -- (1 - Muito boa / 2 - Boa / 3 - Ruim / 4 - Muito ruim)
  freqMedicamentoSono INT NULL, -- ( 1 - Nunca no último mês / 2 - Menos de uma vez por semana / 3 - Uma ou duas vezes por semana / 4 - Três ou mais vezes por semana )
  freqDificManterAcordado INT NULL, -- ( 1 - Nunca no último mês / 2 - Menos de uma vez por semana / 3 - Uma ou duas vezes por semana / 4 - Três ou mais vezes por semana )
  difManterEstusiasmo INT NULL, -- (1 - Nenhum pouco problemático / 2 - Apenas ligeiramente problemático / 3 - Um pouco problemático / 4 - Muito problemático )
  divideQuartoCama INT NULL, -- (1 - Não tem parceiro de cama ou colega de quarto / 2 - Parceiro ou colega em outro quarto / 3 - Parceiro no mesmo quarto, mas não na mesma cama / 4 - Parceiro na mesma cama)
  reporProblemasSono INT NULL, -- (1 - Ronco Alto / 2 - Longas Pausas Respiracao / 3 - Chutar ou Sacudir Pernas / 4 - Desorientacao ou confusao / 5 - Outras inquietacoes (descreva em outro problema))
  tipoReportProblemaSono INT NULL, -- (1 - Nunca no ultimo mes / 2 - Menos de uma vez por semana / 3 - Uma ou Dusas Vezes por semana / 4 - Tres ou mais vezes por semana)
  outroReportProblemaSono VARCHAR (100) NULL
  PRIMARY KEY (idQuestHabitos),
  UNIQUE INDEX idQuestHabitos_UNIQUE (idQuestHabitos ASC),
  UNIQUE INDEX idVisita_UNIQUE (idVisita ASC),
  INDEX FKPolissonografiaVisita (idVisita ASC),
  CONSTRAINT FKQuestHabitosUltimoMesVisita
    FOREIGN KEY (idVisita)
    REFERENCES estudomorpheos.TbVisita (idVisita)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table estudozolp.TbGravidadeInsonia
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS estudozolp.TbGravidadeInsonia (
  idGravidadeInsonia INT NOT NULL AUTO_INCREMENT,
  idPaciente INT NOT NULL,
  -- ( 1 - Dificuladade Pegar Sono / 2 - Dificuldade Manter Sono / 3 - Despertar Muito Cedo )
  gravidadeInsonia INT NULL, 
  -- ( 1 - Nenhuma / 2 - Leve / 3 - Moderada / 4 - Grave / 5 - Muito Grave )
  tipoGravidadeInsonia INT NULL,
  -- ( 1 - Muito Satisfeito / 2 - Satisfeito / 3 - Indiferente / 4 - Insatisfeito / 5 - Muito Insatisfeito  )
  satisfacaoPadraoSono INT NULL, 
  -- ( 1 - Nao Interfere / 2 - Interfere um Pouco / 3 - Interfere de algum modo / 4 - Interfere Muito / 5 - Interfere Extremamente)
  interferenciaAtividadeDiaria INT NULL, 
  -- ( 1 - Nao Percebem / 2 - Percebem um Pouco / 3 - Percebem de algum modo / 4 - Percebem Muito / 5 - Percebem Extremamente )
  percepcaoExterna INT NULL, 
  -- ( 1 - Nao estou preocupado / 2 - Um pouco preocupado / 3 - De algum modo preocupado / 4 - Muito preocupado / 5 - Extremamente preocupado)
  nivelPreocupacao INT NULL, 
  PRIMARY KEY (idGravidadeInsonia),
  UNIQUE INDEX idGravidadeInsonia_UNIQUE (idGravidadeInsonia ASC),
  INDEX FKGravidadeInsoniaPaciente (idPaciente ASC),
  CONSTRAINT FKGravidadeInsoniaPaciente
    FOREIGN KEY (idPaciente)
    REFERENCES estudozolp.TbPaciente (idPaciente)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

