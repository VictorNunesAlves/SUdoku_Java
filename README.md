# Sudoku Console Game (Java)

Este é um projeto em **Java** que implementa um jogo de **Sudoku** jogável no console.  
O usuário pode iniciar um novo jogo, inserir números, remover valores, verificar o status do tabuleiro e finalizar a partida.  

O projeto foi desenvolvido aplicando **Programação Orientada a Objetos (POO)**, com classes separadas para representar o **Tabuleiro** e os **Espaços** individuais.

---

## 🎮 Funcionalidades

- **Iniciar Novo Jogo**
  - Escolha de dificuldade (Fácil, Médio ou Difícil).
  - O tabuleiro é preenchido parcialmente com números válidos.
- **Colocar Número**
  - Permite ao jogador inserir um valor em uma posição do tabuleiro, se permitido.
- **Remover Número**
  - Remove o valor de uma célula alterável.
- **Visualizar Jogo Atual**
  - Exibe o tabuleiro formatado no console.
- **Verificar Status do Jogo**
  - Mostra se existem valores inválidos ou duplicados.
- **Limpar Jogo**
  - Remove todos os valores inseridos pelo usuário, mantendo os números fixos da dificuldade.
- **Finalizar Jogo**
  - Verifica se o tabuleiro está completo e correto antes de encerrar.
- **Sair**
  - Fecha o programa.

---

## 🧩 Estrutura do Código

### `Main.java`
Responsável pelo fluxo principal do jogo:
- Menu interativo.
- Entrada do usuário via `Scanner`.
- Chamada dos métodos do tabuleiro.

### `Tabuleiro.java`
Representa o tabuleiro de Sudoku:
- Armazena os espaços em uma matriz `9x9`.
- Métodos para:
  - Alterar e remover valores.
  - Limpar tabuleiro.
  - Verificar se uma jogada é válida.
  - Checar se há erros ou espaços vazios.

### `Espaço.java`
Representa uma célula do Sudoku:
- Contém um valor inteiro (`0` significa vazio).
- Indica se a célula pode ou não ser alterada (`alteravel`).

---

## 🏗️ Exemplo de Execução

```
Selecione uma das opções
[1] - Iniciar novo Jogo
[2] - Colocar novo número
[3] - Remover número
[4] - Visualizar Jogo Atual
[5] - Verificar status do jogo
[6] - Limpar jogo
[7] - Finalizar jogo
[8] - Sair
```

Tabuleiro exibido no console:

```
    1 2 3 | 4 5 6 | 7 8 9
   -------+-------+-------
1 | 5 . . | . 8 . | . . . |
2 | . . 7 | . . 3 | 1 . . |
3 | . 4 . | 9 . . | . . 6 |
  --------+-------+--------
4 | . 9 5 | . . . | 6 . . |
5 | . . . | 2 . . | . 7 . |
6 | . . . | . 6 7 | . . . |
  --------+-------+--------
7 | 6 . . | . . . | 4 . . |
8 | . 3 . | . 5 1 | . . . |
9 | . . . | . . . | . 8 . |
```

---

## 🚀 Como Executar

1. Clone este repositório ou copie os arquivos `Main.java`, `Tabuleiro.java` e `Espaço.java`.
2. Compile o projeto:
   ```bash
   javac Main.java Tabuleiro.java Espaço.java
   ```
3. Execute o programa:
   ```bash
   java Main
   ```

---

## 🛠️ Tecnologias Utilizadas
- **Java 17+** (compatível com versões anteriores).
- **Programação Orientada a Objetos (POO)**.

---

## 📌 Possíveis Melhorias Futuras
- Gerar tabuleiros resolvíveis e únicos.
- Implementar resolução automática.
- Interface gráfica (Swing/JavaFX).
- Sistema de dicas para o jogador.

---

## 👨‍💻 Autor

Victor Hugo Nunes Alves

**Projeto desenvolvido como prática de **Java e Programação Orientada a Objetos**.  
