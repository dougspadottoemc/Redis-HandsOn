# Objetivo

Ganhar familiaridade com o conjunto de comandos do Redis e suas estruturas de dados

# Preparação

Garanta que seu servidor Redis está em execução.
Antes de iniciar a linha de comando, verifique as opções com redis-cli --help

Quais são os parâmetros para especificar o servidor e porta?

# Trabalhando com chaves

## Instruções

1.  Crie a chave "simples" com o valor "um valor", e então cheque para ver se o valor foi inserido corretamente
2.  Crie 3 usuários fictícios com as chaves formatadas como "usuario:identificador", com o identificador começando em 1, depois 2, etc...
3.  Liste todas as chaves já criadas
4.  Liste somente as chaves de usuários
5.  Crie mais dois usuários, com o fim do identificador sendo os números 11 e 21
6.  Liste todas as chaves de usuário com identificadores terminando em 1
7.  Crie um usuario com o identificador terminando em 1 e cujo número esteja entre 20 e 39
8.  Liste todas as chaves de usuário com identificador terminando em 1 e que esteja entre 20 e 30
9.  Mude a chave usuario:1 para usuario:01
10. Liste todas as chaves terminadas em 1
11. Remova o usuário com identificador 3
12. Configure o usuario 2 para que sua chave expire em 10 segundos

# Trabalhando com Strings

## Instructions

1.  Crie uma chave chamada "animal" com o valor "gato".
2.  Mude o valor da chave "animal" de "gato" para "peixe", retornando o valor original.
3.  Acrescente "-espada" ao valor da chave "animal"
4.  Retorne a substring "espada".
5.  Retorne a substring "peixe".
6.  Defina uma nova string chamada "count" com o valor 0.
7.  Incremente "count" em 1.
8.  Incremente "count" em 10.
9.  Retorne o comprimento da string "count".

# Trabalhando com Hashes

É preferível utilizar hashes ao invés de strings no Redis, uma vez que elas permitem que o usuário organize seus objetos em espaços definidos.

1.  Primeiramente, cheque se existe a chave "cachorros" existe na hash "animais".
2.  Crie a hash "animais" e adicione "cachorros" com o valor 25 associado a ele.
3.  Adicione "gatos" com o valor de 37 associado.
4.  Adicione "peixes" com o valor de 28 associado.
5.  Retorne todo o conteúdo (chaves e valores) da hash "animais".
6.  Retorne o valor somente das chaves "cachorros" e "gatos".
7.  Em um único comando, crie uma hash chamada "arvores" e adicione "palmeira" com o valor 81, "pinheiro" com o valor 23, e "baobá" com o valor 1.
8.  Mostre somente os valores da hash "arvores".
9.  Mostre somente as chaves da hash "arvores".
10.  Corrija o valor de "pinheiro" para 12 e verifique.

# Trabalhando com Lists

1. Adicione o valor "Verificar correio" ao final da lista "tarefas", mas usando o comando que o adiciona somente se a lista já existir. (Uma vez que ela não deve existir, observe o valor de retorno do comando.)
2. Repita o passo anterior, mas use a versão do comando que não verifica a existência.
3. Anexe o valor "Abrir correio" ao final da lista.
4. Adicione "Iniciar sistema" ao início da lista.
5. Obter o tamanho da lista.
6. Retorne o conteúdo de toda a lista.
7. Faça com que a primeira entrada na lista seja "Abrir o correio".
8. Usando um único comando, examine as primeiras 2 entradas na lista.
9. Remova a primeira entrada na lista.
10. Examine o valor da segunda entrada na lista.
11. Retorne toda a lista.

# Trabalhando com Sets

1. Primeiro, adicione "maçãs", "laranjas" e "bananas" a um conjunto chamado "cesta:1".
2. Liste os membros da "cesta:1".
3. Adicione "abacaxis", "bananas" e "laranjas" a um conjunto "cesta:2".
4. Verifique os membros do "cesto:2".
5. Obtenha a interseção dos 2 conjuntos.
6. Mova "abacaxis" de "cesta:2" para "cesta:1", e verifique listando os membros.
7. Armazene a união dos 2 conjuntos em um novo conjunto chamado "allbaskets".
8. Remova "laranjas" de "cesta:1".


# Trabalhando com Sorted Sets

1. Adicione os seguintes membros e scores ao conjunto ordenado "equipe:1": Joao 69, Leonardo 67, Sergio 70, Sandra 68, Ana 70 e Maria 73.
2. Retorne o número de membros no conjunto.
3. Obtenha uma contagem do número de membros com scores entre 70 e 75.
4. Obtenha os membros com scores entre 65 e 70.
5. Retorne a classificação da Sandra no time.
6. Retorne, por ordem decrescente, os membros com scores entre 65 e 69.
