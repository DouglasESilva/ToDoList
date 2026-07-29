-- Forma Correta
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO ) VALUES ('João', 'joao123', 'senha123', 'joao@email.com', 'ATIVO');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES ('Maria Silva', 'maria.silva', 'senha123', 'maria.silva@email.com', 'PENDENTE');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES ('Carlos Oliveira', 'carlos.o', 'senha123', 'carlos.oliveira@email.com', 'INATIVO');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES ('Ana Souza', 'ana.souza', 'senha123', 'ana.souza@email.com', 'ATIVO');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES ('Lucas Santos', 'lucas.santos', 'senha123', 'lucas.santos@email.com', 'PENDENTE');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES ('Fernanda Lima', 'fernanda.l', 'senha123', 'fernanda.lima@email.com', 'INATIVO');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES ('Rafael Costa', 'rafael.costa', 'senha123', 'rafael.costa@email.com', 'ATIVO');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES ('Beatriz Rocha', 'beatriz.r', 'senha123', 'beatriz.rocha@email.com', 'PENDENTE');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES ('Gabriel Alves', 'gabriel.a', 'senha123', 'gabriel.alves@email.com', 'INATIVO');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL, SITUACAO) VALUES ('Camila Martins', 'camila.m', 'senha123', 'camila.martins@email.com', 'ATIVO');
INSERT INTO Usuario (NOME, LOGIN, SENHA, EMAIL,  SITUACAO) VALUES ('Thiago Ribeiro', 'thiago.r', 'senha123', 'thiago.ribeiro@email.com', 'PENDENTE');

INSERT INTO Perfil (DESCRICAO) VALUES ('Administrador');  
INSERT INTO Perfil (DESCRICAO) VALUES ('Gerente');
INSERT INTO Perfil (DESCRICAO) VALUES ('Operador');
INSERT INTO Perfil (DESCRICAO) VALUES ('Analista');
INSERT INTO Perfil (DESCRICAO) VALUES ('Desenvolvedor');
INSERT INTO Perfil (DESCRICAO) VALUES ('Suporte Técnico');
INSERT INTO Perfil (DESCRICAO) VALUES ('Financeiro');
INSERT INTO Perfil (DESCRICAO) VALUES ('Recursos Humanos');
INSERT INTO Perfil (DESCRICAO) VALUES ('Auditor');
INSERT INTO Perfil (DESCRICAO) VALUES ('Coordenador');
INSERT INTO Perfil (DESCRICAO) VALUES ('Visitante');

INSERT INTO Recurso (NOME, CHAVE) VALUES ('Tela Usuario', 'usuario');
INSERT INTO Recurso (NOME, CHAVE) VALUES ('Tela Perfil', 'perfil');
INSERT INTO Recurso (NOME, CHAVE) VALUES ('Tela Recurso', ' recurso');