# Objetivo

Ganhar familiaridade com o suporte a Pub/Sub e transações no Redis

# Usando Pub/Sub com o Redis

1. No redis-cli, assine ao canal "notificacoes".
2. Abra outra janela, comece uma segunda sessão CLI do Redis e conecte-se ao seu servidor Redis.
3. Na segunda janela, publique algumas mensagens no canal de notificações. Observe a janela de inscrição, você deve ver as mensagens recebidas lá.
4. Abra uma terceira janela e inscreva-se no canal de notificações.
5. Volte para sua segunda janela e examine o número de assinantes no canal de notificações.
6. Na segunda janela, publique mais mensagens. Observe as outras janelas de assinantes, bem como as respostas do comando de publicação.
7. Remova todas as assinaturas do canal (você terá que emitir uma ctrl-c na CLI).
8. Publique pelo menos mais uma mensagem no canal de notificações. Observe o valor de retorno da publicação agora, em comparação com o anterior.
9. Reinicie uma das assinaturas e observe que as mensagens publicadas enquanto o assinante estava desativado foram perdidas.
10. Remova a assinatura do canal.

# Trabalhando com transações

1. Inicie uma transação.
2. Insira algumas strings no Redis.
3. Aborte a transação.
4. Inicie uma nova transação.
5. Insira algumas strings no Redis.
6. Em outra janela da CLI do Redis, tente obter os valores das strings que você acabou de inserir. Observe que nenhum resultado é retornado, porque a transação ainda não foi finalizada.
7. Finalize a transação.
8. Na outra janela da CLI do Redis, tente obter novamente os valores das strings que você acabou de inserir. Agora, os valores devem ser retornados uma vez que a transação foi finalizada.

# Comandos de Gerenciamento de Conexão e Servidor

Vamos dar uma olhada em alguns comandos básicos para gerenciar o servidor Redis.

1. Faça um ping no servidor.
2. Abra uma segunda janela da CLI e conecte-se ao servidor.
3. Na primeira janela, liste as conexões do cliente.
4. Defina o parâmetro de configuração "masterauth" para "umasenha".
5. Obter o parâmetro de configuração "masterauth" para verificar se foi configurado corretamente.
6. Execute o comando "info" para exibir as estatísticas atuais sobre o servidor.
7. Desligue o servidor graciosamente.