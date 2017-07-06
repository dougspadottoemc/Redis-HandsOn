# Objetivo

Explorar o log gerado pelo Redis e a funcionalidade de enviar notificações sobre mudança no datastore

# Log

1. Configure uma instância do Redis para gravar um arquivo de log em /opt/redis/log/instancia_lab.log
2. Configure o nível de log para `debug`
3. Inicie o redis-cli, envie alguns comandos
4. Verifique o arquivo /opt/redis/log/instancia_lab.log
5. Retorne a configuração de log para `notice`

# Notificações

1. Configure uma instância do Redis para enviar notificações para quaisquer tipos de eventos (dica: `KEA`)
2. Em uma janela, subscreva a todos os canais com notificações de eventos e do espaço de chaves (dica: `"__key*__:*"`)
3. Em outra janela, envie diversos comandos no redis-cli e observe a janela com a subscrição dos canais enviando eventos
4. Modifique o envio de notificações para enviar somente notificações de chaves do tipo String que expiraram
5. Teste esta modificação
