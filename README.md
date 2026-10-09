# Ecommerce Java Backend

Backend de um sistema de e-commerce desenvolvido em **Java puro**, com foco em
aprendizado de **Orientação a Objetos**, **arquitetura em camadas** e
**persistência de dados sem frameworks**. Este projeto está sendo desenvolvido de forma incremental, conforme 
aprendizado de novos conceitos e tecnologias.

## Autoria e créditos

Esta versão é desenvolvida e mantida principalmente por **Sauloelicio**, com
autorização para publicação e modificação. O projeto deriva do
`ecommerce-java-backend`, originalmente criado por **Joao-Severgnini**; a
atribuição do histórico original é preservada.

---

## 🎯 Objetivo do Projeto

- Consolidar conceitos de OOP (encapsulamento, herança, polimorfismo)
- Aplicar boas práticas de design de domínio
- Trabalhar com regras de negócio explícitas
- Implementar persistência com **JDBC**, sem uso de Spring
- Entender a separação entre domínio, aplicação e infraestrutura

---

## 🏗 Arquitetura

O projeto segue uma separação em camadas inspirada em Clean Architecture:

domain → Regras de negócio
application → Casos de uso / serviços
infrastructure → Persistência, banco de dados e detalhes técnicos
presentation → (futuro) Interface de entrada (API ou CLI)

Atualmente, a camada de apresentação é feita via `Main.java`.

---

## 🧩 Principais Conceitos Implementados

- Pedido (`Request`) com ciclo de vida (CREATED → PAID → SHIPPED → DELIVERED)
- Itens de pedido (`ItemOrdered`)
- Produtos (`Product`)
- Sistema de descontos via polimorfismo
    - Desconto fixo
    - Desconto percentual
- Cálculos financeiros utilizando `BigDecimal`

---

## 🛠 Tecnologias Utilizadas

- **Java 17**
- **Maven**
- **BigDecimal** (cálculos monetários)
- **JDBC** *(em implementação)*
- **H2 Database** *(planejado para desenvolvimento)*
- **PostgreSQL** *(planejado para produção)*

---

## 🗄 Persistência de Dados (em progresso)

A persistência será implementada utilizando **JDBC puro**, sem ORM.

Planejamento:
- Uso de **H2** como banco em memória para testes
- Uso de **PostgreSQL** em ambiente real
- Implementação manual de:
    - Conexão com banco
    - Repositórios
    - Mapeamento ResultSet → objetos

---

## 🚧 Status do Projeto

🟡 Em desenvolvimento

Funcionalidades atuais:
- Modelagem do domínio
- Regras de negócio
- Serviços de aplicação
- Fluxo completo de pedidos em memória

Próximos passos:
- Implementação de repositórios JDBC
- Integração com banco de dados
- Cadastro de produtos e clientes persistidos
- Evolução da camada de apresentação

---

## ▶️ Como Executar

```bash
mvn clean compile
mvn exec:java
```

---

## 📚 Observações

Este projeto não utiliza frameworks como Spring para reforçar o entendimento
dos conceitos fundamentais de Java e arquitetura de software.
