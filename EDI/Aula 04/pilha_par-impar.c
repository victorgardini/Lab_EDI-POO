#include <stdio.h>
#include <stdlib.h>

typedef struct PILHA {
	int elem;
	struct PILHA *prox;
} pilha;

// insere um novo elemento
pilha * pop (pilha *topo, int n) {
	pilha *novo = (pilha *) malloc (sizeof(pilha));

	novo->elem = n;

	if (topo == NULL) { // pilha vazia
		topo = novo;
		novo->prox = NULL;
	}
	else {
		novo->prox = topo;
		topo = novo;
	}

	return topo;
}

void exibir_pilha (pilha *topo) {
	if (topo == NULL)
		printf("Pilha vazia!!\n");
	else {
		pilha *aux = topo;

		while(aux){
			if (aux->prox == NULL)
				printf("%3d ", aux->elem);
			else
				printf("%3d ->", aux->elem);
			aux = aux->prox;
		}
	}
}

// remove elemento pilha
pilha * push (pilha *topo){
	pilha *aux = topo;
	topo = topo->prox;
	free(aux);
	return topo;
}

pilha * inverter_pilha (pilha *topo) {
	pilha *topo_invertido = NULL; // pilha 2
	pilha *aux = topo, *aux2 = NULL;

	while (aux != NULL) {
		topo_invertido = pop(topo_invertido, aux->elem); // inserindo
		aux2 = aux->prox;
		aux = push(aux);
		aux = aux2;
	}

	return topo_invertido;
}

int main(int argc, char const *argv[]) {

	// declarando a variável topo da pilha
	// pilha *topo = NULL;
	pilha *topo_impar = NULL;
	pilha *topo_par = NULL;

	int i, n;

	for (int i = 0; i < 6; ++i) {
		printf("-> Digite um número: ");
		scanf("%d", &n);

		if (n % 2 == 0) // par
			topo_par = pop(topo_par, n);
		else
			topo_impar = pop(topo_impar, n);
	}

	printf("\n\n >> Exibindo pilhas: \n");
	printf(" >   Par: ");	exibir_pilha(topo_par);
	printf("\n > Ímpar: "); exibir_pilha (topo_impar);

	printf("\n\n >> Exibindo pilhas invertidas: \n");
	topo_par = inverter_pilha(topo_par);
	topo_impar = inverter_pilha(topo_impar);
	printf(" >   Par: ");	exibir_pilha(topo_par);
	printf("\n > Ímpar: "); exibir_pilha (topo_impar);

	printf("\n\n\n");
	return 0;
}