/***************************************************************/
/* Nome: Victor Fernandes Gardini                              */
/* RA: 181.044.013                                             */
/* Compilador: gcc 7.4.0                                       */
/***************************************************************/

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Mandar a prova feita por e-mail e esperar a confirmação do professor antes de sair

typedef struct Funcionario {
    // nome, idade e salário
    char nome[100];
    int idade;
    float salario;
    struct Funcionario * prox;
} pilha;

// lista simplesmente encadeada
typedef struct Lista {
    char nome[100];
    int idade;
    float salario;
    struct Lista * prox;
} lista;

// 1 - inverter pilha em uma lista (com a lista inserindo no inicio, ou seja, uma cópia atual da pilha)
// 2 - devolver a lista de trás pra frente na pilha (invertendo a pilha)
// 3 - exibir a pilha vazia

// função insere no inicio de uma pilha
pilha * inserir_pilha (pilha * topo, char *nome, int idade, float salario) {
    // alocando um novo nó funcionário
    pilha * novo = (pilha *) malloc(sizeof(pilha));

    strcpy(novo->nome, nome);
    novo->idade = idade;
    novo->salario = salario;

    // inserindo na pilha, respeitando a inserção somente no topo
    if (topo == NULL) // pilha vazia
        novo->prox = NULL;
    else
        novo->prox = topo;

    return novo; // retornando o novo topo da pilha
}

// função insere no fim de uma lista
lista * inserir_fim_lista (lista *l, char *nome, int idade, float salario) {
    lista * novo = (lista *) malloc(sizeof(lista));

    strcpy(novo->nome, nome);
    novo->idade = idade;
    novo->salario = salario;

    // inserindo no fim da lista
    if (l == NULL) { // lista vazia
        novo->prox = NULL;
        return novo; // retornando o novo início
    }
    else {
        // procurando o fim da lista
        lista * aux = l;
        while (aux->prox != NULL)
            aux = aux->prox;

        // cheguei no fim da lista
        aux->prox = novo;
        novo->prox = NULL;

        return l;
    }
}

// função realiza uma cópia da pilha em uma lista (mantém a organização dos nós)
pilha * inverter_pilha_lista (pilha *topo, lista **l) {
    pilha * aux = topo;

    while (topo != NULL) {
        *l = inserir_fim_lista (*l, topo->nome, topo->idade, topo->salario);
        aux = topo;
        topo = topo->prox;
        free(aux);
    }
    return topo; // retornando o topo vazio
}

// Função que pega os nós de uma lista e insere na pilha
pilha * transferir_lista_pilha (lista *l) {
    lista * aux = l;
    pilha * topo = NULL;

    while (aux != NULL) {
        topo = inserir_pilha(topo, aux->nome, aux->idade, aux->salario);
        // aux = l;
        aux = aux->prox;
        // free(aux);
    }
    return topo;
}

// Função exibe os nós de uma pilha
void exibir_pilha(pilha *topo) {
    if (topo == NULL)
        printf(" >>> Pilha vazia!!");
    else {
        pilha * aux = topo;
        while (aux != NULL) {
            printf("\n   >>> Nome: %s\n", aux->nome);
            printf("   >>> Idade: %d\n", aux->idade);
            printf("   >>> Salario: R$ %.2f\n", aux->salario);
            aux = aux->prox;
        }
    }
}

// Função exibe os nós de uma lista
void exibir_fila(lista *l) {
    if (l == NULL)
        printf(" >>> Lista vazia!!");
    else {
        lista * aux = l;
        while (aux != NULL) {
            printf("\n   >>> Nome: %s\n", aux->nome);
            printf("   >>> Idade: %d\n", aux->idade);
            printf("   >>> Salario: R$ %.2f\n", aux->salario);
            aux = aux->prox;
        }
    }
}

// função equivalente ao system("pause") do windows
void esperar(){
    printf("\n\n\n Digite algo para continuar...");
    getchar();
}

// limpa uma estrutura pilha retornando o topo NULL
pilha * limpar_pilha(pilha *topo){
    pilha * aux = topo;
    while (topo != NULL) {
        aux = topo;
        topo = topo->prox;
        free(aux);
    }
    return topo;
}

int main() {
    system("clear");

    // inicializando estruturas
    lista *lista_funcionarios = NULL;
    pilha *pilha_funcionarios = NULL;

    printf("Antes de começar, estado inicial da pilha: \n");
    exibir_pilha(pilha_funcionarios);
    esperar();
    system("clear");

    int i = 0, idade;
    float salario;
    char nome[100];

    // Recebendo o nome, idade de salário de 10 funcionários da empresa
    for (i = 0; i < 10; i++) {
        printf("\n--> Cadastrando funcionário:\n");
        printf("   >>> Digite o nome do funcionário: ");
        scanf("%[^\n]", nome);
        printf("   >>> Digite a idade do funcionário: ");
        scanf("%d", &idade);
        printf("   >>> Digite o salário do funcionário: R$ ");
        scanf("%f", &salario);   
        pilha_funcionarios = inserir_pilha(pilha_funcionarios, nome, idade, salario);
        getchar(); // limpando o buffer
        printf("\n-----------------------------------\n");
    }

    // Exibindo o estado inicial da pilha
    printf("\n\nExibindo a pilha de funcionários (original): ");
    exibir_pilha(pilha_funcionarios);

    // Exibindo a cópia da pilha
    pilha_funcionarios = inverter_pilha_lista(pilha_funcionarios, &lista_funcionarios);    
    printf("\n\nExibindo a lista de funcionários (cópia da pilha): ");
    exibir_fila(lista_funcionarios);

    // Exibindo a pilha invertida
    printf("\n\nExibindo a pilha de funcionários (inverso da pilha original, ou seja, ordem de cadastro):");
    pilha_funcionarios = transferir_lista_pilha(lista_funcionarios);
    exibir_pilha(pilha_funcionarios);

    // Mostrando que a pilha finaliza vazia
    printf("\n\nEstado final da pilha:\n");
    pilha_funcionarios = limpar_pilha(pilha_funcionarios);
    exibir_pilha(pilha_funcionarios);
    esperar();
    return 0;
}