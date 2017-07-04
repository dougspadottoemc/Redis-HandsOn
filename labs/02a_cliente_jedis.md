# Objetivo

Saber como desenvolver alguns aplicativos Redis simples usando o cliente Java Redis (Jedis). Embora este exercício tenha sido criado especificamente usando o Java, os conceitos são aplicáveis ​​a outros clientes e você pode tentar fazer os exercícios em um deles se ele melhor se adequar às suas necessidades.

# Preparação

Verifique se o servidor Redis está sendo executado.

Se não estiver usando o Java, siga as instruções para instalar seu cliente particular da Redis, a lista de clientes pode ser encontrada aqui: http://redis.io/clients. Passe para a próxima seção.

Baixe o código-fonte Java para o laboratório [aqui] ( /jedis/ ). Você deve ter um IDE instalado, como Spring Tool Suite (STS), Eclipse ou IntelliJ. Importe os laboratórios no seu IDE - por exemplo, se você estiver usando Spring STS, selecione "Arquivo -> Importar -> Geral -> Projetos existentes na área de trabalho". Selecione o diretório onde você descompactou os laboratórios, e eles devem aparecer no seu espaço de trabalho. Se houver erros que mostrem (ou seja, x vermelhos em qualquer um dos projetos), verifique se você possui uma conexão com a internet e que o suporte do Maven está habilitado no seu IDE.

# Hello Redis

Para começar, vamos escrever código para estabelecer uma conexão com o servidor Redis e executar algumas operações simples para demonstrar o uso de strings.

## Instruções

1. Se estiver usando o Java, abra o laboratório `hello` no seu IDE. Neste caso, o arquivo .java já possui o código-fonte completo.
2. Verifique qual trecho de código é utilizado para abrir uma conexão ao seu servidor Redis.
3. Verifique como são feitas chamadas a comandos Redis como get, set e manipulação de string.
4. Execute e teste o código.

# Trabalhando com outras estruturas de dados Redis

Vamos ver como alguns dos outros comandos do Redis para trabalhar com hashes, listas e conjuntos traduzem para chamadas de método programático.

## Instruções

1. Se estiver usando o Java, abra o laboratório `datastructures` no seu IDE.
2. Abra uma conexão ao seu servidor Redis.
3. Entenda o método `updateOrderStatus` que recebe uma string de ID de pedido e uma string de status e armazene-a em um hash Redis com uma chave do formato" order: <orderId> ".
4. Entenda o método `storeOrderItems` que recebe uma string de ID de pedido e uma matriz de string de ID de item de pedido e os armazene em um conjunto em Redis.
5. Entenda o método `addOrderToProcessList` que recebe uma string de ID de pedido e anexa-a a uma lista Redis com a chave" OrdersToProcess ".
6. No método principal do programa, verifique a criação de uma matriz de string `orderID` e` orderItemIds` e veja as chamadas para os 3 métodos que passam os parâmetros apropriados.
7. Execute e teste o código. Ao final, limpe o banco de dados com flushdb.

# Usando transações

Vejamos um exemplo simples usando as transações do Redis para tornar nossas operações atômicas. Vamos modificar o exercício anterior para executar todas as operações em uma transação.

## Instruções

1. Para Java, abra o laboratório `transactions` no seu IDE.
2. Os valores de retorno para cada um dos métodos de inserção de dados foram modificados para retornar o objeto de resposta de transação correspondente. Além disso, foram alterados cada método para aceitar um parâmetro de entrada de Transação.
3. Verique que as chamadas de método Jedis agora tem como parâmetro a transação passado e retornam os resultados da chamada.
4. Observe que você não pode imprimir as respostas até que a transação tenha sido executada.
5. Execute e teste seu código. Desligue o servidor quando terminar.