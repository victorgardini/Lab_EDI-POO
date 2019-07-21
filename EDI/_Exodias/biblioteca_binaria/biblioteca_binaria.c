#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// T.A.D biblioteca
typedef struct livro_biblioteca {
    char titulo[50], autor[50], editora[50], edicao[50];
    int  ano, volume, id, reserva;
    struct livro_biblioteca *dir, *esq;
} livro_binario;

// respectivo a inserção binária
livro_binario * inserir (livro_binario * aux, int num) {
    if (aux == NULL) {
        livro_binario * novo = (livro_binario *) malloc(sizeof(livro_binario));
        novo->esq = NULL;
        novo->dir = NULL;

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

        novo->id = num;
        aux = novo; // pra retornar no fim da função;
    }
    else if(num < aux->id)
        aux->esq = inserir(aux->esq, num);
    else
        aux->dir = inserir(aux->dir, num);

    return aux;
}

// esta função recebe um nó livro e imprime na tela
void exibir_livro (livro_binario * p_livro) {
    puts("\n\n----->>> Exibindo Livro <<<-----");
    printf("> Id: %d\n", p_livro->id);
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

void exibir_em_ordem(livro_binario * aux){
    if (aux != NULL) {
        exibir_em_ordem(aux->esq);
        exibir_livro(aux);
        exibir_em_ordem(aux->dir);
    }
}

void exibir_pre_ordem(livro_binario * aux){
    if (aux != NULL) {
        exibir_livro(aux);
        exibir_pre_ordem(aux->esq);
        exibir_pre_ordem(aux->dir);
    }
}

void exibir_pos_ordem(livro_binario *aux){
    if (aux != NULL) {
        exibir_pos_ordem(aux->esq);
        exibir_pos_ordem(aux->dir);
        exibir_livro(aux);
    }
}

// equivalente ao system("pause") do windows
void esperar(){
    getchar();
    printf("\n\nDigite algo para continuar...");
    getchar();
}

// verifica se um dado id_livro pertence a árvore
int consultar(livro_binario * aux, int id_livro, int achou) {
    if(aux != NULL && achou == 0){
        if (aux->id == id_livro) achou = 1; // o nó procurado existe na árvore
        else if(id_livro < aux->id)
            achou = consultar(aux->esq, id_livro, achou);
        else
            achou = consultar(aux->dir, id_livro, achou);
    }
    return achou;
}

// busca um nó na árvore, se o encontrar, exibe-o
void buscar_livro(livro_binario * aux, int id_livro){
    if(aux->id == id_livro)
        exibir_livro(aux);
    else {
        if(id_livro > aux->id)
            buscar_livro(aux->dir, id_livro); // buscar a direita
        else
            buscar_livro(aux->esq, id_livro); // buscar a esquerda
    }
}

// Esta função tira um nó da árvore binária
livro_binario * remover(livro_binario * aux, int id_livro) {
    livro_binario *p, *p2;
    if(aux->id == id_livro) { // livro encontrado, agora vamos ver os casos de remoção
        if(aux->esq == aux->dir) { // sem filhos
            free(aux);
            return NULL;
        }
        else if(aux->esq == NULL) { // elemento sem filho a esquerda
            p = aux->dir;
            free(aux);
            return p;
        }
        else if(aux->dir == NULL) { // elemento sem filho a direita
            p = aux->esq;
            free(aux);
            return p;
        }
        else { // elemento tem filhos para ambos os lados
            p2 = aux->dir;
            p = aux->dir;
            while (p->esq != NULL)
                p = p->esq;
            p->esq = aux->esq;
            free(aux);
            return p2;            
        }
    }
    else if(aux->id < id_livro)
        aux->dir = remover(aux->dir, id_livro);
    else
        aux->esq = remover(aux->esq, id_livro);
    return aux;
}

// Esta função elimina todos os nós da árvore
livro_binario * derrubar_arvore(livro_binario * aux) {
    if(aux != NULL) {
        aux->esq = derrubar_arvore(aux->esq);
        aux->dir = derrubar_arvore(aux->dir);
        free(aux);
    }
    return NULL;
}

int main () {
    int opc, id_livro;
    // Raiz
    livro_binario * raiz = NULL;

    do {
        system("clear");
        printf ("\n\n\n-------------------------------------------------------------")/
        printf ("\n--> Bem vindo, digite uma opção:\n 1. Para cadastrar um novo livro\n 2. Para exibir os livros em ordem\n 3. Para exibir os livros em pré-ordem\n 4. Para exibir os livros em pós-ordem\n 5. Para buscar livro pelo ID\n 6. Remover livro\n 7. Derrubar árvore (esvaziar árvore)\n 0. Para sair\n");
        printf (" > Opção: ");
        scanf ("%d", &opc);

        switch (opc) {
            case 0: break; // esta opção está aqui para que quando o usuário digite 0 não exiba a mensagem do default
            case 1: { // novo livro na árvore
                    printf("\nDigite o ID do novo livro: ");
                    scanf("%d", &id_livro);
                    raiz = inserir(raiz, id_livro);
                    printf("\n >>> Inserção feita com sucesso!");
                    esperar();
            } break;
            case 2: { // exibir livro em ordem
                if (raiz != NULL)
                    exibir_em_ordem(raiz);
                else
                    printf("Árvore vazia!!");
                esperar();
            } break;
            case 3: { // exibir livro em pré-ordem
                if (raiz != NULL)
                    exibir_pre_ordem(raiz);
                else
                    printf("Árvore vazia!!");
                esperar();
            } break;
            case 4: { //exibir livro em pós-ordem
                if (raiz != NULL)
                    exibir_pos_ordem(raiz);
                else
                    printf("Árvore vazia!!");
                esperar();
            } break;
            case 5: { // Buscar livro
                int id_livro, achou = 0;
                printf("\n >>> Qual o ID do livro que deseja buscar: ");
                scanf("%d", &id_livro);

                // verificando se o livro está na árvore
                if(raiz == NULL) printf("\n >>> Árvore vazia!!!");
                else {
                    if(consultar(raiz, id_livro, achou))
                        buscar_livro(raiz, id_livro);
                    else
                        printf("\n >>> Livro não encontrado!");
                }
                esperar();
            } break;
            case 6:{ // Remover um nó da árvore
                if(raiz == NULL) printf("\n >>> Árvore vazia!!!");
                else {
                    int id_livro, achou = 0;
                    printf("\n >>> Qual o ID do livro que você deseja remover: ");
                    scanf("%d", &id_livro);
                    
                    // verificando se o livro pertence a árvore
                    if (consultar(raiz, id_livro, achou)) {
                        // removendo o livro
                        raiz = remover(raiz, id_livro);
                        printf("\n >>> Livro removido com sucesso!");
                    }
                    else printf("\n >>> Livro não encontrado!");
                    esperar();                    
                }
            } break;
            case 7: { // Esvaziar árvore
                if(raiz == NULL) printf("\n >>> Árvore já está vazia!!!");
                else {
                    raiz = derrubar_arvore(raiz);
                    printf("\n >>> Árvore derrubada com sucesso!");
                }
                esperar();
            } break;
            default:
                printf("\n > Digite uma opção válida!");
                esperar();
        }
    } while (opc != 0);

    printf("\n >>> Até mais!!!\n");
    return 0;
}