<h2>Desafio FSF Back-End Java Spring Boot</h2>

<h3> Requisitos do Sistema  </h3>

<h4> Cadastro de Combustíveis: Criação, leitura, atualização e exclusão (CRUD) de tipos de combustíveis (Gasolina, Etanol).
 </h4> 
<ul>
   <li> [x] Controle de Estoque: Registro de entradas e saídas de combustíveis.</li>
</ul>

<h4> Registro de Vendas</h4>

<ul>
    <li> [x] Registro das vendas realizadas com detalhes de combustível, quantidade, valor, hora e minuto do abastecimento. </li>
    <li> [x] Registro do tempo de abastecimento em cada bomba.</li>
    <li> [x] Registro do valor do litro do combustível.</li>

</ul>

<h4> Relatórios</h4>

<ul>
    <li> [x] Relatório diário do total vendido de cada tipo de combustíve.</li>
    <li> [x] Relatório diário do estoque atual de cada tipo de combustível.</li>
    <li> [x] Registro do valor do litro do combustível.</li>
    <li> [x] Relatório diário do valor vendido de cada tipo de combustível e do total vendido. </li>

</ul>

<h3>  Requisitos Técnicos  </h3>

<h4>Banco de Dados:</h4>

<ul>
<li>[x] Postgresql.</li>
</ul>

<h4>Spring Boot:</h4>

<ul>
<li>[x] Utilizar Spring Data JPA para a persistência dos dados.</li>
<li>[ ] Implementar autenticação e autorização utilizando Spring Security.</li>
</ul>

<h4> Rotas </h4>

<h4> Usuário </h4>

<small>Criação de usuário </small>
POST: http://localhost:8080/usuarios

    "name":"john doe",
    "username":"johndoe",
    "password":"123123123"

<h4> combustível </h4>

<small>Cadastrar combustível </small>
POST: http://localhost:8080/combustivel

    "currentValue":"3.78",
    "total_liters":"0.0",
    "fuel":"ALCOOL"

<small>Alterar preço </small>
PATH: http://localhost:8080/combustivel

    "name":"ALCOOL",
    "value":7.29

<small>Retornar todos os combustível </small>
GET: http://localhost:8080/combustivel
