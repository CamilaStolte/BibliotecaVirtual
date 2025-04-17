# 📚 Biblioteca Virtual em Java

Projeto desenvolvido para a disciplina de **Ordenação em Estruturas de Dados**, com o objetivo de aplicar e integrar estruturas clássicas de dados e algoritmos de ordenação e busca em um sistema de biblioteca virtual.

## 🚀 Funcionalidades

- Cadastro e organização de livros em **árvore binária de busca (BST)**.
- Implementação de algoritmos de **ordenação**:  
  - Bubble Sort  
  - Merge Sort
- Algoritmos de **busca em grafos**:  
  - BFS (Busca em Largura)  
  - DFS (Busca em Profundidade)
- Algoritmo de **Dijkstra** para recomendação de livros com base na menor "distância" (semelhança entre livros).
- Sistema de **fila de espera** para empréstimos e **pilha** para histórico de navegação.

## 🧠 Estruturas e Algoritmos Aplicados

| Estrutura de Dados  | Utilização                                                                 |
|---------------------|-----------------------------------------------------------------------------|
| Árvore Binária (BST)| Organização dos livros por título                                           |
| Fila                | Lista de espera para empréstimo de livros                                   |
| Pilha               | Histórico de navegação do usuário                                           |
| Grafo               | Representação da relação entre livros por autor, gênero ou tema             |

| Algoritmo           | Aplicação                                                                  |
|---------------------|-----------------------------------------------------------------------------|
| Bubble Sort         | Ordenação simples de livros (ex: por título ou data de publicação)          |
| Merge Sort          | Ordenação eficiente de grandes listas de livros                             |
| DFS / BFS           | Busca de caminhos entre livros em uma árvore de temas                       |
| Dijkstra            | Recomendação de livros com base na menor distância semântica entre temas    |

## 🛠️ Tecnologias

- **Java 17+**
- **IDE** recomendada: IntelliJ IDEA / Eclipse
- Nenhuma biblioteca externa foi utilizada — todo o projeto foi implementado com foco em estruturas e algoritmos nativos.

## 🧪 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/BibliotecaVirtual.git
   cd BibliotecaVirtual
   ```

2. Compile e execute o projeto em sua IDE Java favorita.

3. Navegue pelas funcionalidades via menu principal no console.

## 📁 Estrutura de Diretórios

```
BibliotecaVirtual/
│
├── src/
│   ├── biblioteca/
│   │   ├── Livro.java
│   │   ├── Biblioteca.java
│   │   ├── ArvoreBinaria.java
│   │   ├── Ordenadores/  # BubbleSort.java, MergeSort.java
│   │   ├── Grafos/       # Grafo.java, Dijkstra.java, BFS.java, DFS.java
│   │   └── util/
│   │       └── Pilha.java, Fila.java
│
├── README.md
└── ...

```

## 📅 Histórico de Desenvolvimento

- [x] Inicialização do projeto com base nas estruturas estudadas
- [x] Implementação da BST para organização dos livros
- [x] Ordenação com Bubble Sort e Merge Sort
- [x] Adição de pilha (histórico) e fila (espera)
- [x] Implementação de grafo com sistema de recomendação
- [x] Busca com DFS, BFS e Dijkstra
