# Objetivo

Compreender como configurar as opções de replicação no Redis.

# Preparação

Verifique se o seu servidor Redis está desligado.

# Configurando a Replicação

Alguns casos de uso podem exigir uma razão de leitura / escrita muito elevada, ou seja, um grande número de clientes que lêem o servidor Redis com poucos clientes fazendo gravações. Vamos configurar um par de servidores Redis para demonstrar a replicação master-slave.

## Instruções

Crie os seguintes diretórios, fora da estrutura de diretório Redis padrão:

`Redis '
`Redis / config`
`Redis / data`
`Redis / data / server-6379`
`Redis / data / server-6380`
`Redis / log`

1. Faça 2 cópias do seu arquivo `redis.conf`,` master.conf` e `slave.conf`, e coloque-as no diretório` redis / config` que você acabou de criar.
2. Edite o arquivo `master.conf`, descomente o parâmetro` pidfile` e defina-o no diretório `redis / data / server-6379`.
3. Defina o parâmetro `logfile` como` redis / log / server-6379.log`
4. Defina o parâmetro `dir` para o diretório` redis / data / server-6379`.
5. Edite o arquivo `slave.conf`, descomente o parâmetro` pidfile` e defina-o no diretório `redis / data / server-6380`.
6. Altere o parâmetro `port` para que o servidor escute na porta 6380 (para evitar um conflito de porta).
7. Defina o parâmetro `logfile` como` redis / log / server-6380.log`
8. Defina o parâmetro `dir` para o diretório` redis / data / server-6380`.
9. Descomente e defina o parâmetro `slaveof` para o master, ou seja,` slaveof localhost 6379`
10. Inicie o master passando o caminho para o arquivo `master.conf` na linha de comando. (Se quiser, no Linux, você pode executar o servidor como um processo em segundo plano anexando um e comercial à linha de comando.
11. Verifique se o master começou com sucesso, visualizando o arquivo `redis / log / server-6379.log`.
12. Inicie o slave passando no caminho para o arquivo `slave.conf` na linha de comando. (Se quiser, no Linux, você pode executar o servidor como um processo em segundo plano anexando um e comercial à linha de comando.
13. Verifique se o slave foi iniciado com sucesso ao visualizar o arquivo `redis / log / server-6380.log`. Você deve ver algumas mensagens de sincronização, indicando conclusão bem-sucedida.
14. Conecte-se ao master usando a CLI Redis e coloque alguns dados no armazenamento de dados.
15. Abra uma segunda janela e conecte-se ao slave usando a CLI, especificando a porta de escuta escrava de 6380 usando a opção "-p". Recupere os dados que você acabou de adicionar.
16. Agora, na janela CLI do slave, tente adicionar mais dados. Que erro você obtém? Por padrão, os slaves são somente leitura.
17. Desligue seu servidor emitindo o comando `shutdown`.

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