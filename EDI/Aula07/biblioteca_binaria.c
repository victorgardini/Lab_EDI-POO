#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

typedef struct livro_biblioteca {
    char titulo[50], autor[50], editora[50], edicao[50];
    int  ano, volume, cod_sistema, reserva;
    struct livro_biblioteca *prox;
} livro;

livro * novo_livro(livro *raiz){
    // alocando um nó livro
    livro * novo = (livro *) malloc (sizeof (livro));

    puts("\n\n----->>> Inserindo livro <<<-----");
    getchar(); // limpando o buffer

    getchar();
    printf("> Digite o titulo do livro [string]: ");
    scanf("%[^\n]", novo->titulo);

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

    if (){
        /* code */
    }
    
}