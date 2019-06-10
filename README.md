# mariadapenhabackend
Backend do servico desenvolvido para disciplina de sistemas distribuidos 2019.1 CIN-UFPE

## Installation

### Fazer download do docker

https://www.docker.com/

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

## Ver API

http://localhost:9093/swagger-ui.html
