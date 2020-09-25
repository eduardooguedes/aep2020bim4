#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <locale.h>

typedef struct tipoPessoa{
	int id;
	char nomeCompleto[70];
	char dataNascimento[11];
	char pais[30];
	char senha[40];
	char email[40];
	
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
		if((strcmp(novaPessoa->nomeCompleto, raiz->pessoa.nomeCompleto)) < 0)
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

void lerDados(TP *novaPessoa, int idPessoa)
{
	
	
	novaPessoa->id = idPessoa;
	
	printf("\n Informe o nome completo do novo usuário: ");
	fflush(stdin);
	gets(novaPessoa->nomeCompleto);
	
	printf("\n Informe a data de nascimento do novo usuário (DD/MM/AAAA): ");
	fflush(stdin);
	gets(novaPessoa->dataNascimento);
	
	printf("\n Informe o país que o novo usuário reside: ");
	fflush(stdin);
	gets(novaPessoa->pais);
	
	printf("\n Informe o email do novo usuário: ");
	fflush(stdin);
	gets(novaPessoa->email);
	
}

int consultarRecursivo(TN *auxRaiz, char nomeBusca[30])
{
	if(auxRaiz == NULL)
	{
		return 0;
	}else
	{
		if(strcmp(auxRaiz->pessoa.nomeCompleto, nomeBusca) == 0)
		{
			return 1;
		}else
		{
			if(strcmp(auxRaiz->pessoa.nomeCompleto, nomeBusca) > 0)
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
		fflush(stdin);
		printf("\n Id: %d", raiz->pessoa.id);
		printf("\n Nome completo: %s", raiz->pessoa.nomeCompleto);
		printf("\n Email: %s", raiz->pessoa.email);
		printf("\n País: %s", raiz->pessoa.pais);
		printf("\n Data de Nascimento: %s", raiz->pessoa.dataNascimento);
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
		printf("\n Nome completo: %s", raiz->pessoa.nomeCompleto);
		printf("\n Email: %s", raiz->pessoa.email);
		printf("\n País: %s", raiz->pessoa.pais);
		printf("\n Data de Nascimento: %s", raiz->pessoa.dataNascimento);
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
		printf("\n Nome completo: %s", raiz->pessoa.nomeCompleto);
		printf("\n Email: %s", raiz->pessoa.email);
		printf("\n País: %s", raiz->pessoa.pais);
		printf("\n Data de Nascimento: %s", raiz->pessoa.dataNascimento);
		printf("\n-----------------------------\n");
	}
}

TN* remover(TN *raiz, char nomeRemover[30])
{
	TN *atual, *anterior;
	atual = raiz;
	anterior = raiz;
	
	while (atual != NULL)
	{
		if(strcmp(atual->pessoa.nomeCompleto, nomeRemover) == 0)
		{
			if (atual == raiz) //se nó que será excluído estiver na raiz
			{
				if ((atual->esq == NULL) && (atual->dir == NULL)) // só um elemento na árvore
				{
					raiz = NULL;
					break;
				}
				else
				{
					if (atual->dir == NULL) //só tem sub-árvore esquerda
					{
						raiz = atual->esq;
					}
					else
					{
						if (atual->esq == NULL) //só tem sub-árvore direita
						{
							raiz = atual->dir;
						}
						else
						{
							if (atual->esq != NULL & atual->dir != NULL) //nó a ser excluído está na raiz e possui 2 sub-árvores
							{
								TN *aux_ante, *aux_atual;
								aux_ante = atual->esq;
								aux_atual = atual->esq;
								while (aux_atual->dir != NULL) //localizando o elemento mais à direita da sub-árvore esquerda
								{
									aux_ante = aux_atual;
									aux_atual = aux_atual->dir;
								}
								strcpy(atual->pessoa.nomeCompleto, aux_atual->pessoa.nomeCompleto);
								aux_ante->dir = aux_atual->esq;
							}
						}
					}
				}
			}
			else
			{
				if(strcmp(atual->pessoa.nomeCompleto, anterior->pessoa.nomeCompleto) > 0)
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
					if(strcmp(atual->pessoa.nomeCompleto, anterior->pessoa.nomeCompleto) < 0)
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
						if (atual->esq != NULL & atual->dir != NULL) //nó a ser excluído está na raiz e possui 2 sub-árvores
						{
							TN *aux_ante, *aux_atual;
							aux_ante = atual;
							aux_atual = atual->esq;
							while (aux_atual->dir != NULL) //localizando o elemento mais à direita da sub-árvore esquerda
							{
								aux_ante = aux_atual;
								aux_atual = aux_atual->dir;
							}
							strcpy(atual->pessoa.nomeCompleto, aux_atual->pessoa.nomeCompleto);
							if(aux_ante == atual)
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
			if(strcmp(nomeRemover, atual->pessoa.nomeCompleto) < 0)
			{
				anterior = atual;
				atual = atual->esq;
			}
			else
			{
				if(strcmp(nomeRemover, atual->pessoa.nomeCompleto) > 0)
				{
					anterior = atual;
					atual = atual->dir;
				}
			}
		}
		
	}
	if(atual == NULL)
	{
		printf("\n Usuário não encontrado");
	}
	else
	{
		printf("\n Usuário encontrado!");
		printf("\n %s foi removido(a) com sucesso!", atual->pessoa.nomeCompleto);
		printf("\n Pressione qualquer tecla para voltar ao menu.");
		getch();
		free(atual);
		atual = NULL;
	}
	return raiz;
}
int main(){
	setlocale(LC_ALL, "Portuguese");
	TN *raiz;
	raiz = NULL;
	
	TP pessoa;
	
	int opcao;
	int id = 1;
	
	do{
		printf("\n 1 - Inserir novo usuário.");
		printf("\n 2 - Apresentar usuários em pre-ordem.");
		printf("\n 3 - Apresentar usuários em ordem.");
		printf("\n 4 - Apresentar usuários em pos-ordem.");
		printf("\n 5 - Consultar usuário.");
		printf("\n 6 - Remover um usuário.");
		printf("\n 9 - Limpar tela.");
		printf("\n 0 - Sair");
		printf("\n Escolha uma das opcoes:");
		scanf("%d", &opcao);
		switch(opcao)
		{
			case 1: 
			{
				lerDados(&pessoa, id);
				raiz = inserir(raiz, &pessoa);
				id++;
				break;
			}
			case 2:{
				if(raiz == NULL)
				{
					printf("\n A lista de usuários está vazia!");
				}else
				{
					printf("\n LISTA DE PROFESSORES");
					preOrdem(raiz);
				}
				break;
			}
			case 3:{
				if(raiz == NULL)
				{
					printf("\n A lista de usuários está vazia!");
				}else
				{
					printf("\n LISTA DE PROFESSORES");
					emOrdem(raiz);
				}
				break;
			}
			case 4:{
				if(raiz == NULL)
				{
					printf("\n A lista de usuários está vazia!");
				}else
				{
					printf("\n LISTA DE PROFESSORES");
					posOrdem(raiz);
				}
				break;
			}
			case 5:{
				char nomeBusca[30];
				int usuarioEncontrado;
				printf("\n Informe o nome completo do usuário a ser consultado: ");
				fflush(stdin);
				gets(nomeBusca);
				usuarioEncontrado = consultarRecursivo(raiz, nomeBusca);
				if(usuarioEncontrado == 1)
				{
					printf("\n Usuário encontrado!");
				}else
				{
					printf("\n Usuário não encontrado!");
				}
				break;
			}
			case 6:
				{
					char nomeRemover[30];
					printf("\n Informe o nome completo do usuário que você deseja excluir: ");
					fflush(stdin);
					gets(nomeRemover);
					raiz = remover(raiz, nomeRemover);
				}
			case 9: system("cls"); break;
		}
	}while(opcao != 0);
}

