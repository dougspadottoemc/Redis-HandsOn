# Objetivo

Utilizar recursos do Redis Cluster e Sentinel 

# Redis Cluster

1. Crie um cluster mínimo utilizando o utilitário create-cluster

a. se o servidor não possuir ainda, instale a gem do redis

b. em seu config.sh, especifique 6 nós, 3 masters, 3 slaves 

2. Familiarize-se com a saída do comando CLUSTER INFO
3. Liste os nós do cluster com o comando CLUSTER NODES
4. Pare e destrua o cluster criado
5. Crie um cluster mínimo utilizado o utilitário redis-trib.rb
4. Adicione dados de teste no cluster e verifique seu roteamento
5. Adicione um novo nó utilizando o utilitário redis-trib.rb
6. Efetue o resharding do cluster

# Redis Sentinel

1. Crie uma estrutura de replicação com masters e servers
2. Configure e inicie 3 instâncias do Sentinel
3. Explore os comandos SENTINEL
4. Retire um master e verifique o failover
