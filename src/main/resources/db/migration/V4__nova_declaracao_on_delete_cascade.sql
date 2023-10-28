ALTER TABLE peca_orcamento
DROP CONSTRAINT fk_peca_orcamento_n1;
ALTER TABLE peca_orcamento
ADD CONSTRAINT fk_peca_orcamento_n1 FOREIGN KEY (id_orcamento) REFERENCES ORCAMENTO (id) ON DELETE CASCADE;