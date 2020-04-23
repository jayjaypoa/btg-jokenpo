# btg-jokenpo
Desafio Jogo Jokenpo - API REST em Java 8 e Spring

####O JOGO :

Programa que analise o resultado de múltiplos jogadores em um jogo de jokenpo.

A solução é resiliente para possíveis mudanças como por exemplo adicionar 
e remover jogadas, e inserir e remover novos jogadores.

####REQUISITOS :

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

####ABORDAGEM TÉCNICA :

- Linguagem: Java 8
- Framework: Spring Boot 2.2
- Gerenciamento de dependência: Gradle
- Realização de Testes Unitário com JUnit : API e Serviços
- Utilizada as práticas de Clean Code : Nomes precisos, comentários necessários, DRY (Don’t repeat yourself), entre outros aspectos.
- Não há utilização de banco de dados.
- Não há utilização de bibliotecas utilitárias externas.