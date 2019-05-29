/***************************************************************/
/* Nome: Victor Fernandes Gardini                              */
/* RA: 181.044.013                                             */
/* Compilador: gcc 7.4.0                                       */
/***************************************************************/

#include <stdio.h>
#include <stdlib.h>

typedef struct Produtos {
    int cod_produto, quantidade;
    float preco_produto;
    struct Produtos *prox;
} lista;

// função que cadastra um produto
lista * cadastrar_produto (lista *l, int cod_produto, float preco_produto, int quantidade) {
    lista * novo = (lista *) malloc(sizeof(lista));

    novo->cod_produto = cod_produto;
    novo->preco_produto = preco_produto;
    novo->quantidade = quantidade;

    // inserindo no início da lista
    if (l == NULL) // inserção com lista vazia
        novo->prox = NULL;
    else // novo início
        novo->prox = l;

    return novo;
}

// Função imprime todos os produtos de uma lista
void imprimir_produtos (lista *l){
    lista *aux = l;
    while (aux != NULL) {
        printf("   >>> Cod Produto: %d\n", aux->cod_produto);
        printf("   >>> Preço Produto: R$ %.2f\n", aux->preco_produto);
        printf("   >>> Quantidade: %d\n\n", aux->quantidade);
        aux = aux->prox;
    }
}

// Função que modifica o preço dos produtos na lista. Ex. de desconto: desconto = 0.10
lista * aplicar_desconto (lista *l, float desconto) {
    lista * aux = l;

    while (aux != NULL) {
        aux->preco_produto = aux->preco_produto - (aux->preco_produto * desconto);
        aux = aux->prox;
    }
    return l;
}

// retorna um inteiro que representa a quantidade de produtos com mais de 500 unidades
int quantidade_produtos (lista *l) {
    lista * aux = l;
    int cont = 0;

    while (aux != NULL) {
        if (aux->quantidade > 500)
            cont++;
        aux = aux->prox;
    }
    return cont;
}

int main() {
    system("clear");
    // Bem-vindo
    printf("Bem vindo ao Mercadinho Nota10\n"); // sacou a piada??

    // Inicializando variáveis
    lista * Produtos = NULL;
    int i, cod_produto, quantidade;
    float preco_produto;

    // Primeiro passo: Cadastrando 5 produtos
    for (i = 0; i < 5; i++) {
        printf("\n--> Cadastrando produto:\n");
        printf("   >>> Digite o cod do produto: ");
        scanf("%d", &cod_produto);
        printf("   >>> Digite o preço do produto: R$ ");
        scanf("%f", &preco_produto);
        printf("   >>> Digite a quantidade em estoque: ");
        scanf("%d", &quantidade);
        printf("\n-----------------------------------\n");
        Produtos = cadastrar_produto (Produtos, cod_produto, preco_produto, quantidade);
    }

    system("clear");
    // Exibindo produtos antes do desconto
    printf("--> Exibindo produtos cadastrados (sem desconto): \n\n");
    imprimir_produtos(Produtos);

    // Aplicando desconto
    float desconto;
    printf("--> Quanto de desconto você deseja aplicar, por favor, digite um valor inteiro: ");
    scanf("%f", &desconto);
    desconto = desconto / 100; // computando o desconto

    system("clear");
    printf("--> Exibindo produtos com desconto de %.2f porcento: \n\n", desconto);
    Produtos = aplicar_desconto(Produtos, desconto);
    imprimir_produtos(Produtos);

    printf("--> Quantidade de produtos com mais de 500 unidades: %d\n\n", quantidade_produtos(Produtos));

    return 0;
}