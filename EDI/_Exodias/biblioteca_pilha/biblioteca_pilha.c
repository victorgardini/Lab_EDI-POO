#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

// T.A.D livro da biblioteca
typedef struct livro_biblioteca {
    char titulo[50], autor[50], editora[50], edicao[50];
    int  ano, volume, cod_sistema, reserva;
    struct livro_biblioteca *prox;
} livro;

// recebe a estrutura livro que o armazena no início
livro * novo_livro (livro * topo) {
    // alocando um nó livro
    livro * novo = (livro *) malloc (sizeof (livro));

    puts("\n\n----->>> Inserindo livro <<<-----");
    fflush(stdin); // limpando o buffer

    getchar();
    printf("> Digite o titulo do livro [string]: ");
    scanf("%[^\n]", novo->titulo);
    getchar();

    printf("> Digite o autor do livro [string]: ");
    scanf("%[^\n]", novo->autor);
    getchar();

    printf("> Digite a editora do livro [string]: ");
    scanf("%[^\n]", novo->editora);
    getchar();

    printf("> Digite a edição do livro [string]: ");
    scanf("%[^\n]", novo->edicao);

    printf("> Digite o ano de publicação [int]: ");
    scanf("%d", &novo->ano);

    printf("> Digite o volume da edição [int]: ");
    scanf("%d", &novo->volume);

    printf("> Digite o código do livro no sistema [int]: ");
    scanf("%d", &novo->cod_sistema);

    if (topo == NULL) { // inserção no inicio (PILHA VAZIA)
        novo->prox = NULL; // inserção no inicio novo->prox = NULL
        topo = novo;
    }
    else { // inserção no inicio com a pilha não vazia
        novo->prox = topo;
        topo = novo;
    }

    return topo;
}

// esta função recebe um nó livro e imprime na tela
void exibir_livro (livro *p_livro) {
    puts("\n\n----->>> Exibindo Livro <<<-----");
    printf("> Cód: %d\n", p_livro->cod_sistema);
    printf("> Título do livro: %s\n", p_livro->titulo);
    printf("> Autor: %s\n", p_livro->autor);
    printf("> Editora: %s\n", p_livro->editora);
    printf("> Edição: %s\n", p_livro->edicao);
    printf("> Ano de publicação: %d\n", p_livro->ano);
    printf("> Volume: %d\n", p_livro->volume);
    if (p_livro->reserva == 1) // livro reservado
        printf("> Situação: Reservado.");
    else
        printf("> Situação: Disponível para reserva.");
}

// função exibe todos os livros da pilha
void exibir_todos_livros (livro * topo) {
    if (topo == NULL)
        printf ("\n >> Pilha vazia!");
    else {
        livro * aux = topo;
        while (aux != NULL) {
            exibir_livro (aux);
            aux = aux->prox;
        }
    }
}

// função consulta livro na biblioteca
void consultar_livro (livro * topo) {
    int opc, i = 0;
    livro * aux; // variável auxiliar, ponteiro para um nó (livro)
    puts("\n\n----->>> Consultando Livro <<<-----");
    printf ("> Você deseja pesquisar um livro por qual campo?\n> 1. Titulo\n> 2. Autor\n> 3. Editora\n> 4. Ano\n> Digite uma opção:");
    scanf("%d", &opc);

    getchar(); // limpando a memória

    switch (opc) {
        case 1: {
                // pesquisa por Título
                char titulo[60];
                
                printf("> Digite o título do livro: ");
                scanf("%[^\n]", titulo);
                getchar();

                aux = topo; // aux aponta para o começo da lista
                while (aux != NULL) { // enquanto a lista não acabar 
                    if (!(strcmp(titulo, aux->titulo))) // encontrei o livro
                        exibir_livro(aux);
                    aux = aux->prox;
                }
                break;
        }
        case 2: {
                // pesquisa por Autor
                char nome_autor[60];

                printf ("> Digite o nome do autor: ");
                scanf ("%[^\n]", nome_autor);
                getchar ();

                aux = topo; // aux aponta para o começo da lista
                while (aux != NULL) { // enquanto a lista não acabar 
                    if (!(strcmp(nome_autor, aux->autor))) // encontrei o livro
                        exibir_livro(aux);
                    aux = aux->prox;
                }
            break;
        }
        case 3: {
            // pesquisa por Editora
            char nome_editora[60];
            
            printf ("> Digite o nome da editora: ");
            scanf ("%[^\n]", nome_editora);
            getchar ();

            aux = topo; // aux aponta para o começo da lista
            while (aux != NULL) { // enquanto a lista não acabar 
                if (!(strcmp(nome_editora, aux->editora))) // encontrei o livro
                    exibir_livro(aux);
                aux = aux->prox;
            }
            break;
        }
        case 4: {
            // pesquisa por Ano
                int ano;
                printf ("> Digite o ano de publicação: ");
                scanf ("%d", &ano);

                aux = topo; // aux aponta para o começo da lista
                while (aux != NULL) { // enquanto a lista não acabar 
                    if (aux->ano == ano) // encontrei o livro
                        exibir_livro(aux);
                    aux = aux->prox;
                }
            break;
        }
        default:
            printf("> Valores inválidos.");
    }
}

// retira o livro que está no topo (remoção pilha)
livro * excluir_livro (livro * topo) {
    // pilha vazia
    if (topo == NULL) {
        printf("\n  >>> Pilha vazia!\n");
        return topo;
    }
    else { // removendo o elemento no topo
        livro * aux = topo;
        topo = topo->prox;
        free(aux);
        if (topo == NULL)
            return NULL;
        return topo; // livro removido com sucesso
    }
}

int main () {
    setlocale (LC_ALL, "Portuguese");
    int opc;

    // cabeça
    livro * topo = NULL;

    do {
        printf ("\n\n\n-------------------------------------------------------------"); // quebrando linha
        printf ("\n--> Bem vindo, digite uma opção:\n 1. Para cadastrar um livro\n 2. Para exibir todos os livros\n 3. Para pesquisar um livro\n 4. Para excluir o livro do topo\n 0. Para sair\n");
        printf (" > Opção: ");
        scanf ("%d", &opc);

        switch (opc) {
            case 0: break;
            case 1: // cadastrar um novo livro no início da pilha
                    topo = novo_livro(topo);
                break;
            case 2: // exibir todos os livros
                    exibir_todos_livros (topo);
                break;
            case 3: // pesquisar livro
                consultar_livro (topo);
                break;
            case 4: { // excluir livro
                    int excluir; // variavel utilizada para excluir o livro em questão
                    printf ("Removendo livro do topo...");

                    topo = excluir_livro (topo);
            }
            break;
            default:
                printf("\n > Digite uma opção válida!");
        }
    } while (opc != 0);
    
    printf("\n\n");
    return 0;
}