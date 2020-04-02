
# Classe Armazenamento

  

## Métodos Públicos

### Armazenar uma quantidade de um tipo de ponto em um usuário

~~~java

void  armazenarPontos(int qtdPontos, string tipoPonto, string usuario);

~~~

  

* Criar arquivo

~~~java

ct1:[(int  "5", string "moeda", string "Mario") ->  true  ->  true

~~~

  

### Recuperar pontos de um tipo de um usuário

  

~~~java

int  recuperarPontosUsuarioTipo(String usuario, String tipoPonto);

~~~

  

* Recuperar pontos adicionado uma vez

~~~java

ct1:[(string "mario", string "moeda") ->  "mario moeda: 5"  ->
 recuperarPontosUsuarioTipo("mario", "moeda")]

~~~

  

* Recuperar pontos somados

~~~java

ct2:[(String "luigi", string "moeda") ->  "luigi moeda: 10"  ->
 recuperarPontosUsuarioTipo("luigi", "moeda")]~

~~~

  

* Recuperar dois tipos de pontos

~~~java

ct3:[(String "luigi", string "moeda") ->  "luigi moeda: 10"  ->
 recuperarPontosUsuarioTipo("luigi", "moeda")]

  

[(String "luigi", string "estrela") ->  "luigi estrela: 1"  ->
 recuperarPontosUsuarioTipo("luigi", "estrela")]

~~~

  

* Recuperar três tipos de pontos

~~~java

ct4:[(String "luigi", string "moeda") ->  "luigi moeda: 10"  ->
 recuperarPontosUsuarioTipo("luigi", "moeda")]

  

[(String "luigi", string "estrela") ->  "luigi estrela: 1"  -> 
recuperarPontosUsuarioTipo("luigi", "estrela")]

  

[(String "luigi", string "cogumelo") ->  "luigi cogumelo: 5"  -> 
recuperarPontosUsuarioTipo("luigi", "cogumelo")]

~~~

  

* Recuperar pontos de usuário inexistente

~~~js

ct5:[(string  "wario", string  "moeda") -> UsuarioInexistenteException -> usuarioInexistenteException

~~~

  

### Retornar todos os usuários que já receberam algum tipo de ponto

~~~java

List<String> retornarTodosOsUsuariosComPontos();

~~~

  

* Não retornar usuários sem pontos

~~~js

ct1:[() -> false -> retornarTodosOsUsuariosComPontos().contains("Waluigi")]

[() -> false -> retornarTodosOsUsuariosComPontos().contains("Birdo")]

~~~

  

* Recuperar usuario com ponto

~~~js

ct2:[() -> true -> retornarTodosOsUsuariosComPontos().contains("Mario")]

[() -> true -> retornarTodosOsUsuariosComPontos().contains("Luigi")]

~~~

  

### Retornar todos os tipos de ponto de algum usuário@@@@@@@@@@@@@@@@@

* Retornar todos os tipos de pontos de um usuário

~~~java

String retornarTodosOsPontos(String usuario)

~~~

  

Retornar todos os pontos de um usuário com varios tipos de pontos

~~~javascript

ct1:[String  "Luigi" -> "Luigi moeda 10, estrela 1, cogumelo 5" ->
retornarTodosOsPontos("Luigi")]

~~~

  

## Funções

*  [x] Criar arquivo

*  [x] Armazenar diferentes tipos de pontos em um usuário

*  [x] Guardar dados em arquivo

*  [x] Deve ser criado de modo que a classe não dependa de como é feita essa armazenagem

*  [x] Realizar testes utilizando arquivos

  

# Classe Placar

## Métodos Públicos

### Registrar um tipo de ponto para um usuário

~~~java

Boolean  adicionarPontosUsuario(String usuario, String tipoPonto, int qtdPontos);

~~~

  

* Adicionar 5 moedas para o mario no mock

~~~js

ct1:[(String  "Mario", String  "moeda", int  5 -> true ->
adicionarPontosUsuario("Mario", "moeda", 5)]

~~~

  

### Retornar todos os pontos de um usuário, assim como os tipos. Ex: Estrela 20, moeda 25

  
  

~~~java

String  retornarTodosOsPontosUsuario(String usuario);

~~~

  

* Retornar todos os pontos de um usuario

~~~javascript

ct1:[String  "Mario" -> "Mario moeda 5" -> retornarTodosOsPontosUsuario("Luigi")]

~~~

  
  

* Erro usuário inexistente

~~~javascript

ct2:[String  "Waluigi" -> UsuarioInexistenteException -> 
retornarTodosOsPontosUsuario("Waluigi")]

~~~

  

### Retornar  ranking  de  um  tipo  de  ponto, com  a  lista  de  usuários  que  possuem  aquele  ponto  ordenados  em  ordem  decrescente

  

* Retornar  ranking  ordenado

~~~java

String  retornarRankingTipo(String  tipoPonto);

~~~

  

~~~javascript

ct1:[() -> "Luigi 10\n Mario 5" -> retornarRankingTipo("Moeda")]

~~~

  

## Funções

*  [x] Utiliza uma instância de Armazenamento

*  [x] Realizar testes com um mock object substituindo Armazenamento

*  [x] Delega a recuperação e o armazenamento de informações para a classe Armazenamento.

  

# Integração

*  [x] Criar alguns testes de integração com as duas classes

  

* Recuperar todos os pontos de um usuario

~~~javascript

ct1:[String  "Luigi" -> "Luigi moeda 10, estrela 1, cogumelo 5" -> retornarTodosOsPontosDeUmUsuario("Luigi")]

~~~

  

* Retornar ranking por tipo

~~~java

placar.adicionarPontosUsuario("Yoshi", "moeda", 15);

assertEquals("Yoshi moeda 15", placar.retornarTodosOsPontosDeUmUsuario("Yoshi"));

~~~

  

* Adicionar um usuário "Yoshi" e retorna-lo

~~~java

assertEquals(null, placar.retornarTodosOsPontosDeUmUsuario("Zaquin"));

~~~
