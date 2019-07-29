#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

/*********************************************************/
/* Nome: Victor Fernandes Gardini         	 	 	   	 */
/* RA: 181.044.013                        	 	 	   	 */
/* Exercício: Biblioteca EDI versão avl                  */
/* Compilador: gcc (Ubuntu 7.4.0-1ubuntu1~18.04.1) 7.4.0 */
/*********************************************************/

// T.A.D biblioteca
typedef struct livro_avl {
    char titulo[50], autor[50], editora[50], edicao[50];
    int  ano, volume, id, reserva, altd, alte;
    struct livro_avl * dir, * esq;
} livro_avl;

// Estrutura que armazena os usuários que reservaram livro
typedef struct usuario {
    char nome[50];
    int id_livro; // vetor que armazena os id do livro que o usuário reservou
    struct usuario * prox;
} usuario;

// esta função recebe um nó livro e imprime na tela
void exibir_livro (livro_avl * p_livro) {
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

livro_avl * rotacao_esquerda(livro_avl * aux) {
    livro_avl *aux1, *aux2;
    aux1 = aux->dir;
    aux2 = aux1->esq;
    aux->dir = aux2;
    aux1->esq = aux;

    if (aux->dir == NULL)
        aux->altd = 0;
    else
        if (aux->dir->alte > aux->dir->altd)
            aux->altd = aux->dir->alte + 1;
        else
            aux->altd = aux->dir->altd + 1;
    if (aux1->esq->alte > aux1->esq->altd)
        aux1->alte = aux1->esq->alte + 1;
    else
        aux1->alte = aux1->esq->altd + 1;

    return aux1;    
}

livro_avl * rotacao_direita(livro_avl * aux) {
    livro_avl * aux1, *aux2;
    aux1 = aux->esq;
    aux2 = aux1->dir;
    aux->esq = aux2;
    aux1->dir = aux;

    if (aux->esq == NULL)
        aux->alte = 0;
    else
        if (aux->esq->alte > aux->esq->altd)
            aux->alte = aux->esq->alte + 1;
        else
            aux->alte = aux->esq->altd + 1;
    if (aux1->dir->alte > aux1->dir->altd)
        aux1->altd = aux1->dir->alte + 1;
    else
        aux->altd = aux1->dir->altd + 1;

    return aux1;    
}

livro_avl * balanceamento(livro_avl * aux){
    int d, df;
    d = aux->altd - aux->alte;
    if (d == 2) {
        df = aux->dir->altd - aux->dir->alte;
        if (df >= 0)
            aux = rotacao_esquerda(aux);
        else {
            aux->dir = rotacao_direita(aux->dir);
            aux = rotacao_esquerda(aux);
        }
    }
    else if (d == -2) {
        df = aux->esq->altd - aux->esq->alte;
        if (df <= 0)
            aux = rotacao_direita(aux);
        else {
            aux->esq = rotacao_esquerda(aux->esq);
            aux = rotacao_direita(aux);
        }
    }
    return aux;
}

// inserir um novo nó avl
livro_avl * inserir (livro_avl * aux, int num){
    if (aux == NULL) {
        livro_avl * novo = (livro_avl *) malloc(sizeof(livro_avl));
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
        novo->reserva = 0; // livro não reservado
        aux = novo; // equivalente a return novo;
    }
    else { // arvore não vazia, procurando para inserir
        if (num > aux->id) { // inserir na direita
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

void exibir_em_ordem(livro_avl * aux){
    if (aux != NULL) {
        exibir_em_ordem(aux->esq);
        exibir_livro(aux);
        exibir_em_ordem(aux->dir);
    }
}

void exibir_pre_ordem(livro_avl * aux){
    if (aux != NULL) {
        exibir_livro(aux);
        exibir_pre_ordem(aux->esq);
        exibir_pre_ordem(aux->dir);
    }
}

void exibir_pos_ordem(livro_avl * aux){
    if (aux != NULL) {
        exibir_pos_ordem(aux->esq);
        exibir_pos_ordem(aux->dir);
        exibir_livro(aux);
    }
}

// equivalente ao pause break do windows
void esperar(){
    getchar();
    printf("\n\nDigite algo para continuar...");
    getchar();
}

// inserção início de uma lista
usuario * cadastrar_usuario_livro (usuario * lista_usuarios, int id_livro) {
    // alocando um nó livro
    usuario * novo = (usuario *) malloc (sizeof (usuario));

    getchar();
    printf("> Digite o nome do usuário: ");
    scanf("%[^\n]", novo->nome);
    getchar();

    novo->id_livro = id_livro;

    if (lista_usuarios == NULL) // inserção em lista vazia
        novo->prox = NULL;
    else
        novo->prox = lista_usuarios;
    return novo;
}

// lista todos os livros reservados, e respectivamente, os livros
void exibir_livros_reservados (usuario * lista_usuarios) {
    usuario * aux = lista_usuarios;
    while (aux != NULL) {
        printf("\n\nUsuário: %s", aux->nome);
        printf("\nCód. Livro: %d", aux->id_livro);
        aux = aux->prox;
        esperar();
    }    
}

// retorna 1 caso o nó esteja na árvore
int consultar(livro_avl * aux, int id_livro, int achou) {
    if(aux != NULL && achou == 0){
        if (aux->id == id_livro) achou = 1; // o nó procurado existe na árvore
        else if(id_livro < aux->id)
            achou = consultar(aux->esq, id_livro, achou);
        else
            achou = consultar(aux->dir, id_livro, achou);
    }
    return achou;
}

// Percorre a árvore e exibe o livro em questão
void buscar_livro(livro_avl * aux, int id_livro){
    if(aux->id == id_livro)
        exibir_livro(aux);
    else {
        if(id_livro > aux->id) buscar_livro(aux->dir, id_livro); // buscar a direita
        else buscar_livro(aux->esq, id_livro); // buscar a esquerda
    }
}

// excluir a árvore inteira
livro_avl * derrubar_arvore(livro_avl * aux) {
    if(aux != NULL) {
        aux->esq = derrubar_arvore(aux->esq);
        aux->dir = derrubar_arvore(aux->dir);
        free(aux);
    }
    return NULL;
}

int reservar_livro (livro_avl * aux, usuario ** lista_usuario, int achou, int id_livro) {
    if (aux != NULL && achou == 0) {
        if (aux->id == id_livro) {
            achou = 1; // o nó procurado existe na árvore
            // verificando se eu posso reservar o livro
            if(aux->reserva == 1) // livro já reservado
                printf("\n >>> O livro solicitado já encontra-se reservado!");
            else {
                aux->reserva = 1; // reservando o livro
                // salvando o livro no usuário (cadastrando usuário)
                *lista_usuario = cadastrar_usuario_livro(*lista_usuario, aux->id);
                printf("\n >>> Livro reservado com sucesso!!!");
            }
        }
        else if (id_livro < aux->id)
            achou = reservar_livro(aux->esq, lista_usuario, achou, id_livro);
        else
            achou = reservar_livro(aux->dir, lista_usuario, achou, id_livro);
    }
    return achou;
}

// função remover um nó da árvore
livro_avl * remover(livro_avl * aux, int num) {
    livro_avl * p, *p2;
    if (aux->id == num) {
        if (aux->esq == aux->dir) { // o elemento a ser removido não tem filhos
            free(aux);
            return NULL;
        }
        else if (aux->esq == NULL) { // o elemento a ser removido não tem filhos para a esquerda
            p = aux->dir;
            free(aux);
            return p;
        }
        else if (aux->dir == NULL) { // o elemento a ser removido não tem filhos para a direita
            p = aux->esq;
            free(aux);
            return p;
        }
        else { // o elemento a ser removido tem filhos para ambos os lados
            p2 = aux->dir;
            p = aux->dir;
            while (p->esq != NULL)
                p = p->esq;
            p->esq = aux->esq;
            free(aux);
            return p2;
        }
    }
    else if (aux->id < num)
        aux->dir = remover(aux->dir, num);
    else
        aux->esq = remover(aux->esq, num);
    return aux;
}

// função que altera o status de reserva de um livro binário
int cancela_reserva_livro_binario (livro_avl * aux, int cod_livro, int achou) {
    if (aux != NULL && achou == 0) {
        if (aux->id == cod_livro) { // livro encontrado
            aux->reserva = 0; // reserva cancelada
            achou = 1;
            printf("\n >>> Cancelando a reserva do livro!!!");
        }
        else if (cod_livro < aux->id)
            achou = cancela_reserva_livro_binario (aux->esq, cod_livro, achou);
        else
            achou = cancela_reserva_livro_binario (aux->dir, cod_livro, achou);
    }
    return achou;
}

// algoritmo de busca e remoção de nós em uma lista linear
usuario * BuscaRemocaoP (usuario * lista_usuarios, int cod_livro, livro_avl * raiz) {
    usuario * ant, * aux;
    aux = lista_usuarios;
    ant = NULL;
    // percorrendo a lista a procura do elemento e localizando a posição de remoção
    while (aux != NULL && aux->id_livro != cod_livro) {
        ant = aux;
        aux = aux->prox;
    }
    if (aux != NULL){ // usuario encontrado
        // antes de remover o nó da lista: mudar o status de reservado
        cancela_reserva_livro_binario(raiz, cod_livro, 0);
        printf("\n >>> Reserva cancelada com sucesso!!!");
        // removendo o nó
        if (ant == NULL) // remoção do 1 nó da lista
            lista_usuarios = aux->prox;
        else // remoção no meio ou final da lista
            ant->prox = aux->prox;
        
        free(aux);
    }
    return lista_usuarios; // retornando a lista    
}

int main () {
    // apresentação
    system("clear");
    printf("|----------------------------------------------------------------------------------------|");
    printf("\n| >>> Apresentação:                                                                      |");
    printf("\n|----------------------------------------------------------------------------------------|");
    printf("\n| >>> Nome: Victor Fernandes Gardini         	 	                                 |");
    printf("\n| >>> Exercício: Biblioteca EDI versão AVL                                               |");
    printf("\n| >>> Disciplina: Estrutura de Dados I - Ano 2018                                        |");
    printf("\n| >>> Professor: Allan Contessoto                                                        |");
    printf("\n| >>> Compilador utilizado: gcc (Ubuntu 7.4.0-1ubuntu1~18.04.1) 7.4.0  (terminal)        |\n");
    printf("|----------------------------------------------------------------------------------------|");
    printf("\n\nDigite algo para continuar...");
    getchar();

    // variáveis de controle
    int opc, id_livro;

    // compatibilidade terminal windows
    setlocale(LC_ALL, "Portuguese");
    
    // Árvore binária de livros
    livro_avl * raiz = NULL;

    // Lista de livros reservados
    usuario * lista_reservas = NULL;

    do {
        system("clear");
        printf ("-------------------------------------------------------------");
        printf ("\n--> Bem vindo, digite uma opção:\n  1. Para cadastrar um novo livro\n  2. Para exibir os livros em ordem\n  3. Para exibir os livros em pré-ordem\n  4. Para exibir os livros em pós-ordem\n  5. Para buscar livro pelo ID\n  6. Remover livro\n  7. Derrubar árvore (esvaziar árvore)\n  8. Reservar livro\n  9. Exibir todos os livros reservados\n 10. Cancelar a reserva de um livro\n  0. Para sair\n");
        printf (" > Opção: ");
        scanf ("%d", &opc);

        switch (opc) {
            // esta opção garante que 0 não exiba a mensagem do default
            case 0: break;
            // novo livro na árvore
            case 1: {
                    do {
                        printf("\n >>> Qual o ID do livro que deseja cadastrar: ");
                        scanf("%d", &id_livro);

                        // validando a entrada
                        if (id_livro <= 0)
                            printf("\n\t>>> Digite um valor maior que 0\n");
        
                        // verificando se o livro já não está na árvore
                        if (consultar(raiz, id_livro, 0)) {
                            printf("\n\t>>> Erro! Este código de livro já está cadastrado\n");
                            id_livro = -1; // para não sair do laço
                        }
                    } while (id_livro <= 0);

                    raiz = inserir(raiz, id_livro);
                    printf("\n >>> Inserção feita com sucesso!");
                    esperar();
            } break;
            // exibir livro em ordem
            case 2: {
                if (raiz != NULL)
                    exibir_em_ordem(raiz);
                else
                    printf("\n >>> Árvore vazia!!");
                esperar();
            } break;
            // exibir livro em pré-ordem
            case 3: {
                if (raiz != NULL)
                    exibir_pre_ordem(raiz);
                else
                    printf("\n >>> Árvore vazia!!");
                esperar();
            } break;
            //exibir livro em pós-ordem
            case 4: {
                if (raiz != NULL)
                    exibir_pos_ordem(raiz);
                else
                    printf("\n >>> Árvore vazia!!");
                esperar();
            } break;
            // Buscar livro
            case 5: {
                int achou = 0;
            
                if (raiz == NULL)
                        printf("\n >>> Árvore vazia!!!");
                else {
                    do {
                        printf("\n >>> Qual o ID do livro que deseja buscar: ");
                        scanf("%d", &id_livro);
                        
                        // validando a entrada
                        if (id_livro <= 0)
                            printf("\n>>> Digite um valor maior que 0");
                    } while (id_livro <= 0);
                
                    // verificando se o livro está na árvore
                    if (consultar(raiz, id_livro, achou))
                        buscar_livro(raiz, id_livro);
                    else
                        printf("\n >>> Livro não encontrado!");
                }
                esperar();
            } break;
            // Remover um nó da árvore
            case 6:{
                if (raiz == NULL)
                    printf("\n >>> Árvore vazia!!!");
                else {
                    int achou = 0;

                    // validando id_livro
                    do {
                        printf("\n >>> Qual o ID do livro que você deseja remover: ");
                        scanf("%d", &id_livro);
                    
                        // validando a entrada
                        if (id_livro <= 0)
                            printf("\n>>> Digite um valor maior que 0");
                    } while (id_livro <= 0);
                    
                    // verificando se o livro pertence a árvore
                    if (consultar(raiz, id_livro, achou)) {
                        // removendo o livro
                        raiz = remover(raiz, id_livro);
                        printf("\n >>> Livro removido com sucesso!");
                    }
                    else
                        printf("\n >>> Livro não encontrado!");                  
                }
                esperar();
            } break;
            // Esvaziar árvore
            case 7: {
                if(raiz == NULL) printf("\n >>> Árvore já está vazia!!!");
                else {
                    raiz = derrubar_arvore(raiz);
                    printf("\n >>> Árvore derrubada com sucesso!");
                }
                esperar();
            } break;
            // Reservar livro 
            case 8: {
                // verificando se o livro está na árvore
                if(raiz == NULL)
                    printf("\n >>> Árvore vazia!!!");
                else {
                    do {
                        printf("\n >>> Qual o ID do livro que deseja reservar: ");
                        scanf("%d", &id_livro);
                        
                        if (id_livro <= 0)
                            printf("\n>>> Digite um valor maior que 0");
                        else {
                            if (consultar(raiz, id_livro, 0)) // o livro encontra-se na biblioteca
                                reservar_livro(raiz, &lista_reservas, 0, id_livro);
                            else
                                printf("\n >>> Livro não encontrado!");
                        }                        
                    } while (id_livro <= 0);
                }
                esperar();
            } break;
            // exibir todos os livros reservados
            case 9: {
                usuario * aux = lista_reservas;
                if (aux == NULL)
                    printf("\n\n >>> Não há livros reservados!!! Não foi possível consultar!");
                else {
                    while (aux != NULL) {
                        printf("\n\n >>> Usuário: %s", aux->nome);
                        printf("\n >>> Código do livro: %d", aux->id_livro);
                        aux = aux->prox;
                    }
                }
                esperar();
            } break;
            // cancelar reserva de livro
            case 10: {
                // verificando se eu tenho livros reservados
                if (lista_reservas == NULL) // lista de livros reservados vazia
                    printf("\n\n >>> Não há livros reservados!!! Não foi possível cancelar uma reserva.");
                if (raiz == NULL) // não há livros cadastrados
                    printf("\n >>> Não há livros cadastrados!! Não foi possível cancelar uma reserva.");
                if (lista_reservas != NULL && raiz != NULL) {
                    do {
                        printf("\n >>> Qual o ID do livro que deseja cancelar a reserva: ");
                        scanf("%d", &id_livro);
                        
                        if (id_livro <= 0)
                            printf("\n>>> Digite um valor maior que 0");
                        else {
                            // verificando se o livro está cadastrado com o algoritmo de busca e remoção em uma lista
                            lista_reservas = BuscaRemocaoP (lista_reservas, id_livro, raiz); // removendo o nó da lista
                        }
                    } while (id_livro <= 0);
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