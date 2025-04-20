ALTER TABLE consertos ADD ativo TINYINT;

--Atualizar do banco já inseridos anteriormente para ativos

UPDATE consertos SET ativo = 1;