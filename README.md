# Trabalho Prático - Qualidade e Teste de Software

> **Disciplina:** Qualidade e Teste de Software  
> **Sistema Sob Teste (SUT):** Space Invaders (Java)  
> **Repositório Original:** [Upstream](https://github.com/repo-software-testing-courses/gameSpaceInvaders)  
> **Repositório Fork / Grupo:** [Trabalho](https://github.com/noidnoidnoid/Trabalho_QTS-SpaceInvaders)

---

## Equipe e Responsabilidades

| Integrante | Matrícula | Responsabilidade Principal | Classe Complexa Atribuída ($\text{CC} \ge 10$) |
| :--- | :--- | :--- | :--- |
| **Breno Carvalho** | 123083015 | `Testador` | `Level2State` |
| **Erick Bessa** | 122083063 | `Testador` | `Level1State` |
| **Leon Stevans** | 123083047 | `Projetista de Teste/ Testador` | `Game` |
| **Luiz Eduardo** | 123083019 | `Testador` | `Ship` |
| **Roger Egito** | 220083118 | `Testador` | `AudioPlayer` |

---

## Visão Geral do Sistema Sob Teste (SUT)

O projeto escolhido é o jogo **Space Invaders**, desenvolvido em Java com Arquitetura Orientada a Objetos e manipulação de multithreading para renderização contínua de gráficos em tempo real via Canvas/JFrame (`60 FPS`).

---

## Índice de Artefatos e Entregáveis

Todas as entregas estão organizadas na branch principal (`main` / `master`) conforme os requisitos da disciplina.

### Documentação Geral e Logs
* **Plano de Teste:** [Docs](https://docs.google.com/document/d/1kktI82aWBj7p4GrCMSzNBMWDEArWQh54ub-EJuK4X20/edit?usp=sharing)
* **Registro de Uso de IA:** [AI-LOG](docs/ai/AI-LOG.md)
* **Slides de Apresentação:** [Slides](docs/slides/)

---

### Entrega 1 (Peso 3) — *Prazo: 21/09/2026*
* [x] **Descrição do Escopo:** Incluído no documento do [Plano de Teste](https://docs.google.com/document/d/1kktI82aWBj7p4GrCMSzNBMWDEArWQh54ub-EJuK4X20/edit?usp=sharing).
* [x] **Código-fonte Original:** Preservado na estrutura inicial do repositório.
* [ ] **Casos de Teste Unitários Iniciais:** Localizados em `src/test/java/...`
* [ ] **Casos de Testes Manuais:**
  * [x] Cenário exportado do **TestLink**: [`PDF`](docs/manual-tests/CT01-GameLoop-TestLink.pdf)
  * [ ] Demais casos de teste manuais: [`XLSX`](docs/manual-tests/test-cases-sheet.xlsx)
* [x] **Registro de Bugs / Bugs Tracking:** [Aba Issues do Repositório](../../issues?q=is%3Aissue)

---

### Entrega 2 (Peso 5) — *23/11/2026*
* [ ] **Testes Unitários Evoluídos & Testes de Integração:** Isolamento de dependências (`Mocks`/`Stubs`) em `src/test/java/...`.
* [ ] **Métricas de Qualidade ISO 25010:** Relatório e justificativas no [Plano de Teste](https://docs.google.com/document/d/).
* [ ] **Testes Automatizados de Sistema:** Requisitos funcionais e não-funcionais em `src/test/java/system/...`.
* [ ] **Cobertura Estrutural ($\ge 80\%$ Todas-Arestas):** Relatório JaCoCo/HTML disponível em [`docs/reports/coverage/`](docs/reports/coverage/).
* [ ] **Teste Baseado em Defeitos ($\ge 80\%$ Escore de Mutação):** Relatório Pitest disponível em [`docs/reports/mutation/`](docs/reports/mutation/).
* [ ] **Inspeção de Código (SonarQube/SonarCloud):**
  * Evidências antes das correções: [`docs/sonar/before/`](docs/sonar/before/)
  * Evidências após as correções: [`docs/sonar/after/`](docs/sonar/after/)

---

## Ferramentas Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Build & Dependências:** Maven / Gradle
* **Framework de Testes:** JUnit 5, Mockito, PIT Mutation Testing, JaCoCo
* **Automação de Sistema:** Selenium / Robot / TestNG
* **Análise Estática:** SonarQube / SonarCloud
* **Gestão de Testes Manuais:** TestLink
