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
#include <string.h>

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

void imprime_lista(fila *inicio){
    fila *aux = inicio;
    printf("\n--> Exibindo lista:\n");
    while (aux != NULL) {
        printf("Nome: %s\n", aux->nome);
        printf("Prioridade: %d\n\n", aux->prioridade);
        aux = aux->prox;
    }
}

fila * insere_ordenado_dois(fila *inicio, char nome[], int id, int tempo_atendimento, int q_atendimento, int prioridade){
    fila * novo = (fila *) malloc(sizeof(fila));

    novo->q_atendimento = q_atendimento;
    novo->tempo_atendimento = tempo_atendimento;
    strcpy(novo->nome, nome);
    novo->id = id;
    novo->prioridade = prioridade;

    // inserir ordenado reaproveitado
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

// função que pega uma lista e utilizando o insere ordenado, cria uma nova lista ordenada (l2)
fila * reorganiza_fila(fila *l1) {
    fila * l2 = NULL, *aux;
    while(l1 != NULL) {
        aux = l1;
        l2 = insere_ordenado_dois(l1, l1->nome, l1->id, l1->tempo_atendimento, l1->q_atendimento, l1->prioridade);
        l1 = l1->prox;
        free(aux);
    }
    return l2;
}

// a cada execução eu tiro 5 do tempo de execução (equivalente a 5t) e jogo o elemento pro fim da lista
fila * executar(fila *topo){
    // Computando o tempo de execução
    if(topo->tempo_atendimento < 5)
        topo->tempo_atendimento = 0;
    else
        topo->tempo_atendimento -= 5;
    
    // Computando a prioridade
    topo->q_atendimento++;
    if(topo->q_atendimento == 2)
        if(topo->prioridade > 1) // caso seja possível reduzir a prioridade
            topo->prioridade--;

    // jogando o topo pro fim da lista
    fila *aux = topo, *aux2;
    topo = topo->prox; // novo topo!

    while(aux2->prox != NULL) // percorrendo até o último elemento
        aux2 = aux2->prox;
    aux2->prox = aux; // colocando o antigo topo no fim da fila
    aux->prox = NULL;

    return topo;
}

int main() {
    srand(time(NULL));

    fila *inicio = NULL, *l_teste = NULL;
    int i;

    for (i = 0; i < 3; i++){
        inicio = insere_ordenado(inicio);
        getchar();
        printf("\n---------------------------\n");
    }

    imprime_lista(inicio);

    printf("\n\nTeste:");
    l_teste = reorganiza_fila(inicio);
    // printf("%p", l_teste);
    imprime_lista(l_teste);

    return 0;
}