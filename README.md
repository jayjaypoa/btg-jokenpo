# btg-jokenpo
Desafio Jogo Jokenpo - API REST em Java 8 e Spring

#### O JOGO :

Programa que analise o resultado de múltiplos jogadores em um jogo de jokenpo.

A solução é resiliente para possíveis mudanças como por exemplo adicionar 
e remover jogadas, e inserir e remover novos jogadores.

#### REQUISITOS :

Os jogadores deverão informar as entradas através das jogadas e o sistema 
deverá indicar qual o jogador ganhador. 
 
As entradas das jogadas são disponibilizadas através de APIs REST, 
além da aplicação disponibilizar APIs para realização do cadastro dos jogadores 
e das jogadas também tem a possibilidade de consulta-los e excluí-los.

Exemplos:
1. Entrada 1 – Jogador 1 e Jogada Pedra
2. Entrada 2 – Jogador 2 e Jogada Tesoura
3. Entrada 3 – Jogador 3 e Jogada Tesoura
4. Jogar 
5. Resultado Jogador 1 Vitória

#### ABORDAGEM TÉCNICA :

- Linguagem: Java 8
- Framework: Spring Boot 2.2
- Gerenciamento de dependência: Gradle
- Realização de Testes Unitário com JUnit : API e Serviços
- Utilizada as práticas de Clean Code : Nomes precisos, comentários necessários, DRY (Don’t repeat yourself), entre outros aspectos.
- Não há utilização de banco de dados.
- Não há utilização de bibliotecas utilitárias externas.

## DEMAIS REGRAS E OBSERVAÇÕES : 

- Foi utilizado padrão Singleton para armazenar em memória as informações.
- O nome do jogador deve possuir ao menos 1 caractere.
- Nomes duplicados não são permitidos, mesmo que sejam escritos em letras minúsculas ou maiúsculas.
- São permitidos que os jogadores apliquem funções semelhantes, por exemplo : mais de um jogador ser PAPER ou STONE.
- É possível ter mais de um vencedor, pois os jogadores podem utilizar a mesma função. Exemplo : Dois jogadores que colocaram STONE ganharam de todos os demais.
- Primeiro deve se cadastrar os jogadores.
- Após cadastrar os jogadores, pode-se realizar o movimento/a jogada.
- Ao final das jogadas, pode se solicitar o resultado final.
- O resultado final exibe o(s) ganhador(es) e o histórico com o que cada um fez na rodada.
- Após exibição do resultado final, as jogadas (move/movements) são zerados/apagados, permitindo assim que os mesmos jogadores realizem nova jogada. 

## ENDPOINTS E EXEMPLOS DE CHAMADAS : 

### 1. JOGADORES (Player)

##### 1.1 Inserção

###### 1.1.1 Exemplo de Chamada

```curl
curl --location --request POST 'http://localhost:8080/v1/btg/jokenpo/player' \
--header 'Content-Type: application/json' \
--data-raw '{
	"playerName" : "JOGADOR 1"
}'
```

###### 1.1.2 Exemplo de Retorno de Sucesso - 200 OK

```json
{
    "meta": {
        "timestamp": "2020-04-24T12:04:04.179+0000"
    },
    "data": {
        "playerName": "JOGADOR 1"
    }
}
```

##### 1.2 Exclusão

###### 1.2.1 Exemplo de Chamada

```curl
curl --location --request DELETE 'http://localhost:8080/v1/btg/jokenpo/player/?playerName=JOGADOR%202'
```

###### 1.2.2 Exemplo de Retorno de Sucesso - 200 OK

```json
{
    "meta": {
        "timestamp": "2020-04-24T12:10:09.618+0000"
    },
    "data": [
        {
            "playerName": "JOGADOR 1"
        },
        {
            "playerName": "JOGADOR 3"
        },
        {
            "playerName": "JOGADOR 4"
        },
        {
            "playerName": "JOGADOR 5"
        }
    ]
}
```

##### 1.3 Listagem

###### 1.3.1 Exemplo de Chamada

```curl
curl --location --request GET 'http://localhost:8080/v1/btg/jokenpo/player'
```

###### 1.3.2 Exemplo de Retorno de Sucesso - 200 OK

```json
{
    "meta": {
        "timestamp": "2020-04-24T12:09:13.319+0000"
    },
    "data": [
        {
            "playerName": "JOGADOR 1"
        },
        {
            "playerName": "JOGADOR 2"
        },
        {
            "playerName": "JOGADOR 3"
        },
        {
            "playerName": "JOGADOR 4"
        },
        {
            "playerName": "JOGADOR 5"
        }
    ]
}
```

### 2. JOGADA (Move/Movement)

##### 2.1 Inserção

###### 2.1.1 Exemplo de Chamada

```curl
curl --location --request POST 'http://localhost:8080/v1/btg/jokenpo/move' \
--header 'Content-Type: application/json' \
--data-raw '{
	"playerName" : "JOGADOR 1",
	"movement" : "STONE"
}'
```

###### 2.1.2 Exemplo de Retorno de Sucesso - 200 OK

```json
{
    "meta": {
        "timestamp": "2020-04-24T12:11:57.896+0000"
    },
    "data": {
        "player": {
            "playerName": "JOGADOR 1"
        },
        "movement": "STONE"
    }
}
```

##### 2.2 Exclusão

###### 2.2.1 Exemplo de Chamada

```curl
curl --location --request DELETE 'http://localhost:8080/v1/btg/jokenpo/move?playerName=JOGADOR%201'
```

###### 2.2.2 Exemplo de Retorno de Sucesso - 200 OK

```json
{
    "meta": {
        "timestamp": "2020-04-24T12:13:36.885+0000"
    },
    "data": [
        {
            "player": {
                "playerName": "JOGADOR 2"
            },
            "movement": "PAPER"
        },
        {
            "player": {
                "playerName": "JOGADOR 3"
            },
            "movement": "STONE"
        },
        {
            "player": {
                "playerName": "JOGADOR 4"
            },
            "movement": "SPOCK"
        }
    ]
}
```

##### 2.3 Listagem

###### 2.3.1 Exemplo de Chamada

```curl
curl --location --request GET 'http://localhost:8080/v1/btg/jokenpo/move'
```

###### 2.3.2 Exemplo de Retorno de Sucesso - 200 OK

```json
{
    "meta": {
        "timestamp": "2020-04-24T12:05:47.495+0000"
    },
    "data": [
        {
            "player": {
                "playerName": "JOGADOR 1"
            },
            "movement": "STONE"
        },
        {
            "player": {
                "playerName": "JOGADOR 2"
            },
            "movement": "PAPER"
        },
        {
            "player": {
                "playerName": "JOGADOR 3"
            },
            "movement": "STONE"
        },
        {
            "player": {
                "playerName": "JOGADOR 4"
            },
            "movement": "SPOCK"
        }
    ]
}
```

### 3. RESULTADO DO JOGO (Play)

##### 3.1 Obter Resultado do Jogo

###### 3.1.1 Exemplo de Chamada

```curl
curl --location --request GET 'http://localhost:8080/v1/btg/jokenpo/play'
```

###### 3.1.2 Exemplo de Retorno de Sucesso - 200 OK

```json
{
    "meta": {
        "timestamp": "2020-04-24T12:20:38.639+0000"
    },
    "data": {
        "history": [
            "JOGADOR 1 (STONE)",
            "JOGADOR 2 (PAPER)",
            "JOGADOR 3 (SCISSORS)",
            "JOGADOR 4 (STONE)",
            "JOGADOR 5 (SPOCK)"
        ],
        "result": "NOBODY WON!"
    }
}
```

###### 3.1.3 Exemplo de Retorno de Erro - Não Há Jogadores Cadastrados/Jogando

```json
{
    "timestamp": "2020-04-24T12:18:00.825+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "ERR-3001 - There's no one playing",
    "path": "/v1/btg/jokenpo/play"
}
```

###### 3.1.4 Exemplo de Retorno de Erro - Há Jogadores Que Ainda Não Realizaram a Jogada

```json
{
    "timestamp": "2020-04-24T12:14:15.700+0000",
    "status": 500,
    "error": "Internal Server Error",
    "message": "ERR-3003 - There are players who have not yet chosen",
    "path": "/v1/btg/jokenpo/play"
}
```

##### 3.2 Limpar Todos os Dados

###### 3.2.1 Exemplo de Chamada

```curl
curl --location --request DELETE 'http://localhost:8080/v1/btg/jokenpo/play'
```

###### 3.2.2 Exemplo de Retorno de Sucesso - 200 OK

```json
{
    "meta": {
        "timestamp": "2020-04-24T12:17:29.885+0000"
    },
    "data": []
}
```