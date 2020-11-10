<<<<<<< HEAD
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <locale.h>
#include <time.h>


typedef struct tipoElemento{
	char caracter;
	struct tipoElemento *proximo;
}TE;

typedef struct tipoLista{
	TE *inicio;
	TE *fim;
}TL;

typedef struct tipoPessoa{
	int id;
	char nomeCompleto[70];
	char dataNascimento[11];
	char pais[30];
	char sal[21];
	char hash[40];
	char email[40];
	char tipoUsuario[20];
}TP;

TL tabelaHashing[10];

void inicializar ()
{
	int i = 0;
	for (i = 0; i < 10; i++)
	{
		tabelaHashing[i].inicio = NULL;
		tabelaHashing[i].fim = NULL;
	}
}

int hash (int valor)
{
	return valor % 10;
}

void apresentar ()
{
	int i;
	
	for (i = 0; i < 10; i++) //para percorrer a tabela hashing
	{
		TE *aux;
		aux = tabelaHashing[i].inicio;
		if (aux != NULL)
		{
			printf("\n Indice: %d - ", i);
			while (aux != NULL) //para percorrer as listas encadeadas
			{
				printf("%c | ", aux->caracter);
				aux = aux->proximo;
			}
		}
		else
		{
			printf("\n Indice: %d -  ", i);
		}
	}
}

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
		if((strcmp(novaPessoa->email, raiz->pessoa.email)) < 0)
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
	srand(time(NULL));
	novaPessoa->id = idPessoa;
	char senhaCadastro[40];
	
	printf("\n Informe o nome completo do novo usuário: ");
	fflush(stdin);
	gets(novaPessoa->nomeCompleto);
	
	printf("\n Informe o email do novo usuário: ");
	fflush(stdin);
	gets(novaPessoa->email);
	
	printf("\n Informe a data de nascimento do novo usuário (DD/MM/AAAA): ");
	fflush(stdin);
	gets(novaPessoa->dataNascimento);
	
	printf("\n Informe o país que o novo usuário reside: ");
	fflush(stdin);
	gets(novaPessoa->pais);
	
	int opcao;
	do{
		printf("\n Qual será o tipo de usuário.");
		printf("\n 1 - Administrador");
		printf("\n 2 - Professor");
		printf("\n 3 - Visitante");
		printf("\n Escolha um tipo: ");
		fflush(stdin);
		scanf("%d", &opcao);
		switch(opcao){
			case 1: strcpy(novaPessoa->tipoUsuario, "Administrador"); break;
			case 2: strcpy(novaPessoa->tipoUsuario, "Professor"); break;
			case 3: strcpy(novaPessoa->tipoUsuario, "Visitante"); break;
		}
	}while(opcao < 1 || opcao > 3);
	
	int i;
	for(i = 0; i < 20 ; i++){//criar aleatoriamente um sal para o usuário
		novaPessoa->sal[i] = '!' + (char)(rand()%93);
	}
	novaPessoa->sal[i] = '\0';
	
	
	printf("\n Digite uma senha para %s:", novaPessoa->email);
	fflush(stdin);
	gets(senhaCadastro);

	strcat(senhaCadastro, novaPessoa->sal);
	
	int k, indice = 0;
	
	for (k = 0; k < strlen(senhaCadastro); k++)//espalhar na tabela hashing
	{
		TE *novoCaracter;
		novoCaracter = new TE;
		
		novoCaracter->caracter = senhaCadastro[k];
		novoCaracter->proximo = NULL;
		
		indice = hash(senhaCadastro[k]);
		
		if (tabelaHashing[indice].inicio == NULL)
		{
			tabelaHashing[indice].inicio = novoCaracter;
			tabelaHashing[indice].fim = novoCaracter;
		}
		else
		{
			tabelaHashing[indice].fim->proximo = novoCaracter;
			tabelaHashing[indice].fim = novoCaracter;
		}
	}
	int j;
	
	for (i = 0; i < 10; i++)//atribuir para a senha criptografada(hash) do novo usuário
	{
		TE *aux;
		aux = tabelaHashing[i].inicio;
		while (aux != NULL)
		{
			novaPessoa->hash[j] = aux->caracter;
			j++;
			aux = aux->proximo;
		}
		novaPessoa->sal[20] = '\0';
	}
	novaPessoa->hash[j] = '\0';
}

int consultarRecursivo(TN *auxRaiz, char nomeBusca[30])
{
	if(auxRaiz == NULL)
	{
		return 0;
	}else
	{
		if(strcmp(auxRaiz->pessoa.email, nomeBusca) == 0)
		{
			return 1;
		}else
		{
			if(strcmp(auxRaiz->pessoa.email, nomeBusca) > 0)
			{
				return consultarRecursivo(auxRaiz->esq, nomeBusca);
			}else
			{
				return consultarRecursivo(auxRaiz->dir, nomeBusca);
			}
		}
	}
} 

TN* consultarLoginRecursivo(TN *auxRaiz, char nomeBusca[40])
{
	
	if(auxRaiz == NULL)
	{
		return auxRaiz;
	}else
	{
		if(strcmp(auxRaiz->pessoa.email, nomeBusca) == 0)
		{
			return auxRaiz;
		}else
		{
			if(strcmp(auxRaiz->pessoa.email, nomeBusca) > 0)
			{
				return consultarLoginRecursivo(auxRaiz->esq, nomeBusca);
			}else
			{
				return consultarLoginRecursivo(auxRaiz->dir, nomeBusca);
			}
		}
	}
}

void validarLogin(TN *aux, char loginInformado[40], char senhaInformada[40]){
	
	strcat(senhaInformada, aux->pessoa.sal);
	
	inicializar();
	int indice, j;

	for (j = 0; j < strlen(senhaInformada); j++)//espalhar na tabela hashing
	{
		TE *novoCaracter;
		novoCaracter = new TE;
		
		novoCaracter->caracter = senhaInformada[j];
		novoCaracter->proximo = NULL;
		
		indice = hash(senhaInformada[j]);
		
		if (tabelaHashing[indice].inicio == NULL)
		{
			tabelaHashing[indice].inicio = novoCaracter;
			tabelaHashing[indice].fim = novoCaracter;
		}
		else
		{
			tabelaHashing[indice].fim->proximo = novoCaracter;
			tabelaHashing[indice].fim = novoCaracter;
		}
	}
	
	int q, k = 0;
	
	char hashDaSenhaInformada[40];
	
	for(q = 0; q < 10; q++){
		TE *aux1;
		aux1 = tabelaHashing[q].inicio;
		while(aux1 != NULL){
			hashDaSenhaInformada[k] = aux1->caracter;
			k++;
			aux1 = aux1->proximo;
		}
	}
	hashDaSenhaInformada[k] = '\0';
	
	if((strcmp(hashDaSenhaInformada, aux->pessoa.hash) == 0) && strcmp(loginInformado, aux->pessoa.email) == 0){
		printf("\n Login feito com sucesso!");
		printf("\n Seja bem vindo(a) %s", aux->pessoa.nomeCompleto);
	}else{
		printf("\n Não foi possível efetuar o login.");
	}
	getch();
}

void logar(TN *usuario){
	
	char senhaInformada[40];

	printf("\n Informe a senha: ");
	fflush(stdin);
	gets(senhaInformada);
	
	validarLogin(usuario, usuario->pessoa.email, senhaInformada);
	
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
		printf("\n Tipo de usuário: %s", raiz->pessoa.tipoUsuario);
		printf("\n Sal: %s", raiz->pessoa.sal);
		printf("\n Hash: %s", raiz->pessoa.hash);
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
		printf("\n Tipo de usuário: %s", raiz->pessoa.tipoUsuario);
		printf("\n Sal: %s", raiz->pessoa.sal);
		printf("\n Hash: %s  %d", raiz->pessoa.hash);
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
		printf("\n Tipo de usuário: %s", raiz->pessoa.tipoUsuario);
		printf("\n Sal: %s", raiz->pessoa.sal);
		printf("\n Hash: %s", raiz->pessoa.hash);
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
		if(strcmp(atual->pessoa.email, nomeRemover) == 0)
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
								strcpy(atual->pessoa.email, aux_atual->pessoa.email);
								aux_ante->dir = aux_atual->esq;
							}
						}
					}
				}
			}
			else
			{
				if(strcmp(atual->pessoa.email, anterior->pessoa.email) > 0)
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
					if(strcmp(atual->pessoa.email, anterior->pessoa.email) < 0)
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
							strcpy(atual->pessoa.email, aux_atual->pessoa.email);
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
			if(strcmp(nomeRemover, atual->pessoa.email) < 0)
			{
				anterior = atual;
				atual = atual->esq;
			}
			else
			{
				if(strcmp(nomeRemover, atual->pessoa.email) > 0)
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
		printf("\n %s foi removido(a) com sucesso!", atual->pessoa.email);
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
		printf("\n 7 - Login do usuário");
		printf("\n 9 - Limpar tela.");
		printf("\n 0 - Sair");
		printf("\n Escolha uma das opcoes:");
		scanf("%d", &opcao);
		switch(opcao)
		{
			case 1: 
			{
				inicializar();
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
				printf("\n Informe o email do usuário a ser consultado: ");
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
				printf("\n Informe o email do usuário que você deseja excluir: ");
				fflush(stdin);
				gets(nomeRemover);
				raiz = remover(raiz, nomeRemover);
				break;
				}
			case 7:
				{
					char loginUsuario[40];
					printf("\n Informe o email do usuário: ");
					fflush(stdin);
					gets(loginUsuario);
					raiz = consultarLoginRecursivo(raiz, loginUsuario);
					if(raiz != NULL){
						logar(raiz);
					}else
					{
						printf("\n Usuário não encontrado!");
					}
					break;
				}
			case 9: system("cls"); break;
		}
	}while(opcao != 0);
}

=======
#include <stdio.h>
#include <stdlib.h>
#include <conio.h>
#include <string.h>
#include <locale.h>
#include <time.h>


typedef struct tipoElemento{
	char caracter;
	struct tipoElemento *proximo;
}TE;

typedef struct tipoLista{
	TE *inicio;
	TE *fim;
}TL;

typedef struct tipoPessoa{
	int id;
	char nomeCompleto[70];
	char dataNascimento[11];
	char pais[30];
	char sal[21];
	char hash[40];
	char email[40];
}TP;

TL tabelaHashing[10];

void inicializar ()
{
	int i = 0;
	for (i = 0; i < 10; i++)
	{
		tabelaHashing[i].inicio = NULL;
		tabelaHashing[i].fim = NULL;
	}
}

int hash (int valor)
{
	return valor % 10;
}

void apresentar ()
{
	int i;
	
	for (i = 0; i < 10; i++) //para percorrer a tabela hashing
	{
		TE *aux;
		aux = tabelaHashing[i].inicio;
		if (aux != NULL)
		{
			printf("\n Indice: %d - ", i);
			while (aux != NULL) //para percorrer as listas encadeadas
			{
				printf("%c | ", aux->caracter);
				aux = aux->proximo;
			}
		}
		else
		{
			printf("\n Indice: %d -  ", i);
		}
	}
}

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
	srand(time(NULL));
	novaPessoa->id = idPessoa;
	char senhaCadastro[40];
	
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
	int i;
	for(i = 0; i < 20 ; i++){//criar aleatoriamente um sal para o usuário
		novaPessoa->sal[i] = '!' + (char)(rand()%93);
	}
	novaPessoa->sal[i] = '\0';
	
	
	printf("\n Digite uma senha para %s:", novaPessoa->nomeCompleto);
	fflush(stdin);
	gets(senhaCadastro);

	strcat(senhaCadastro, novaPessoa->sal);
	
	int k, indice = 0;
	
	for (k = 0; k < strlen(senhaCadastro); k++)//espalhar na tabela hashing
	{
		TE *novoCaracter;
		novoCaracter = new TE;
		
		novoCaracter->caracter = senhaCadastro[k];
		novoCaracter->proximo = NULL;
		
		indice = hash(senhaCadastro[k]);
		
		if (tabelaHashing[indice].inicio == NULL)
		{
			tabelaHashing[indice].inicio = novoCaracter;
			tabelaHashing[indice].fim = novoCaracter;
		}
		else
		{
			tabelaHashing[indice].fim->proximo = novoCaracter;
			tabelaHashing[indice].fim = novoCaracter;
		}
	}
	int j;
	
	for (i = 0; i < 10; i++)//atribuir para a senha criptografada(hash) do novo usuário
	{
		TE *aux;
		aux = tabelaHashing[i].inicio;
		while (aux != NULL)
		{
			novaPessoa->hash[j] = aux->caracter;
			j++;
			aux = aux->proximo;
		}
		novaPessoa->sal[20] = '\0';
	}
	novaPessoa->hash[j] = '\0';
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

TN* consultarLoginRecursivo(TN *auxRaiz, char nomeBusca[40])
{
	
	if(auxRaiz == NULL)
	{
		return auxRaiz;
	}else
	{
		if(strcmp(auxRaiz->pessoa.nomeCompleto, nomeBusca) == 0)
		{
			return auxRaiz;
		}else
		{
			if(strcmp(auxRaiz->pessoa.nomeCompleto, nomeBusca) > 0)
			{
				return consultarLoginRecursivo(auxRaiz->esq, nomeBusca);
			}else
			{
				return consultarLoginRecursivo(auxRaiz->dir, nomeBusca);
			}
		}
	}
}

void validarLogin(TN *aux, char loginInformado[40], char senhaInformada[40]){
	
	strcat(senhaInformada, aux->pessoa.sal);
	
	inicializar();
	int indice, j;

	for (j = 0; j < strlen(senhaInformada); j++)//espalhar na tabela hashing
	{
		TE *novoCaracter;
		novoCaracter = new TE;
		
		novoCaracter->caracter = senhaInformada[j];
		novoCaracter->proximo = NULL;
		
		indice = hash(senhaInformada[j]);
		
		if (tabelaHashing[indice].inicio == NULL)
		{
			tabelaHashing[indice].inicio = novoCaracter;
			tabelaHashing[indice].fim = novoCaracter;
		}
		else
		{
			tabelaHashing[indice].fim->proximo = novoCaracter;
			tabelaHashing[indice].fim = novoCaracter;
		}
	}
	
	int q, k = 0;
	
	char hashDaSenhaInformada[40];
	
	for(q = 0; q < 10; q++){
		TE *aux1;
		aux1 = tabelaHashing[q].inicio;
		while(aux1 != NULL){
			hashDaSenhaInformada[k] = aux1->caracter;
			k++;
			aux1 = aux1->proximo;
		}
	}
	hashDaSenhaInformada[k] = '\0';
	
	if((strcmp(hashDaSenhaInformada, aux->pessoa.hash) == 0) && strcmp(loginInformado, aux->pessoa.email) == 0){
		printf("\n Login feito com sucesso!");
		printf("\n Seja bem vindo(a) %s", aux->pessoa.nomeCompleto);
	}else{
		printf("\n Não foi possível efetuar o login.");
	}
	getch();
}

void logar(TN *usuario){
	
	char loginInformado[40];
	char senhaInformada[40];
	
	printf("\n Informe o login: ");
	fflush(stdin);
	gets(loginInformado);
	
	printf("\n Informe a senha: ");
	fflush(stdin);
	gets(senhaInformada);
	
	validarLogin(usuario, loginInformado, senhaInformada);
	
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
		printf("\n Sal: %s", raiz->pessoa.sal);
		printf("\n Hash: %s", raiz->pessoa.hash);
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
		printf("\n Sal: %s", raiz->pessoa.sal);
		printf("\n Hash: %s  %d", raiz->pessoa.hash);
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
		printf("\n Sal: %s", raiz->pessoa.sal);
		printf("\n Hash: %s", raiz->pessoa.hash);
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
		printf("\n 7 - Login do usuário");
		printf("\n 9 - Limpar tela.");
		printf("\n 0 - Sair");
		printf("\n Escolha uma das opcoes:");
		scanf("%d", &opcao);
		switch(opcao)
		{
			case 1: 
			{
				inicializar();
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
				break;
				}
			case 7:
				{
					char loginUsuario[40];
					printf("\n Informe o nome completo do usuário que fará o login: ");
					fflush(stdin);
					gets(loginUsuario);
					raiz = consultarLoginRecursivo(raiz, loginUsuario);
					if(raiz != NULL){
						logar(raiz);
					}else
					{
						printf("\n Usuário nao encontrado!");
					}
					break;
				}
			case 9: system("cls"); break;
		}
	}while(opcao != 0);
}

>>>>>>> a9b6e1aabd76e35c878d8a9161834ba52b17917f
