[Baixar PDF do desafio](https://drive.google.com/file/d/1P2s_jwH2JReJXCzQ7cOW6oA9PXk64EQj/view?usp=sharing)


##PT-BR

# Backend Technical Challenge

Este projeto implementa um sistema para gerenciar uma lista restrita de CPFs, auxiliando o time antifraude de um e-commerce no controle de CPFs com risco de fraude. Desenvolvido como parte de um desafio técnico da MaxMilhas.

---

## Funcionalidades Principais

1. **Adicionar CPF à lista restrita**  
   - Adiciona um CPF válido, sem formatação ou dígitos repetidos, incluindo a data no formato ISO 8601 - UTC.
   - **Exceções**:
     - `InvalidCpfException` para CPFs inválidos.
     - `ExistsCpfException` se o CPF já existir na lista.

2. **Verificar se um CPF está na lista**  
   - Retorna o CPF e sua data de inclusão caso esteja presente.
   - **Exceções**:
     - `InvalidCpfException` para CPFs inválidos.
     - `NotFoundCpfException` se o CPF não for encontrado.

3. **Remover um CPF da lista**  
   - Remove um CPF existente.
   - **Exceções**:
     - `InvalidCpfException` para CPFs inválidos.
     - `NotFoundCpfException` se o CPF não for encontrado.

4. **Listar todos os CPFs da lista restrita**  
   - Retorna todos os CPFs registrados ou um array vazio se nenhum estiver presente.

---

## Tecnologias Utilizadas

- **Linguagem:** Java
- **Banco de Dados:** Relacional (PostgreSQL)
- **Arquitetura:** Serviço RESTful com JSON
- **Gerenciamento de Dependências:** Maven ou Gradle
- **Containerização:** Docker para execução em ambientes consistentes

---

## Configuração e Execução

### Pré-requisitos

- [JDK 17](https://jdk.java.net/17/)
- [Maven](https://maven.apache.org/) ou [Gradle](https://gradle.org/)
- [Docker](https://www.docker.com/) (opcional para execução containerizada)
- Banco de dados configurado (PostgreSQL ou equivalente)

### Setup

1. Clone o repositório e acesse o diretório do projeto:
   ```bash
   git clone <repo-url>
   cd backend-technical-challenge
## EN-US

# Backend Technical Challenge

This project implements a system to manage a restricted list of CPFs, assisting the anti-fraud team of an e-commerce in controlling CPFs flagged as potential fraud risks. Developed as part of a technical challenge for MaxMilhas.

---

## Main Features

1. **Add CPF to the restricted list**  
   - Adds a valid CPF without formatting or repeated digits, including the date in ISO 8601 - UTC format.
   - **Exceptions**:
     - `InvalidCpfException` for invalid CPFs.
     - `ExistsCpfException` if the CPF is already in the list.

2. **Check if a CPF is on the list**  
   - Returns the CPF and its inclusion date if it exists on the list.
   - **Exceptions**:
     - `InvalidCpfException` for invalid CPFs.
     - `NotFoundCpfException` if the CPF is not found.

3. **Remove a CPF from the list**  
   - Removes an existing CPF from the list.
   - **Exceptions**:
     - `InvalidCpfException` for invalid CPFs.
     - `NotFoundCpfException` if the CPF is not found.

4. **List all CPFs in the restricted list**  
   - Returns all registered CPFs or an empty array if none exist.

---

## Technologies Used

- **Language:** Java
- **Database:** Relational (PostgreSQL)
- **Architecture:** RESTful service with JSON
- **Dependency Management:** Maven or Gradle
- **Containerization:** Docker for consistent runtime environments

---

## Setup and Execution

### Prerequisites

- [JDK 17](https://jdk.java.net/17/)
- [Maven](https://maven.apache.org/) or [Gradle](https://gradle.org/)
- [Docker](https://www.docker.com/) (optional for containerized execution)
- Configured database (PostgreSQL or equivalent)

### Setup

1. Clone the repository and access the project directory:
   ```bash
   git clone <repo-url>
   cd backend-technical-challenge
   
