CREATE TABLE medico (
                        id INT AUTO_INCREMENT PRIMARY KEY,
                        nome VARCHAR(255) NOT NULL,
                        dataNascimento DATE NOT NULL,
                        ativo BOOLEAN NOT NULL
);

CREATE TABLE especialidade (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           nome VARCHAR(255) NOT NULL,
                           descricao VARCHAR(255),
                           ativo BOOLEAN NOT NULL
);