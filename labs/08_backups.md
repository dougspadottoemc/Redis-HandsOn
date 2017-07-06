# Objetivo

Recuperar backups de arquivos AOF e RDB

# Sem AOF

1. Inicie ou utilize uma instância do Redis que tenha a configuração appendonly no
2. Adicione chaves nesta instância
3. Configure uma nova instância mas não a inicie
4. Copie o arquivo dump.rdb da primeira instância para o diretório raiz da nova instância
5. Inicie a nova instância e verifique que as chaves da instância anterior estão presentes

# Com AOF

1. Na instância iniciada ao final da seção anterior, ative o uso de arquivos AOF
2. Envie comandos de escrita para esta instância (SET, HSET, HMSET, etc.)
3. Verifique que um novo arquivo, appendonly.aof foi criado. Verifique o seu conteúdo
4. Desligue a persistência de snapshots (opções `save` e `dbfilename` no arquivo de configuração)
5. Adicione mais chaves à instância e em seguida desligue a instância (shutdown)
6. Reinicie a instância e verifique que o arquivo AOF foi relido
