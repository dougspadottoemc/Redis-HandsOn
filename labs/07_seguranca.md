# Objetivo

Experimentar alguns dos recursos de segurança básica oferecidos pelo Redis.

# Preparação

Certifique-se de que o seu servidor Redis está sendo executado e que você pode se conectar a ele a partir da interface da linha de comando.

# Autenticação de usuário

A Redis permite autenticação simples de nome de usuário / senha.

## Instruções

1. Abra o arquivo de configuração Redis para edição e encontre a opção "requirepass".
2. Descomente, e defina o valor para a senha que deseja usar. Observação: em produção, se você estiver configurando esse parâmetro, você deve configurá-lo como uma string muito longa, pois Redis é extremamente rápido em solicitações de serviço. Portanto, um cliente mal-intencionado poderia tentar quebrar a senha através da força bruta.
3. Reinicie o servidor Redis para que as alterações de configuração entrem em vigor.
4. Conecte-se ao servidor usando a CLI Redis e tente executar alguns comandos básicos. Você deve obter um erro "NOAUTH Authentication required".
5. Execute o comando auth com uma senha inválida para ver a resposta de erro.
6. Execute o comando auth com a senha correta e tente novamente alguns dos comandos básicos anteriores que falharam anteriormente. Você deve ser capaz de executá-los com sucesso agora.

# Ofuscando Comandos

Para proteger ainda mais o seu servidor Redis, é possível ofuscar alguns dos comandos Redis mais críticos. Isso pode ser feito no arquivo de configuração, adicionando o parâmetro "rename-command" para especificar quais comandos devem ser ofuscados.

## Instruções

1. Abra seu arquivo de configuração do Redis para edição e encontre o parâmetro "rename-command" (que deve estar comentado). Mude o nome do comando CONFIG para uma string vazia, que irá desativá-lo completamente.
2. Adicione outra linha para ofuscar o comando "INFO", para uma seqüência de sua escolha, então re-inicie o seu servidor Redis.
3. Inicie a CLI da Redis e conecte-se ao seu servidor. Primeiro tente executar um comando CONFIG, você deve obter "(error) ERR comando desconhecido 'config'".
4. Agora tente executar o comando INFO, ele também deve retornar o mesmo erro.
5. Use a seqüência ofuscada que você selecionou para executar o comando INFO, ele deve ser concluído com sucesso desta vez.