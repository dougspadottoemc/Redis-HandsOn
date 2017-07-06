# Objetivo

Explorar a carga massiva de dados no Redis

# Pipe

1. Crie um arquivo .txt com alguns comandos Redis para criação de chaves (use chaves, hashes, lists, sets e sorted sets para relembrar a sintaxe dos comandos)
2. Execute na linha de comando Linux `cat <arquivo .txt criado> | redis-cli --pipe`
3. Inspecione as chaves criadas 

# Utilizando o protocolo Redis

1. Crie o arquivo `gerar_resp.rb` com o seguinte código:
```
def gen_redis_proto(*cmd)
    proto = ""
    proto << "*"+cmd.length.to_s+"\r\n"
    cmd.each{|arg|
        proto << "$"+arg.to_s.bytesize.to_s+"\r\n"
        proto << arg.to_s+"\r\n"
    }
    proto
end

(0...1000).each{|n|
    STDOUT.write(gen_redis_proto("SET","Key#{n}","Value#{n}"))
}
```

2. Execute `ruby gerar_resp.rb` e inspecione a saída. Observe o padrão de formação do protocolo Redis.
3. Execute o seguinte comando `ruby gerar_resp.rb | redis-cli --pipe` e observe o resultado. Inspecione a instância de Redis para verificar as chaves criadas.

