#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <locale.h>

typedef struct tipoPessoa{
	int id;
	char nome[30];
}TP;

typedef struct tipoNo{
	TP pessoa;
	struct tipoNo *esq, *dir;
}TN;

TN* inserir(TN *raiz, TP *novaPessoa)
{
	if(raiz == NULL)
	{
		raiz = new TN;
		raiz->pessoa = *novaPessoa;//atribuir o conteudo de uma variavel para um ponteiro
		raiz->esq = NULL;
		raiz->dir = NULL;
	}else
	{
		if((strcmp(novaPessoa->nome, raiz->pessoa.nome)) < 0)
		//if(novaPessoa->id < raiz->pessoa.id)
		{
			raiz->esq = inserir(raiz->esq, novaPessoa);
		}
		else
		{
			raiz->dir = inserir(raiz->dir, novaPessoa);
		}
	}
	return raiz;
}

void lerDados(TP *novaPessoa)
{

	printf("\n Informe o id da pessoa:");
	fflush(stdin);
	scanf("%d", &novaPessoa->id);
	
	printf("\n Informe o nome do novo usu�rio:");
	fflush(stdin);
	gets(novaPessoa->nome);
}

int consultarRecursivo(TN *auxRaiz, char nomeBusca[30])
{
	if(auxRaiz == NULL)
	{
		return 0;
	}else
	{
		if(strcmp(auxRaiz->pessoa.nome, nomeBusca) == 0)
		{
			return 1;
		}else
		{
			if(strcmp(auxRaiz->pessoa.nome, nomeBusca) > 0)
			{
				return consultarRecursivo(auxRaiz->esq, nomeBusca);
			}else
			{
				return consultarRecursivo(auxRaiz->dir, nomeBusca);
			}
		}
	}
} 


void preOrdem(TN *raiz)
{
	if(raiz != NULL){
	
		printf("\n Id: %d", raiz->pessoa.id);
		printf("\n Nome: %s", raiz->pessoa.nome);
		printf("\n-----------------------------\n");
		preOrdem(raiz->esq);
		preOrdem(raiz->dir);
	}
}

void emOrdem(TN *raiz)
{
	if(raiz != NULL)
	{
		emOrdem(raiz->esq);

		printf("\n Id: %d", raiz->pessoa.id);
		printf("\n Nome: %s", raiz->pessoa.nome);
		printf("\n-----------------------------\n");
	
		emOrdem(raiz->dir);
	}
}

void posOrdem(TN *raiz)
{
	if(raiz != NULL)
	{
		posOrdem(raiz->esq);
		posOrdem(raiz->dir);
	
		printf("\n Id: %d", raiz->pessoa.id);
		printf("\n Nome: %s", raiz->pessoa.nome);
		printf("\n-----------------------------\n");

	}
}

int sobeMaiorDireita(TN *aux){
	while(aux->dir != NULL)//while at� n�-folha
	{
		aux = aux->dir;//n� mais a direita
	}
	return (aux->pessoa.id);//retornar o elemento mais a direita a arvore
}

/*TN* remover(TN *raiz, char nomeRemover[30])
{
	TN *atual, *anterior;
	atual = raiz;
	anterior = raiz;
	
	while (atual != NULL)
	{
		if(strcmp(atual->pessoa.nome, nomeRemover) == 0)
		{
			if (atual == raiz) //se n� que ser� exclu�do estiver na raiz
			{
				if ((atual->esq == NULL) && (atual->dir == NULL)) // s� um elemento na �rvore
				{
					raiz = NULL;
				}
				else
				{
					if (atual->dir == NULL) //s� tem sub-�rvore esquerda
					{
						raiz = atual->esq;
					}
					else
					{
						if (atual->esq == NULL) //s� tem sub-�rvore direita
						{
							raiz = atual->dir;
						}
						else
						{
							if (atual->esq != NULL & atual->dir != NULL) //n� a ser exclu�do est� na raiz e possui 2 sub-�rvores
							{
								TN *aux_ante, *aux_atual;
								aux_ante = atual->esq;
								aux_atual = atual->esq;
								while (aux_atual->dir != NULL) //localizando o elemento mais � direita da sub-�rvore esquerda
								{
									aux_ante = aux_atual;
									aux_atual = aux_atual->dir;
								}
								strcpy(atual->pessoa.nome, aux_atual->)
								atual->elemento.valor = aux_atual->elemento.valor;
								aux_ante->dir = aux_atual->esq;
							}
						}
					}
				}
			}
			else
			{
				if (atual->elemento.valor > anterior->elemento.valor)
				{
					if (atual->dir == NULL)
					{
						anterior->dir = atual->esq;
						break;
					}
					else
					{
						if (atual->esq == NULL)
						{
							anterior->dir = atual->dir;
							break;
						}
					}
				}
				else
				{
					if (atual->elemento.valor < anterior->elemento.valor)
					{
						if (atual->dir == NULL)
						{
							anterior->esq = atual->esq;
							break;
						}
						else
						{
							if (atual->esq == NULL)
							{
								anterior->esq = atual->dir;
							}
						}
					}
					else
					{
						if (atual->esq != NULL & atual->dir != NULL) //n� a ser exclu�do est� na raiz e possui 2 sub-�rvores
						{
							TNo *aux_ante, *aux_atual;
							aux_ante = atual;
							aux_atual = atual->esq;
							while (aux_atual->dir != NULL) //localizando o elemento mais � direita da sub-�rvore esquerda
							{
								aux_ante = aux_atual;
								aux_atual = aux_atual->dir;
							}
							atual->elemento.valor = aux_atual->elemento.valor;
							if (aux_ante == atual)
							{
								aux_ante->esq = aux_atual->esq;
							}
							else
							{
								aux_ante->dir = aux_atual->esq;
							}
							atual = aux_atual;
						}
					}	
				}
			}
		}
		else
		{
			if (auxValor < atual->elemento.valor)
			{
				anterior = atual;
				atual = atual->esq;
			}
			else
			{
				if (auxValor > atual->elemento.valor)
				{
					anterior = atual;
					atual = atual->dir;
				}
			}
		}
		
		
	}
	if (atual == NULL)
	{
		printf("\n Elemento nao foi encontrado");
	}
	else
	{
		free(atual);
	}
	return raiz;
}*/
	
int main(){
	setlocale(LC_ALL, "Portuguese");
	TN *raiz;
	raiz = NULL;//inicializar arvore
	
	TP pessoa;
	
	int opcao;
	
	do{
		printf("\n 1 - Inserir novo usu�rio");
		printf("\n 2 - Apresentar usu�rios em pre-ordem");
		printf("\n 3 - Apresentar usu�rios em ordem");
		printf("\n 4 - Apresentar usu�rios em pos-ordem");
		printf("\n 5 - Consultar usu�rio");
		printf("\n 6 - Remover um elemento");
		printf("\n 0 - Sair");
		printf("\n Escolha uma das opcoes:");
		scanf("%d", &opcao);
		switch(opcao)
		{
			case 1: 
			{
				lerDados(&pessoa);
				raiz = inserir(raiz, &pessoa);
				break;
			}
			case 2:	preOrdem(raiz); break;
			case 3: emOrdem(raiz); break;
			case 4: posOrdem(raiz); break;
		
			case 5:{
				char nomeBusca[30];
				int encontrou;
				printf("\n Informe o nome do usu�rio a ser consultado: ");
				fflush(stdin);
				gets(nomeBusca);
				encontrou = consultarRecursivo(raiz, nomeBusca);
				if(encontrou == 1)
				{
					printf("\n Usu�rio encontrado!");
				}else
				{
					printf("\n Usu�rio n�o encontrado!");
				}
				break;
			}
			case 6:
				{
					char nomeRemover[30];
					printf("\n Informe o nome do usu�rio que voc� deseja excluir: ");//solicitar valor
					fflush(stdin);
					gets(nomeRemover);
					raiz = remover(raiz, nomeRemover);//chamar a funcao remover passando os parametros
				}
		}
	}while(opcao != 0);
}
