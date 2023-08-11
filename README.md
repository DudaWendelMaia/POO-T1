Exercicio desenvolvido para o trabalho 1 da cadeira de Programação Orientada a Objetos
# Exercício de Avaliação 1
Enunciado geral:

A ACMEPublishing é uma editora que gerencia livros e autores e que deseja automatizar o
seu catálogo.
Você será responsável pelo desenvolvimento do aplicativo que irá catalogar livros e autores
e gerar informações.
O analista de sistemas identificou as seguintes classes iniciais, com alguns atributos e
relacionamentos apresentados a seguir.


O analista identificou operações básicas iniciais das classes:
1. Biblioteca: classe catálogo que gerencia o cadastro de livros:
o cadastraLivro(Livro): recebe como parâmetro um novo Livro e cadastra-o no
sistema. Não pode haver Livros com o mesmo código ‘isbn’. Retorna true se o
cadastro teve sucesso; ou false em caso contrário.
o pesquisaLivro(String): retorna o livro com o código ‘isbn’ indicado. Se não
houver livro com este código retorna null.
o pesquisaLivro(int): retorna uma lista de livros com o ano indicado. Se não
houver nenhum livro com este ano retorna null.
2. Grupo: classe catálogo que gerencia o cadastro de autores:
o cadastraAutor(Autor): recebe como parâmetro um novo Autor e cadastra-o no
sistema. Não pode haver autores com o mesmo código. Retorna true se o
cadastro teve sucesso; ou false em caso contrário.
o pesquisaAutor(int): retorna o autor com o código indicado. Se não houver
nenhum autor com este código retorna null.
3. Livro: classe que representa um livro:
o adicionaAutor(Autor): adiciona um novo autor ao livro.
4. Autor: classe que representa um autor:
o Autor(int,String,Livro): construtor.
o adicionaLivro(Livro): adiciona um novo livro ao autor.
o pesquisaLivros(): retorna uma lista de livros do autor.
5. ACMEPublishing: classe do aplicativo:
o executa(): executa o funcionamento do aplicativo.
6. Main: classe principal (inicial) do sistema:
o main(String[]): cria um objeto ACMEPublishing e depois chama o método
executa().


O método executa() da classe ACMEPublishing deve realizar a sequência de passos:
1. Cadastrar livros: lê todos os dados de cada livro e, se o isbn não for repetido,
cadastra-o no sistema. Para cada livro cadastrado com sucesso no sistema, mostra
os dados do livro no formato: 1;isbn;titulo;ano
2. Mostrar quantos livros foram cadastrados: mostra a quantidade de livros que
foram cadastrados no sistema no formato: 2;quantidade de livros
cadastrados
3. Cadastrar autores: lê todos os dados de cada autor, inclusive o isbn de um livro,
e, se o código não for repetido, cadastra-o no sistema. Para cada autor cadastrado
com sucesso no sistema, mostra os dados do autor no formato:
3:codigo;nome;isbn
4. Mostrar quantos autores foram cadastrados: mostra a quantidade de autores
que foram cadastrados no sistema no formato: 4;quantidade de autores
cadastrados
5. Adicionar livro a um autor: lê o código de um autor e um isbn de livro, e cadastra
no sistema. Para cada livro adicionado com sucesso no autor, mostra os dados no
formato: 5;codigo;nome;isbn;titulo;ano
6. Mostrar os livros de um determinado autor: lê um código de autor e mostra os
dados de cada livro deste autor no formato: 6;codigo;nome;isbn;titulo;ano
7. Mostrar os nomes dos autores de um determinado livro: lê um isbn e mostra
os nomes dos autores do livro no formato: 7;isbn;nome1;nome2;...
8. Mostrar os títulos dos livros que possuem mais de um autor: para cada livro
que possui mais de um autor, mostra no formato: 8;isbn;titulo
9. Mostrar os nomes dos autores com mais de um livro: para cada autor com mais
de um livro, mostra o nome seguido dos isbn de cada livro no formato:
9;nome;isbn1;isbn2,...
10.Mostrar os livros de um determinado ano: lê um ano e mostra os dados dos
livros do ano indicado, no formato: 10;isbn;titulo;ano
2. Definição do exercício:
O objetivo do exercício é implementar um sistema que capaz de atender as necessidades
da empresa descrita no enunciado geral, e que atenda as restrições a seguir:
• A entrada de dados ocorrerá por leitura de arquivo de texto. Inclua na classe
ACMEPublishing o seguinte trecho de código:


o No passo 1. Cadastrar livros: cada linha corresponde ao isbn, título e ano de um
livro. Quando o isbn lido for -1, não há mais livros a serem cadastrados.
o No passo 3. Cadastrar autores: cada linha corresponde ao código, nome e isbn
do livro de um autor. Quando o código lido for -1, não há mais autores a serem
cadastrados.
o No passo 5. Adicionar livro a um autor: cada linha corresponde ao código do
autor e o isbn do livro. Quando o código lido for -1, não há mais adições de livros
a autores.
o As últimas linhas do arquivo ‘dados.txt’ correspondem a:
§ Código do autor para o passo 6.
§ Isbn do livro para o passo 7.
§ Ano do livro para o passo 10.
• Toda entrada e saída de dados com o usuário deve ocorrer apenas na classe
ACMEPublishing.
• É permitida a criação de novos métodos, atributos e relacionamentos, mas as
informações definidas no diagrama de classes original não podem ser alteradas.
• O diagrama de classes deve ser atualizado conforme as alterações realizadas e deve ser
entregue em arquivo Astah ou PDF.
