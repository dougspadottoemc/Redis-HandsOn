# Objetivo

Compreender como configurar as opções de persistência no Redis.

# Preparação

Verifique se o seu servidor Redis está desligado.

# Configurando Persistência de Snapshots

Lembre-se de que os snapshots do Redis são uma captura pontual do estado de todo o armazenamento de dados. A persistência do snapshot é ativada por padrão, mas vamos ver como podemos personalizar as configurações padrão.

## Instruções

1. Abra o arquivo `redis.conf` para edição e encontre o parâmetro` save`. Examine a configuração padrão atual e observe que, embora possa haver várias entradas de salvamento, somente o último terá efeito.
2. Mude a configuração padrão para salvar após 20 segundos se pelo menos 2 chaves tiverem mudado.
3. Inicie o servidor Redis usando o arquivo de configuração modificado. Abra uma sessão CLI e conecte-se ao servidor.
4. Insira algumas chaves e valores, você também pode excluir chaves. Ao realizar pelo menos 2 operações de gravação (p. Ex., Inserir / apagar), você deve observar que o Redis executando um snapshot em background que é salvo após 20 segundos.
5. Desligue seus servidores, emitindo o comando `shutdown`.

# Configurando Persistência Append-Only

Vamos configurar o Redis para usar os append-only files (AOF) para a persistência, que registrará cada comando de gravação à medida que eles são processados. Observe que também vamos deixar a persistência de snapshots ativada - usar ambos pode ser vantajoso em alguns casos.

## Instruções

1. Abra o arquivo `redis.conf` para edição e encontre o parâmetro` appendonly`. Altere o valor para 'yes'. Nós manteremos os valores padrão para os outros parâmetros AOF que controlam o nome do arquivo e a freqüência fsync.
2. Inicie o servidor Redis usando o arquivo de configuração modificado. Você deve ver um arquivo vazio `appendonly.aof` criado no diretório de inicialização.
3. Abra uma sessão CLI e conecte-se ao servidor. Insira um valor no armazenamento de dados.
4. Em outra sessão, examine o conteúdo do arquivo `appendonly.aof`. Você deve ver o comando que você inseriu no REdis Serialization Protocol (RESP).
5. Agora exclua o valor que você acabou de adicionar e reexamine o arquivo AOF. Observe que o comando de exclusão foi anexado ao final do arquivo.
6. Desligue seu servidor, emitindo o comando `shutdown`.
