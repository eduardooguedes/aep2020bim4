#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <locale.h>

typedef struct tipoDisciplina{
	int idDisciplina;
	char nomeDisciplina[30];
	char descricaoDisciplina[100];
	struct tipoDisciplina *prox;
}TD;

typedef struct tipoListaDisciplina{
		TD *inicio;
		TD *fim;
}TLD;

typedef struct tipoPessoa{
	int id;
	char nome[30];
	char sobrenome[40];
	TLD *listaDisciplinas;
	char dataNascimento[11];
	char pais[30];
	char senha[40];
	char email[40];
}TP;

void inicializar(TLD *p)
{
	p->inicio = NULL;
	p->fim = NULL;
}

typedef struct tipoNo{
	TP pessoa;
	struct tipoNo *esq, *dir;
}TN;

TN* inserir(TN *raiz, TP *novaPessoa)
{
	TLD *aux;
	aux = novaPessoa->listaDisciplinas;
	inicializar(aux);
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

void lerDados(TP *novaPessoa, int idPessoa)
{

	novaPessoa->id = idPessoa;
	
	printf("\n Informe o nome do novo usu�rio: ");
	fflush(stdin);
	gets(novaPessoa->nome);
	
	printf("\n Informe o sobrenome do novo usu�rio: ");
	fflush(stdin);
	gets(novaPessoa->sobrenome);
	
	printf("\n Informe a data de nascimento do novo usu�rio (DD/MM/AAAA): ");
	fflush(stdin);
	gets(novaPessoa->dataNascimento);
	
	printf("\n Informe o pa�s que o novo usu�rio reside: ");
	fflush(stdin);
	gets(novaPessoa->pais);
	
	printf("\n Informe o email do novo usu�rio: ");
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
		fflush(stdin);
		printf("\n Id: %d", raiz->pessoa.id);
		printf("\n Nome completo: %s %s", raiz->pessoa.nome, raiz->pessoa.sobrenome);
		printf("\n Email: %s", raiz->pessoa.email);
		printf("\n Pa�s: %s", raiz->pessoa.pais);
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
		printf("\n Nome completo: %s %s", raiz->pessoa.nome, raiz->pessoa.sobrenome);
		printf("\n Email: %s", raiz->pessoa.email);
		printf("\n Pa�s: %s", raiz->pessoa.pais);
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
		printf("\n Nome completo: %s %s", raiz->pessoa.nome, raiz->pessoa.sobrenome);
		printf("\n Email: %s", raiz->pessoa.email);
		printf("\n Pa�s: %s", raiz->pessoa.pais);
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
		if(strcmp(atual->pessoa.nome, nomeRemover) == 0)
		{
			if (atual == raiz) //se n� que ser� exclu�do estiver na raiz
			{
				if ((atual->esq == NULL) && (atual->dir == NULL)) // s� um elemento na �rvore
				{
					raiz = NULL;
					break;
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
								strcpy(atual->pessoa.nome, aux_atual->pessoa.nome);
								aux_ante->dir = aux_atual->esq;
							}
						}
					}
				}
			}
			else
			{
				if(strcmp(atual->pessoa.nome, anterior->pessoa.nome) > 0)
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
					if(strcmp(atual->pessoa.nome, anterior->pessoa.nome) < 0)
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
							TN *aux_ante, *aux_atual;
							aux_ante = atual;
							aux_atual = atual->esq;
							while (aux_atual->dir != NULL) //localizando o elemento mais � direita da sub-�rvore esquerda
							{
								aux_ante = aux_atual;
								aux_atual = aux_atual->dir;
							}
							strcpy(atual->pessoa.nome, aux_atual->pessoa.nome);
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
			if(strcmp(nomeRemover, atual->pessoa.nome) < 0)
			{
				anterior = atual;
				atual = atual->esq;
			}
			else
			{
				if(strcmp(nomeRemover, atual->pessoa.nome) > 0)
				{
					anterior = atual;
					atual = atual->dir;
				}
			}
		}
		
	}
	if(atual == NULL)
	{
		printf("\n Usu�rio n�o encontrado");
	}
	else
	{
		printf("\n Usu�rio encontrado!");
		printf("\n %s foi removido(a) com sucesso!", atual->pessoa.nome);
		printf("\n Pressione qualquer tecla para voltar ao menu.");
		getch();
		free(atual);
		atual = NULL;
	}
	return raiz;
}
void inserir2(int idDisciplina, char nomeDisciplina[30], char descricaoDisciplina[20], TN *raiz)
{
	TLD *aux;
	aux = raiz->pessoa.listaDisciplinas;
	
	TD *novaD;
	novaD = (TD *) malloc(sizeof(TD));
	
	
	novaD->prox = NULL;
	strcpy(novaD->nomeDisciplina, nomeDisciplina);
	strcpy(novaD->descricaoDisciplina, descricaoDisciplina);
	novaD->idDisciplina = idDisciplina;
	
	if(aux->inicio == NULL)
	{
		aux->inicio = novaD;
		aux->fim = novaD;
	}else
	{
		aux->fim->prox = novaD;
		aux->fim = novaD;
	}
	
}

bool consultarDisciplina(TLD *p, int id)
{
	TD *aux;
	aux = p->inicio;
	while(aux != NULL)
	{
		if(aux->idDisciplina == id){
			return false;
		}else{
			aux = aux->prox;
		}
	}
	return true;
}
void inserirDisciplina(TN *raiz)
{
	int opcao2;
	do{
		
		printf("\n 1 - Matem�tica");
		printf("\n 2 - F�sica");
		printf("\n 3 - Qu�mica");
		printf("\n 0 - Sair");
		printf("\n Escolha uma op��o: ");
		scanf("%d", &opcao2);
		switch(opcao2){
			case 1:{
				if(!consultarDisciplina(raiz->pessoa.listaDisciplinas, 1)){
					printf("\n Essa mat�ria j� est� inserida na lista.");
					printf("\n Pressione qualquer tecla.");
					getch();
					break;
				}
				inserir2(1,(char*)"Matem�tica",(char*)"Teste", raiz);
				break;
			}
			case 2:{
				if(!consultarDisciplina(raiz->pessoa.listaDisciplinas, 2)){
					printf("\n Essa mat�ria j� est� inserida na lista.");
					printf("\n Pressione qualquer tecla.");
					getch();
					break;
				}
				inserir2(2,(char*)"Fisica",(char*)"Teste Descri��o Fis", raiz);
				break;
			}
			case 3:{
				if(!consultarDisciplina(raiz->pessoa.listaDisciplinas, 3)){
					printf("\n Essa mat�ria j� est� inserida na lista.");
					printf("\n Pressione qualquer tecla.");
					getch();
					break;
				}
				inserir2(3,(char*)"Quimica",(char*)"Teste Descri��o Qui", raiz);
				break;
			}
		}
		system("cls");
	}while(opcao2 != 0);
}
void apresentar(TN *raiz)
{
	TLD *p;
	p = raiz->pessoa.listaDisciplinas;
	if(p->inicio == NULL)
	{
		printf("\n A lista de disciplinas desse usu�rio est� vazia!");
	}else
	{
		printf("\n Usuario: %s", raiz->pessoa.nome);
		TD *aux;
		aux = p->inicio;
		while(aux != NULL)
		{	
			
			printf("\n Id: %d - %s", aux->idDisciplina, aux->nomeDisciplina);
			printf("\n Descri��o: %s", aux->descricaoDisciplina);
			printf("\n ----------------------");
			aux = aux->prox;
		}
	}
}

void remover(TN *raiz)
{
	TLD *p;
	p = raiz->pessoa.listaDisciplinas;
	
	TD *aux, *anterior;
	aux = p->inicio;
	anterior = p->inicio;
	if(p->inicio == NULL)
	{
		printf("\n A lista de disciplinas desse usu�rio est� vazia!");
	}else
	{
		int valor;
		apresentar(raiz);
		printf("\n Escolha o id da disciplina que deseja excluir: ");
		scanf("%d", &valor);
		while(aux != NULL)
		{
			if(aux->idDisciplina == valor){
				if(aux->prox == NULL && aux == p->inicio)
				{
					free(aux);
					p->inicio = NULL;
					break;
				}
				else if(aux == p->inicio)
				{
					p->inicio = aux->prox;
					free(aux);
					break;
				}else if(aux == p->fim)
				{
					p->fim = anterior;
					anterior->prox = NULL;
					free(aux);
					break;
				}else
				{
					anterior->prox = aux->prox;
					free(aux);
					break;
				}
					printf("\n Disciplina exclu�da!\n");
			}else
			{
				anterior = aux;
				aux = aux->prox;
			}
		}

	}
}

void menuListaDisciplina(TN *raiz)
{
	int opcao1;
	do{
		
		printf("\n 1 - Adicionar disciplina no usu�rio.");
		printf("\n 2 - Visualizar disciplinas do usu�rio");
		printf("\n 3 - Remover disciplinas do usu�rio");
		printf("\n 0 - Sair");
		printf("\n Escolha uma op��o: ");
		scanf("%d", &opcao1);
		switch(opcao1){
			case 1:{
				inserirDisciplina(raiz);
				break;
			}
			case 2:{
				apresentar(raiz);
				break;
			}
			case 3:{
				remover(raiz);
				break;
			}
		}
	}while(opcao1 != 0);
}
int alterarDisciplinas(TN *raiz, int idPesquisado)
{
	if(raiz == NULL)
	{
		return 0;
	}else
	{
		if(raiz->pessoa.id == idPesquisado)
		{
			
			menuListaDisciplina(raiz);
			return 1;
		}else
		{
			if(raiz->pessoa.id > idPesquisado)
			{
				return alterarDisciplinas(raiz->esq, idPesquisado);
			}else
			{
				return alterarDisciplinas(raiz->dir, idPesquisado);
			}
		}
	}
}

int main(){
	setlocale(LC_ALL, "Portuguese");
	TN *raiz;
	raiz = NULL;
	
	TP pessoa;
	
	int opcao;
	int id = 1;
	
	do{
		printf("\n 1 - Inserir novo usu�rio");
		printf("\n 2 - Apresentar usu�rios em pre-ordem");
		printf("\n 3 - Apresentar usu�rios em ordem");
		printf("\n 4 - Apresentar usu�rios em pos-ordem");
		printf("\n 5 - Visualizar/editar lista disciplinas do professor.");
		printf("\n 6 - Consultar usu�rio");
		printf("\n 7 - Remover um usu�rio");
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
					printf("\n A lista de usu�rios est� vazia!");
				}else
				{
					preOrdem(raiz);
				}
				break;
			}
			case 3:{
				if(raiz == NULL)
				{
					printf("\n A lista de usu�rios est� vazia!");
				}else
				{
					emOrdem(raiz);
				}
				break;
			}
			case 4:{
				if(raiz == NULL)
				{
					printf("\n A lista de usu�rios est� vazia!");
				}else
				{
					posOrdem(raiz);
				}
				break;
			}
			case 5:{
				int idPesquisa = 0, encontrado;
				system("cls");
				printf("Indique o id do usu�rio: ");
				fflush(stdin);
				scanf("%d", &idPesquisa);
				encontrado = alterarDisciplinas(raiz, idPesquisa);
				if(encontrado == 1){
					printf("\n Lista de disciplinas atualizada com sucesso.");
					getch();
					system("cls");
				}else
				{
					printf("\n Id de usu�rio n�o encontrado\n\n");
					getch();
					system("cls");
				}
				break;
			}
			case 6:{
				char nomeBusca[30];
				int usuarioEncontrado;
				printf("\n Informe o nome do usu�rio a ser consultado: ");
				fflush(stdin);
				gets(nomeBusca);
				usuarioEncontrado = consultarRecursivo(raiz, nomeBusca);
				if(usuarioEncontrado == 1)
				{
					printf("\n Usu�rio encontrado!");
				}else
				{
					printf("\n Usu�rio n�o encontrado!");
				}
				break;
			}
			case 7:
				{
					char nomeRemover[30];
					printf("\n Informe o nome do usu�rio que voc� deseja excluir: ");
					fflush(stdin);
					gets(nomeRemover);
					raiz = remover(raiz, nomeRemover);
				}
			case 8: system("cls"); break;
		}
	}while(opcao != 0);
}

