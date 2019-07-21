#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

// T.A.D livro
typedef struct livro_biblioteca {
    char titulo[50], autor[50], editora[50], edicao[50];
    int  ano, volume, cod_sistema, reserva;
    struct livro_biblioteca * prox;
} livro;

// Estrutura que armazena os ponteiros do início e fim da lista
typedef struct livros_ponteiros {
    livro * inicio;
    livro * fim;
    int quant_livros;
} pont_livros;

// recebe a estrutura pont_livros que armazena os ponteiros de início e fim da lista
// Inserção no fim da lista
void novo_livro_fim (pont_livros * p) {
    // alocando um nó livro
    livro * novo = (livro *) malloc (sizeof (livro));

    puts("\n\n----->>> Inserindo livro <<<-----");
    getchar(); // limpando o buffer

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

    novo->reserva = 0; // por padrão, livro não reservado
    p->quant_livros += 1; // para o controle de quantos livros armazenados

    novo->prox = NULL; // inserção no inicio ou fim, novo->prox = NULL
    // inserção no inicio (LISTA VAZIA)
    if (p->inicio == NULL && p->fim == NULL) {
        p->inicio = novo;
        p->fim = novo;
    }
    else { // inserção no fim (modo lista)
        (p->fim)->prox = novo;
        p->fim = novo;
    }
}

// equivalente ao pause break do windows
void esperar(){
    getchar();
    printf("\n\nDigite algo para continuar...");
    getchar();
}

// esta função recebe um nó livro e imprime na tela
void exibir_livro (livro * p_livro) {
    puts("\n\n----->>> Exibindo Livro <<<-----");
    printf("> Cód: %d\n", p_livro->cod_sistema);
    printf("> Título do livro: %s\n", p_livro->titulo);
    printf("> Autor: %s\n", p_livro->autor);
    printf("> Editora: %s\n", p_livro->editora);
    printf("> Edição: %s\n", p_livro->edicao);
    printf("> Ano de publicação: %d\n", p_livro->ano);
    printf("> Volume: %d\n", p_livro->volume);
    if (p_livro->reserva == 1) // livro reservado
        printf("> Situação: Reservado");
    else
        printf("> Situação: Não Reservado");
}

// função insere novo livro no início da lista
void novo_livro_inicio(pont_livros *p) {
    // alocando um nó livro
    livro * novo = (livro *) malloc (sizeof (livro));

    puts("\n\n----->>> Inserindo livro <<<-----");

    getchar();// limpando o buffer

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

    novo->reserva = 0; // por padrão, livro não reservado
    p->quant_livros += 1; // para o controle de quantos livros armazenados

    if (p->inicio == NULL && p->fim == NULL) { // inserção em lista vazia
        p->inicio = novo;
        novo->prox = NULL;
        p->fim = novo;
    }
    else {
        novo->prox = p->inicio; // inserção no inicio
        p->inicio = novo;
    }

    printf("\n > Inserção realizada com sucesso! \n");
}

// função exibe todos os livros, recebe por parâmetro o endereço inicial da lista
void exibir_todos_livros (pont_livros * p) {
    if (p->inicio == NULL)
        printf ("\n >> Lista vazia!");
    else {
        livro * aux = p->inicio;
        while (aux != NULL) {
            exibir_livro (aux);
            aux = aux->prox;
        }
    }
}

// função consulta livro na biblioteca
void consultar_livro (pont_livros * p) {
    int opc, i = 0;
    livro * aux; // variável auxiliar, ponteiros para um nó (livro)
    puts("\n\n----->>> Consultando Livro <<<-----");
    printf ("> Você deseja pesquisar um livro por qual campo?\n> 1. Titulo\n> 2. Autor\n> 3. Editora\n> 4. Ano\n> 5. Código do livro\n> Digite uma opção:");
    scanf("%d", &opc);

    getchar(); // limpando a memória

    switch (opc) {
        case 1: { // pesquisa por Título
                char titulo[60];
                
                printf("> Digite o título do livro: ");
                scanf("%[^\n]", titulo);
                getchar();

                aux = p->inicio; // aux aponta para o começo da lista
                while (aux != NULL) { // enquanto a lista não acabar 
                    if (!(strcmp(titulo, aux->titulo))) // encontrei o livro
                        exibir_livro(aux);
                    aux = aux->prox;
                }
        } break;
        case 2: { // pesquisa por Autor
                char nome_autor[60];

                printf ("> Digite o nome do autor: ");
                scanf ("%[^\n]", nome_autor);
                getchar ();

                aux = p->inicio; // aux aponta para o começo da lista
                while (aux != NULL) { // enquanto a lista não acabar 
                    if (!(strcmp(nome_autor, aux->autor))) // encontrei o livro
                        exibir_livro(aux);
                    aux = aux->prox;
                }
        } break;
        case 3: { // pesquisa por Editora
            char nome_editora[60];
            
            printf ("> Digite o nome da editora: ");
            scanf ("%[^\n]", nome_editora);
            getchar ();

            aux = p->inicio; // aux aponta para o começo da lista
            while (aux != NULL) { // enquanto a lista não acabar 
                if (!(strcmp(nome_editora, aux->editora))) // encontrei o livro
                    exibir_livro(aux);
                aux = aux->prox;
            }
        } break;
        case 4: { // pesquisa por Ano
                int ano;
                printf ("> Digite o ano de publicação: ");
                scanf ("%d", &ano);

                aux = p->inicio; // aux aponta para o começo da lista
                while (aux != NULL) { // enquanto a lista não acabar 
                    if (aux->ano == ano) // encontrei o livro
                        exibir_livro(aux);
                    aux = aux->prox;
                }
        } break;
        case 5: { // pesquisando pelo ID
            int id;

            printf ("> Digite o código do livro: ");
            scanf ("%d", &id);

            aux = p->inicio; // aux aponta para o começo da lista
            while (aux != NULL) { // enquanto a lista não acabar, percorrê-la
                if (aux->cod_sistema == id) {// encontrei o livro
                    exibir_livro (aux);
                    break; // não precisa mais procurar
                }
                aux = aux->prox;
            }
        } break;
        default:
            printf("> Valores inválidos.");
            esperar();
    }
}

// exclui livro cujo cod foi-me passado
int excluir_livro (pont_livros * p, int cod_livro) {
    // 3 tipos de exclusão: INÍCIO, MEIO E FIM
    livro * aux = p->inicio, * ant = NULL;

    // procurando o livro
    while (aux != NULL && aux->cod_sistema != cod_livro) {
        ant = aux;
        aux = aux->prox;
    }
    if (aux == NULL) // livro não encontrado, percorri toda a lista
        return -1;
    else if (aux->cod_sistema == cod_livro) { // livro encontrado
        if (aux == p->inicio) { // exclusão no início
            p->inicio = p->inicio->prox;
            free(aux);
        }
        else { // exclusão no meio ou fim
            if (aux == NULL) { // exclusão no fim
                ant->prox = NULL;
                p->fim = ant;
                free(aux);
            }
            else { // exclusão no meio
                ant->prox = aux->prox;
                free (aux);
            }
        }
        return 1; // livro removido com sucesso
    }
}

// função faz a reserva do livro, retorna 1 se reservar, -1 se erro, -2 se já estiver reservado
int reservar_livro (pont_livros * p, int cod_livro) {
    livro * aux = p->inicio;
    
    while (aux->cod_sistema != cod_livro && aux != NULL) // pesquisa na estrutura o cod do livro
        aux = aux->prox;

    if (aux == NULL)
        return -1; // livro não encontrado
    else if (aux->reserva == 1)
        return -2; // livro já reservado
    else
        aux->reserva = 1;
    return 1;
}

int main () {
    setlocale (LC_ALL, "Portuguese");
    int opc;

    // alocando dinamicamente um nó
    pont_livros p;
    // inicializando os ponteiros e o contador de livros
    p.inicio = NULL;
    p.fim = NULL;
    p.quant_livros = 0;

    do{
        system ( "clear"); // limpando o terminal
        printf ("-------------------------------------------------------------\n");
        printf ("\t   >>> Quantidade de livros cadastrados: %d\n", p.quant_livros);
        printf ("\n-------------------------------------------------------------");
        printf ("\n--> Bem vindo, digite uma opção:\n 1. Para cadastrar no inicio\n 2. Para cadastrar no fim\n 3. Para exibir todos os livros\n 4. Para pesquisar um livro\n 5. Para alugar um livro\n 6. Para excluir um livro\n 0. Para sair\n");
        printf (" > Opção: ");
        scanf ("%d", &opc);

        switch (opc) {
            case 0:
                break; // para não exibir a mensagem do default e ao mesmo tempo, encerrar o laço externo
            case 1: { // cadastrar no início da lista
                novo_livro_inicio (&p);
                esperar();
            } break;
            case 2: { // cadastrar no fim da lista
                novo_livro_fim (&p);
                esperar();
            } break;
            case 3: {
                // exibir todos os livros
                exibir_todos_livros (&p);
                esperar();
            } break;
            case 4: { // pesquisar livro
                if (p.quant_livros == 0)
                    printf("\n> ERRO! Não temos livros cadastrados, favor cadastrar um livro antes.\n");
                else {
                    consultar_livro (&p);
                }
                esperar();
            } break;
            case 5: { // alugar livro
                if (p.quant_livros == 0)
                    printf("\n> ERRO! Não temos livros cadastrados, favor cadastrar um livro antes.\n");
                else {
                    // tenho livros na biblioteca e posso tentar aluga-los
                    int cod_livro, situacao_aluguel; // variavel situacao_aluguel é pra guardar o valor da função alugar
                    printf ("Digite o código do livro que deseja alugar: ");
                    scanf ("%d", &cod_livro);

                    situacao_aluguel = reservar_livro (&p, cod_livro);
                    
                    if (situacao_aluguel) // se eu conseguir alugar
                        printf("Livro alugado com sucesso!");
                    else if (situacao_aluguel == -1)
                        printf("Livro não encontrado!");
                    else
                        printf("O livro encontra-se alugado.");
                }
                esperar();
                } break;
            case 6: { // excluir livro
                    int cod_livro, excluir; // variavel utilizada para excluir o livro em questão
                    printf ("Digite o código do livro que deseja excluir: ");
                    scanf ("%d", &cod_livro);

                    excluir = excluir_livro (&p, cod_livro);

                    if (excluir) // se excluir == 1, consegui excluir
                        printf("\nLivro excluído com sucesso!\n");
                    else // se excluir == -1, livro não encontrado
                        printf("\nLivro não encontrado!\n");
                    esperar();
                } break;
            default:
                printf("\n > Digite uma opção válida!");
                esperar();
        }
    } while (opc != 0);
    
    printf("\n\n");
    return 0;
}
