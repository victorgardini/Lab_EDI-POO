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

    Incluir menu de opções.
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
    
    printf("--> Prioridade:\n   >>> 1 - Pouca fome\n   >>> 2 - Muita fome\n   >>> 3 - Zumbi (muita fome)\n--> Digite a prioridade: ");
    scanf("%d", &novo->prioridade);

    printf("\n---------------------------\n");

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
    if(inicio == NULL)
        printf("  >>> Lista vazia!!!");
    else {
        fila *aux = inicio;
        while (aux != NULL) {
            printf("  >>> ID: %d\n", aux->id);
            // printf("Nome: %s\n", aux->nome);
            printf("  >>> Prioridade: %d\n", aux->prioridade);
            printf("  >>> Tempo de execução: %d\n", aux->tempo_atendimento);
            printf("  >>> Quantidade de execuções: %d\n", aux->q_atendimento);
            aux = aux->prox;
            printf("\n---------------------------\n");
        }
    }
}

// a cada execução eu tiro 5 do tempo de execução (equivalente a 5t) e jogo o elemento pro fim da lista
fila * executar(fila *topo, fila ** topo_finalizado){
    // Se durante esta execução, o nó tiver finalizado o processo, jogar pra uma outra lista
    if(topo->tempo_atendimento <= 5) {
        topo->tempo_atendimento = 0;
        topo->prioridade = 1; // passando pra outra pilha com prioridade mínima
        fila *aux = topo; // jogar o topo para outra lista
        topo = topo->prox;

        // sempre inserção no topo da fila
        if (*topo_finalizado == NULL){
            *topo_finalizado = aux;
            aux->prox = NULL;
        }
        else {
            aux->prox = *topo_finalizado;
            *topo_finalizado = aux;
        }

        return topo;
    }
    else
        topo->tempo_atendimento -= 5;
    
    // Computando a prioridade
    topo->q_atendimento++;
    if(topo->q_atendimento > 1 && topo->q_atendimento % 2 == 0 && topo->prioridade > 1) // caso necessário reduzir a prioridade
        topo->prioridade--;

    // jogando o topo pro fim da lista
    fila *aux = topo->prox, *aux2 = topo, *ant = NULL;
    topo = topo->prox; // novo topo!

    // basicamente, uma cópia do insere ordenado
    while(aux != NULL && aux->prioridade >= aux2->prioridade){ //aux2 é o nó que eu quero colocar denovo na lista
        ant = aux;
        aux = aux->prox;
    }

    if(ant == NULL)// inserção no início
        return aux2; // se a inserção for no topo, o elemento já está no topo sadhuasdhuasudh
    else if(aux == NULL){ // percorri toda a lista, inserção no fim
        ant->prox = aux2;
        aux2->prox = NULL;
    }
    else { // inserção no meio
        aux2->prox = aux->prox;
        aux->prox = aux2;
    }

    return topo;
}

fila * limpar_fila(fila *topo){
    fila *aux;
    while (topo != NULL) {
        aux = topo;
        topo = topo->prox;
        free(aux);
    }
    return topo;
}

void esperar(){
    printf("\nDigite algo para continuar...");
    getchar();
}

int main() {
    srand(time(NULL));

    fila * execucao = NULL;
    fila * finalizados = NULL;
    int i, n, opc;

    do { // for infinito
        system("clear");
        printf("------>   Bem bindo(a):   <------");
        printf("\n------ Digite alguma opção ------\n   (1) Adicionar na fila\n   (2) Listar pedidos\n   (3) Executar pedidos\n   (4) Limpar filas\n   (0) Finalizar programa\n--> Opção: ");
        scanf("%d", &opc);
        printf("\n\n");
        getchar(); // limpando o buffer
        switch (opc) {
            case 1: { // adicionar elemento na pilha
                execucao = insere_ordenado(execucao);
                printf("\n---------------------------\n");
                break;
            }
            case 2: { // listar estado da pilha
                printf("\n--> Imprimindo lista de pedidos:\n");
                imprime_lista(execucao);
                esperar(); // função Digite algo para continuar
                break;
            }
            case 3: {
                if(execucao != NULL) {
                    printf("\n Executando pedido...\n");
                    execucao = executar(execucao, &finalizados);
                }
                else
                    printf("\n  >>> ERRO: Não há pedidos a serem executados...\n\n");
                break;
            }
            case 4: {
                printf(">>> Limpando todas as filas.\n");
                execucao = limpar_fila(execucao);
                finalizados = limpar_fila(finalizados);

                printf(">>> Filas limpas!!!\n\n");
                esperar();
                break;
            }
            case 0:
                break;
            default:
                printf("\nDigite entradas válidas.\n");
        }
    } while (opc != 0);

    printf(" --> Volte sempre :)\n\n");
    return 0;
}