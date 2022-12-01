
INSERT INTO tb_dados_bancarios (cd_dados_bancarios, banco, agencia, conta) 
VALUES (1, 'Caixa', '0001', '958487-8');

INSERT INTO tb_proprietario (cd_proprietario, nm_proprietario, cpf, fk_dados_bancarios) 
VALUES (1, 'Welisson', '000.000.000-00', 1);

INSERT INTO tb_tipo_imovel (cd_tp_imovel, tp_imovel) VALUES (1, 'Casa');

INSERT INTO tb_endereco (cd_endereco, uf, cidade, bairro, logradouro, complemento, cep)
VALUES (1, 'DF', 'Brasilia', 'Ceilandia', 'Rua 10', 'Casa 10', '00000-000');

INSERT INTO tb_imovel (cd_imovel, qtd_quartos, qtd_banheiros, fk_endereco, fk_tp_imovel, fk_proprietario)
VALUES (1, 2, 1, 1, 1, 1);

INSERT INTO tb_inquilino (cd_inquilino, nm_inquilino, cpf)
VALUES (1, 'Hudson', '000.000.000-01');

INSERT INTO tb_contrato_aluguel (cd_contrato, dt_contrato, dt_inicio, dt_fim, vl_Aluguel, fk_imovel, fk_inquilino) 
VALUES (1, PARSEDATETIME('28-11-2022', 'dd-MM-yyyy'), PARSEDATETIME('28-11-2022', 'dd-MM-yyyy'), PARSEDATETIME('28-11-2024', 'dd-MM-yyyy'), 1245.00, 1, 1);

INSERT INTO tb_pagamento (cd_pagamento, ds_mes_ano, vl_pago, dt_pagamento)
VALUES (1, '11/2022', 1245.00, PARSEDATETIME('28-11-2022', 'dd-MM-yyyy'));