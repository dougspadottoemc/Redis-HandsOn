# Objetivo

Experimentar com recursos para otimização do uso do Redis

# Pipelines

1.  Localize o utilitário redis-benchmark e execute-o com o parâmetro "--help" para exibir todas as opções disponíveis.
2.  Execute todos os testes de benchmark e observe a saída básica. Se possível, execute os testes de uma máquina cliente separada, para simular melhor as condições do mundo real e levar em consideração as latências da rede.
3.  O tamanho padrão para os dados de benchmark é de apenas 3 bytes, então mude isso para 100 bytes. Além disso, aumente o número de clientes para 200, e apenas execute os testes SADD e SPOP.
4.  Repita o mesmo benchmark usado no passo anterior, mas agora envie os comandos em lotes de 100. Observe o aumento de ordem de magnitude no desempenho, em comparação com comandos que  usam não pipeline.
5. Experimente algumas das outras opções de benchmark disponíveis.

# Expiração de chaves

A fim de salvaguardar o broker contra o esgotamento da memória, uma técnica é colocar valores de tempo-de-vida (TTL) nas teclas.

1.  Primeiro, usando a CLI adicione a chave "quote: 221" com um valor de "94.23" para Redis.
2.  Recupere o TTL atual da chave usando o comando "TTL". Note que, uma vez que um TTL ainda não foi configurado na chave, Redis retorna -1.
3.  Agora, defina a chave para expirar após 30 segundos. Antes de passarem 30 segundos, use o comando TTL novamente para obter o tempo restante antes da chave expirar.
4.  Continue a pesquisar o tempo restante até que a chave expire, então observe como nesse ponto Redis retorna -2 uma vez que a chave expirou.

# Uso de hashes (extra)

1.  Verifique os valores sendo utilizados para hash-max-zipmap-entries e hash-max-zipmap-value na instância do Redis em execução
2.  Altere para um valor baixo, reinicie e teste adicionando até o limite do tamanho definido para verificar qual encoding o Redis passa a usar
3.  Opcionalmente, verifique o tamanho dos objetos utilizando o utilitário em https://github.com/sripathikrishnan/redis-rdb-tools 
