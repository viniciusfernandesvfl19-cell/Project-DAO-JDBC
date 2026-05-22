# Projeto JDBC DAO (Vendedores e Departamentos)

Este foi o meu primeiro projeto focado em persistência de dados e arquitetura de software em Java. O objetivo principal foi aprender como conectar uma aplicação Java a um banco de dados relacional (MySQL) utilizando a API JDBC pura, aplicando boas práticas de design patterns.

---

## 🛠️ Tecnologias Utilizadas

* **Java 25**
* **MySQL Database**
* **Driver JDBC do MySQL**
* **IntelliJ IDEA**

---

## 🏛️ Arquitetura e Padrões de Projeto

Para organizar o código de forma profissional e evitar misturar regras de banco de dados com a lógica principal, o projeto foi estruturado utilizando os seguintes conceitos:

* **Camada das Entidades (Domain):** Classes puras (`Seller` e `Department`) que representam as tabelas do banco de dados na memória do Java.
* **Padrão DAO (Data Access Object):** Criação de interfaces (`SellerDAO`, `DepartmentDAO`) e suas implementações em JDBC (`SellerDaoJDBC`, `DepartmentDaoJDBC`). Isso isola todo o código SQL dentro de classes específicas.
* **Padrão Factory:** Utilização da classe `DAOFactory` para instanciar os DAOs injetando a conexão automaticamente, escondendo os detalhes de implementação do programa principal.
* **Tratamento de Recursos Otimizado:** Uso rigoroso de blocos `try-catch-finally` para garantir que conexões, `Statement` e `ResultSet` sejam fechados corretamente, evitando vazamentos de memória (*memory leaks*).

---

## 🚀 Funcionalidades Implementadas

### Camada de Departamento (`DepartmentDaoJDBC`):
* [x] **`insert`**: Insere um novo departamento e recupera o ID autoincremento gerado pelo MySQL.
* [x] **`update`**: Atualiza o nome de um departamento existente pelo seu ID.
* [x] **`deleteById`**: Remove um departamento (com proteção de integridade relacional).
* [x] **`findById`**: Busca um departamento específico pelo ID.
* [x] **`findAll`**: Retorna uma lista com todos os departamentos cadastrados em ordem alfabética.

### Camada de Vendedor (`SellerDaoJDBC`):
* [x] **`insert` / `update` / `deleteById` / `findById`**
* [x] **`findAll`**: Busca todos os vendedores realizando um `INNER JOIN` com a tabela de departamentos.
* [x] **`findByDepartment`**: Filtra vendedores de um departamento específico.
* [x] **Mapeamento de Objetos com Map:** Implementação de um `Map<Integer, Department>` no laço de repetição das buscas para evitar a duplicação de objetos de departamento na memória do Java (reaproveitando a mesma instância para vendedores do mesmo setor).

---

## 💡 Aprendizados Relevantes

Durante o desenvolvimento, enfrentei e resolvi desafios reais de um desenvolvedor back-end, tais como:
1. **Produto Cartesiano no SQL:** Entendi a importância da precisão nas cláusulas `ON` de um `INNER JOIN` (como o uso correto do ponto em `table.column`) para evitar duplicação fantasma de registros.
2. **Ambiguidade de Colunas:** Aprendi a especificar apelidos (`AS depName`) e prefixos (`seller.Name`) quando duas tabelas possuem colunas com o mesmo nome.
3. **Erros de Runtime:** Lidando com `NullPointerException` ao tentar manipular objetos não encontrados ou métodos ainda não implementados.
