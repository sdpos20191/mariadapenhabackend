# mariadapenhabackend
Backend do servico desenvolvido para disciplina de sistemas distribuidos 2019.1 CIN-UFPE

## Installation

### Instalar o docker

Ver orientações de instalação de acordo com seu sistema operacional em:

https://www.docker.com/

### Fazer clone do repositório

Rodar o comando

```
$ git clone https://github.com/sdpos20191/mariadapenhabackend.git
```

### Fazer o build das imagens

Rodar o comando

```
$ cd mariadapenhabackend
$ ./build.sh
```

### Iniciar o cluster

Rodar o comando

```
$ docker swarm init
```

### Subir o stack

Rodar o comando

```
$ docker stack deploy -c docker-swarm.yaml mp
```


### Resumo dos comandos:

```
$ git clone https://github.com/sdpos20191/mariadapenhabackend.git
$ cd mariadapenhabackend
$ ./build.sh
$ docker swarm init
$ docker stack deploy -c docker-swarm.yaml mp
```

### Para derrubar o stack

```
$ docker stack rm mp
```


## Verificar API

Aguardar em torno de 1 minuto para que as imagens subam e acessar o endereço:

http://localhost:9093/swagger-ui.html
