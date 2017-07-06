# Objetivo

Explorar recursos de monitoramento do Redis

# Detalhando recomendação de métricas a serem monitoradas

1. Tenha uma instância de Redis executando com algumas chaves. De preferência uma nova instância sem slaves.
2. Utilizando o comando INFO, encontre as seções onde estão localizadas as métricas do slide 37. 
3. Verifique a descrição de cada métrica em https://redis.io/commands/INFO

# Utilizando o comando MONITOR

1. Em uma janela, inicie o redis-cli e execute o comando MONITOR
2. Em outra janela separada, envie comandos a outra sessão do redis-cli
3. Observe o resultado na primeira janela

# Utilizando o SLOWLOG

1. Configure o slowlog para capturar eventos que levem menos de 0 microsegundos (i.e. todos os comandos)
2. Configure o slowlog para reter somente os últimos 5 comandos que infrinjam este limite
3. Execute 5 comandos quaisquer no redis-cli
4. Visualize o slowlog
5. Execute mais 2 comandos quaisquer no redis-cli
6. Visualize novamente o slowlog
7. Esvazie o slowlog (referência: https://redis.io/commands/slowlog)

# Monitoramento de latência

1. Configure seu Redis server para monitorar a latência dos comandos que levem mais de 1 milisegundo
2. Execute uma rodada do redis-benchmark
3. Visualize as diferentes análises de latência disponíveis (LATEST, HISTORY, GRAPH e DOCTOR) -- dica: sempre consulte o Doutor antes! :)

# Latência intrínseca

Como estamos utilizando um ambiente virtualizado, se torna ainda mais importante o conhecimento da latência intrínseca do servidor, isto é, o máximo de tempo que o kernel não provê tempo de CPU para o Redis.

1. Execute o modo especial do redis-cli para medir a latência intrínseca. Execute o teste por 1 minuto.
2. Repita o teste por 3 minutos.