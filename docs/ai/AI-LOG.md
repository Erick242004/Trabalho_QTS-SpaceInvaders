# Registro do Uso de Inteligência Artificial Generativa (AI-LOG)

Este documento registra de forma transparente e auditável as interações substanciais com ferramentas de Inteligência Artificial Generativa (ex: Gemini, ChatGPT, Claude, Copilot) durante o desenvolvimento do trabalho prático da disciplina de **Qualidade e Teste de Software**.

---

## Histórico de Interações

### Interação #001 — Análise do Edital e Estruturação Inicial do Projeto
* **Data:** 19/09/2026
* **Responsável:** Leon
* **Atividade:** Planejamento inicial, mapeamento do plano de ação do trabalho e criação da estrutura base do repositório (Passo 1).
* **Ferramenta:** Gemini
* **Prompt/Instrução Utilizada:**
  > *"Analise o documento do Trabalho de Qualidade e Teste de software e crie um plano de desenvolvimento do trabalho, passo a passo e em ordem de execução*
* **Resultado:** 
  1. Criação do plano de execução ordenado em 4 fases cobrindo as entregas 1 e 2.
  2. Geração do template estruturado do arquivo `README.md` com índices diretos e tabela de responsabilidades dos 5 integrantes.
  3. Estruturação do documento de histórico `docs/ai/AI-LOG.md` e geração do primeiro registro.
* **Decisão:** Aceito integralmente. O formato e os campos atendem às exigências do edital da disciplina.
* **Validação:** Verificado manualmente se a estrutura criada atende aos requisitos de visibilidade dos artefatos na branch principal, regras de transparência de IA e suporte ao rastreamento de links dos documentos no Google Docs.

### Interação #002 — Criação do Cenário de Teste Manual (TestLink) para a classe Game
* **Data:** 19/09/2026
* **Responsável:** Leon
* **Atividade:** Escrita estruturada do Plano, Suíte e Casos de Teste manuais no TestLink focados no Game Loop e Multithreading.
* **Ferramenta:** Gemini
* **Prompt/Instrução Utilizada:**
  > *"Eu fiquei com a classe Game e vou usá-la pra documentar o cenário de teste no Testlink. Eu já criei o projeto, o plano e a suíte. Me ajude com os passos do caso de teste."*
* **Resultado:** Geração da árvore hierárquica exigida pelo TestLink (Plano de Execução, Suíte ST01 e Caso de Teste CT01.01). Foram criados passos de execução focando na validação do frame rate de 60 FPS, gerenciamento de threads (start/join) e renderização dos gráficos (BufferStrategy).
* **Decisão:** Aceito sem alterações. Os passos gerados refletem fielmente a lógica interna da classe Game.java para um teste de caixa-preta / sistema.
* **Validação:** As informações foram inseridas na interface do TestLink e a formatação de pré-condições e resultados esperados se comportou adequadamente na geração do relatório em PDF da ferramenta.

---

## Modelo para Novas Entradas (Template)

Para registrar interações futuras, copiemos a estrutura abaixo:

```markdown
### Interação #00X — [Título da Atividade]
* **Data:** DD/MM/AAAA
* **Responsável:** [Nome do Integrante]
* **Atividade:** [Ex: Criação dos Casos de Teste Unitários da Classe Game / Configuração JaCoCo]
* **Ferramenta:** [ChatGPT / Gemini / Copilot / Claude]
* **Prompt/Instrução Utilizada:**
  > *"[Insira o prompt exato ou instrução relevante]"*
* **Resultado:** [Breve resumo da resposta gerada pela IA]
* **Decisão:** [Aceito sem alterações / Alterado (detalhar o que mudou) / Rejeitado]
* **Validação:** [Descrever como o grupo testou ou validou o resultado (ex: testes executados, compilação, revisão de código)]
```