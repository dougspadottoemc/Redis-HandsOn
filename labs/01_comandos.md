# Objetivo

Ganhar familiaridade com o conjunto de comandos do Redis

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

Feel free to experiment with some of the other key commands available.


# Trabalhando com Strings, Hashes, Lists, Sets, Sorted Sets
# Trabalhando com Pub/Sub, Transações, comandos de administração...

...