# Sistema CRUD em Java (Programação Orientada a Objetos)

## Descrição do Projeto

Este repositório apresenta um **sistema CRUD (Create, Read, Update e Delete)** desenvolvido em **Java**, aplicando de forma prática os principais conceitos da **Programação Orientada a Objetos (POO)**. O projeto tem como objetivo demonstrar organização de código, reutilização, manutenção e boas práticas no desenvolvimento de software orientado a objetos.

O sistema permite o gerenciamento de entidades por meio de operações básicas de cadastro, consulta, atualização e remoção de dados, servindo como base para aplicações maiores e mais complexas.

---

## Conceitos de POO Aplicados

Durante o desenvolvimento do projeto, foram utilizados os seguintes conceitos fundamentais da Programação Orientada a Objetos:

* **Encapsulamento**: controle de acesso aos atributos por meio de modificadores e métodos getters/setters;
* **Abstração**: definição de classes que representam entidades do mundo real;
* **Herança**: reaproveitamento de código entre classes relacionadas (quando aplicável);
* **Polimorfismo**: possibilidade de tratar objetos de diferentes classes de forma uniforme;
* **Separação de responsabilidades**: organização do sistema em camadas (model, service, repository, etc.).

---

## Funcionalidades do Sistema

* ➕ Criar registros (Create)
* 📄 Listar registros (Read)
* ✏️ Atualizar registros (Update)
* ❌ Remover registros (Delete)

As operações são realizadas de forma estruturada, respeitando os princípios da POO.

---

## Estrutura do Projeto

A organização do projeto segue uma separação clara de responsabilidades, aplicando o padrão de camadas:

```
📁 src
 ┣ 📁 modelo
 ┃ ┗ 📄 Produto.java           # Classe que representa a entidade Produto;
 ┣ 📁 repositorio
 ┃ ┗ 📄 ProdutoRepositorio.java # Responsável pelo armazenamento e acesso aos dados;
 ┣ 📁 servico
 ┃ ┗ 📄 ProdutoServico.java     # Contém as regras de negócio do sistema;
 ┗ 📄 Main.java                 # Classe principal que executa o CRUD.
```
---

## Como Executar o Projeto

### Pré-requisitos

* Java JDK 8 ou superior
* IDE Java (IntelliJ IDEA, Eclipse, NetBeans, ou similar)

### Passos

1. Clone este repositório:

   ```bash
   git clone https://github.com/seu-usuario/Sistema-CRUD-Java.git
   ```
2. Importe o projeto em sua IDE Java;
3. Execute a classe `Main.java`;
4. Utilize o sistema conforme as opções exibidas no console (ou interface, se houver).

---

## Objetivo

Este projeto foi desenvolvido com fins **didáticos**, visando:

* Praticar Programação Orientada a Objetos em Java;
* Consolidar conceitos fundamentais de POO;
* Demonstrar domínio básico/intermediário em desenvolvimento Java;
* Servir como portfólio acadêmico e profissional.

---
