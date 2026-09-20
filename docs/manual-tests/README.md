# Casos de Teste Manuais

## `test-cases-sheet.csv`

16 casos de teste manuais da classe **`Ship`** (nave do jogador), detalhados em 25 passos.

**Delimitador:** ponto e vírgula (`;`) · **Codificação:** UTF-8

| Coluna | Conteúdo |
| :--- | :--- |
| `Suite` | Agrupamento funcional (Movimentação, Disparo, Renderização, Colisão, Robustez) |
| `ID` | Identificador do caso. Um caso pode ocupar várias linhas, uma por passo |
| `Titulo` | Nome do caso de teste |
| `Precondicoes` | Estado necessário antes de executar o primeiro passo |
| `Passo` | Número do passo dentro do caso |
| `Acao` | O que o testador faz |
| `Resultado_Esperado` | O que deve acontecer |
| `Prioridade` | Alta / Média / Baixa |
| `Tipo_Execucao` | Manual |
| `Defeito_Relacionado` | Defeito conhecido que o caso exercita, quando houver. Abrir a [Issue](../../../../issues) correspondente e anotar o número aqui |

### Abrir no Excel

O separador já é `;`, que é o padrão do Excel em português. Basta abrir o arquivo.
Em versões configuradas para inglês, usar **Dados → Obter Dados → De Texto/CSV** e
escolher ponto e vírgula como delimitador.

### Importar no TestLink

**Test Project → Import Test Cases**. O TestLink importa XML nativamente; para CSV,
converter a planilha usando o mapeamento de colunas acima (`ID` → *external ID*,
`Acao` → *step action*, `Resultado_Esperado` → *expected result*).

---

## Pendente

- `testlink-scenario.pdf` — o roteiro exportado do TestLink. É um **PDF gerado pela
  própria ferramenta**, então precisa ser exportado de lá depois que os casos acima
  forem importados. O README principal já aponta para este caminho.

---

## Observação de execução

Os casos que exigem o jogo rodando dependem de uma máquina com dispositivo de áudio.
`AudioSystem.getClip()` lança `IllegalArgumentException`, que não está no `catch` de
`AudioPlayer`, e o jogo não inicia em máquinas sem placa de som (VMs, WSL2 sem
`/dev/snd`, contêineres e servidores de integração contínua). O caso **CT-SHIP-015**
existe justamente para acompanhar esse defeito.
