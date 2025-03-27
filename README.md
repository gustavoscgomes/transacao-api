<a id="readme-top"></a>
[![LinkedIn][linkedin-shield]][linkedin-url]

<details>
  <summary>Índice</summary>
  <ol>
    <li>
      <a href="#sobre-o-projeto">Sobre o Projeto</a>
      <ul>
        <li><a href="#construído-com">Contruído com</a></li>
      </ul>
    </li>
    <li><a href="#endpoints-da-api">Endpoints da API</a></li>
    <li><a href="#como-executar-o-projeto">Como Executar o Projeto</a></li>
    <li><a href="#contato">Contato</a></li>
  </ol>
</details>

## Sobre o Projeto

Este projeto é uma API REST desenvolvida como parte de um desafio para a vaga de Desenvolvedor Java Júnior no Itaú Unibanco.
O objetivo é criar um sistema que recebe transações e calcula estatísticas sobre elas.

A API foi desenvolvida utilizando Java e Spring Boot e segue as seguintes diretrizes:

* Não utiliza banco de dados (H2, MySQL, PostgreSQL, etc.) ou cache (Redis, Memcached, Infinispan, etc.).

* Armazena os dados em memória.

* Implementa três endpoints: criação de transação, remoção de transações e estatísticas das transações.

* Possui tratamento de erros, logging e Actuator para monitoramento da aplicação.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



### Construído com

* [![Java][Java.com]][Java-url]
* [![Spring][Spring.io]][Spring-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Endpoints da API

### 1. Criar Transação

- **Endpoint:** `POST /transacao`
- **Descrição:** Registra uma nova transação.
- **Requisição (JSON):**

```json
{
    "valor": 123.45,
    "dataHora": "2025-08-07T12:34:56.789-03:00"
}
```

- **Respostas:**
  - `201 Created` - Transação aceita.
  - `422 Unprocessable Entity` - Transação inválida (valor negativo, data futura, etc.).
  - `400 Bad Request` - JSON inválido.

### 2. Limpar Transações

- **Endpoint:** `DELETE /transacao`
- **Descrição:** Remove todas as transações armazenadas.
- **Resposta:** `200 OK` (sem corpo).

### 3. Obter Estatísticas

- **Endpoint:** `GET /estatistica`
- **Descrição:** Retorna estatísticas das transações nos últimos 60 segundos.
- **Resposta:** `200 OK` (JSON)

```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Como Executar o Projeto

1. Clone o repositório:
   ```sh
   git clone https://github.com/gustavoscgomes/transacao-api.git
   ```
2. Acesse o diretório do projeto:
   ```sh
   cd transacao-api
   ```
3. Compile e execute o projeto:
   ```sh
   mvn spring-boot:run
   ```

A aplicação será iniciada na porta **8080**.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



## Contato

[![LinkedIn][linkedin-shield]][linkedin-url]
[![Gmail][gmail-shield]][gmail-url]

<p align="right">(<a href="#readme-top">back to top</a>)</p>


[Spring-url]: https://spring.io/
[Spring.io]: https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white
[Java.com]: https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white
[Java-url]: https://www.java.com/
[linkedin-shield]: https://img.shields.io/badge/-Gustavoscgomes-0077B5?style=for-the-badge&logo=linkedin&logoColor=white
[linkedin-url]: https://linkedin.com/in/gustavoscgomes
[gmail-shield]: https://img.shields.io/badge/-gustavoscostagomes-D14836?style=for-the-badge&logo=gmail&logoColor=white
[gmail-url]: mailto:gustavoscostagomes@gmail.com
