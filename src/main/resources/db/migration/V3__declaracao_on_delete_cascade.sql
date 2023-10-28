ALTER TABLE ferragem_kit
DROP CONSTRAINT fk_ferragem_kit_n2;
ALTER TABLE ferragem_kit
ADD CONSTRAINT fk_ferragem_kit_n2 FOREIGN KEY (id_kit) REFERENCES kit (id) ON DELETE CASCADE;
