# Objetivo

Utilizar recursos do Redis Cluster e Sentinel 

# Redis Cluster

Parte I. Criar um cluster mínimo manualmente

1. Crie o diretório /opt/redis/cluster-manual
2. Neste diretório, crie os sub-diretórios 7000, 7001, 7002, 7003, 7004, 7005
3. Copie o executável /opt/redis/bin/redis-server para cada um dos subdiretórios acima
4. Em cada subdiretório, crie um arquivo redis.conf com o seguinte conteúdo:
```
port 7000
cluster-enabled yes
cluster-config-file nodes.conf
cluster-node-timeout 5000
appendonly yes
```
- altere o parâmetro "port" conforme o nome de cada subdiretório
5. Em janelas separadas e sem enviar o processo para background, inicie as 6 instâncias de Redis com cada uma utilizando o seu próprio arquivo redis.conf
6. Utilize o utilitário redis-trib.rb para criar um novo cluster. Verifique as opções do comando.
- se encontrar algum erro de "gem" não encontrado, instale o gem redis: `gem install redis`

Parte II. Utilizando o cluster
1. Familiarize-se com a saída do comando CLUSTER INFO
2. Liste os nós do cluster com o comando CLUSTER NODES
3. Pare e destrua o cluster criado

Parte III. Criando um cluster mínimo utilizando o utilitário create-cluster
1. Verifique as opções no utilitário /opt/redis/utils/create-cluster/create-cluster
2. Ajuste para que sejam criados 4 masters e 4 slaves
3. Verifique as opções aceitas pelo utilitário
4. Crie e inicie o cluster
5. Conecte com um dos masters do cluster e experimente adicionar diferentes chaves. Observe seu redirecionamento para os respectivos slots.
6. Adicione pelo menos 100 chaves diferentes. Se necessário, crie um script para isto

Parte IV. Adicionar um novo nó
1. Utilizando o processo da Parte I, crie um novo nó
2. Adicione este nó ao cluster utilizando o utilitário redis-trib.rb

Parte V. Resharding
1. Utilizando o utilitário redis-trib.rb, mova 2000 slots de todos os nós do cluster para o nó recentemente adicionado
2. Para encontrar o node ID do nó recentemente adicionado, utilize `redis-cli -p <porta> cluster nodes | grep myself`

Parte VI. Failover
1. Em uma das janelas, encerre uma das instâncias master
2. Com o comando CLUSTER NODES, verifique que o slave deste master foi promovido para master

Parte VII. Adicionando uma nova réplica
1. Utilizando o processo da Parte I, crie outro nó 
2. Utilizando o utilitário redis-trib.rb, adicione um novo nó, porém como uma réplica (slave)
- não especifique quem será o master
3. Verifique qual foi o master que recebeu este novo nó como slave

# Redis Sentinel

1. Crie uma estrutura de replicação com masters e servers
2. Configure e inicie 3 instâncias do Sentinel
3. Explore os comandos SENTINEL
4. Retire um master e verifique o failover
