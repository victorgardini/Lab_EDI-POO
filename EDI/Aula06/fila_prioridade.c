/*
    Título e-mail: ED1_exercicioprova1_VictorFernandesGardini
    e-mail: allan.contessoto@unesp.br

    Obs: Cada vez que eu "executar o garçom", devo subtrair 5 do tempo de execução e somar 1 na quantidade de vezes executado
    Se o nó tiver sido executado 2 vezes, e ainda sobrar tempo, reduzir a prioridade
    Executar: Pegar a maior prioridade e executar o primeiro elemento de maior prioridade (subtrair o tempo), se tiver executado duas vezes, reduzir a prioridade
    Toda vez que reduzir a prioridade, exibir a lista na tela
    Sempre ordenar a lista quando quando reduzir a prioridade de um elemento
    
---------------------------------------------------------------------------------------------
    A cada vez que eu tirar 5 do tempo, jogar pro fim da fila e ordenar a prioridade dnv
    Se eu tiver executado duas vezes 5t, reduzir a prioridade
*/

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

typedef struct fila_prioridade{
    char nome[50];
    int id, tempo_atendimento, q_atendimento, prioridade;
    struct fila_prioridade *prox;
} fila;

// insere ordenado por prioridade
fila * insere_ordenado(fila *inicio){
    fila * novo = (fila *) malloc(sizeof(fila));

    novo->q_atendimento = 0;
    novo->tempo_atendimento = rand() % 50;

    printf("--> Digite o nome: ");
    scanf("%[^\n]", novo->nome);
    getchar();

    printf("--> Digite o id: ");
    scanf("%d", &novo->id);
    
    printf("--> Digite a prioridade: ");
    scanf("%d", &novo->prioridade);

    if (inicio == NULL) {
        novo->prox = NULL;
        return novo;
    }

    // inserindo ordenado
    fila *aux = inicio, *ant = NULL;
    while (aux != NULL && aux->prioridade >= novo->prioridade) {
        ant = aux;
        aux = aux->prox;
    }
    if (ant == NULL) { // inserção no início
        novo->prox = inicio;
        return novo;
    }
    else {
        if (aux == NULL){ // inserção no fim
            ant->prox = novo;
            novo->prox = NULL;
        }
        else { // inserção no meio
            ant->prox = novo;
            novo->prox = aux;
        }
        return inicio;
    }
}

void imprime_lista(fila *topo){
    fila *aux = topo;
    printf("\n--> Exibindo lista:\n");
    while (aux != NULL) {
        printf("Nome: %s\n", aux->nome);
        printf("Prioridade: %d\n\n", aux->prioridade);
        aux = aux->prox;
    }
}

int main() {
    srand(time(NULL));

    fila *inicio = NULL;
    int i;

    for (i = 0; i < 3; i++){
        inicio = insere_ordenado(inicio);
        getchar();
        printf("\n---------------------------\n");
    }

    imprime_lista(inicio);    

    return 0;
}