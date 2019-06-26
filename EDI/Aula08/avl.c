#include <stdio.h>
#include <stdlib.h>

typedef struct arvore_avl{
    int num, alte, altd;
    struct arvore_avl *esq. *dir;
} avl;

avl * inserir (avl * aux, int num){
    if (aux == NULL) { // inserindo elemento
        avl * novo = (avl *) malloc(sizeof(avl));
        novo->num = num;

        novo->esq = NULL;
        novo->dir = NULL;
        novo->altd = 0;
        novo->alte = 0;

        aux = novo;
    }
    else { // arvore não vazia, procurando para inserir
        if (num > aux->num) { // inserir na direita
            aux->dir = inserir(aux->dir, num);
            if (aux->esq->altd > aux->esq->altd)
                aux->altd = aux->esq->altd + 1;
            else
                aux->alte = aux->dir->altd + 1;
            aux = balanceamento(aux);
        }
        else { // inserir na esquerda
            aux->esq = inserir(aux->esq, num);
            aux = balanceamento(aux);
        }
    }
    return aux;
}