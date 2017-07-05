# Objetivo

Executar a atualização de versão do Redis sem perder dados

1. Tenha uma instância de Redis executando com algumas chaves. De preferência uma nova instância sem slaves.
2. Faça o download da versão 4.0 do Redis e envie o pacote para seu servidor
3. Instale e inicie o Redis na nova versão como slave do master do passo 1
4. Aguarde a sincronia das instâncias
5. Faça com que o Redis na versão 4.0 seja master (slaveof no one)
6. Desligue o master inicial
7. Você agora tem o seu master com a versão 4.0.
8. Atualize o master inicial para a versão 4.0 e faça com que ele sincronize com o novo master

# Com Sentinel (extra)

1. Refaça a mesma operação porém utilizando o Sentinel