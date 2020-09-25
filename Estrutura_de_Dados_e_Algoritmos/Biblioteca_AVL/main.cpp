//Gerenciador de livro de uma biblioteca

#include <iostream>

using namespace std;

struct Livro {
    int isbn;
    string titulo;
    string autor;
    bool disponivel;
    int eq;
    Livro * esq;
    Livro * dir;
};

// AVL
int altura(Livro * raiz);
void rotacao_direita(Livro *& raiz);
void rotacao_esquerda(Livro *& raiz);
// Adicionar
void adicionar(Livro *& raiz, int isbn, string titulo, string autor);
// Remover
Livro * acharMenor(Livro *& raiz);
void remover(Livro *& raiz, int isbn);
// Buscar
Livro * buscar(Livro * raiz, int isbn);
// Emprestar
void emprestar(Livro *& raiz, int isbn);
// Devolver
void devolver(Livro *& raiz, int isbn);
// Exibir
void preOrdem(Livro * raiz);
void emOrdem(Livro * raiz);
void posOrdem(Livro * raiz);

int main() {

    Livro * raiz = NULL;
    Livro * aux = NULL;

    int op, isbn;
    string titulo, autor;

    do {
        cout << "\tMenu" << endl << endl;
        cout << "1. Cadastrar" << endl;
        cout << "2. Remover" << endl;
        cout << "3. Buscar" << endl;
        cout << "4. Emprestar" << endl;
        cout << "5. Devolver" << endl;
        cout << "6. Exibir" << endl;
        cout << "0. Sair" << endl;
        cout << endl <<  "Opcao: ";
        cin >> op;
        cout << endl << "####################" << endl << endl;

        if(op == 1) {
            cout << "\tCadastrar" << endl << endl;
            cout << "ISBN: ";
            cin >> isbn;
            cout << "Titulo: ";
            cin >> titulo;
            cout << "Autor: ";
            cin >> autor;
            adicionar(raiz, isbn, titulo, autor);
            cout << endl << "####################" << endl << endl;
        } else if(op == 2) {
            cout << "\tRemover" << endl << endl;
            cout << "ISBN: ";
            cin >> isbn;
            remover(raiz, isbn);
            cout << endl << "####################" << endl << endl;
        } else if(op == 3) {
            cout << "\tBuscar" << endl << endl;
            cout << "ISBN: ";
            cin >> isbn;
            aux = buscar(raiz, isbn);
            if(aux != NULL) {
                cout << endl << "ISBN: " << aux->isbn << endl;
                cout << "Titulo: " << aux->titulo << endl;
                cout << "Autor: " << aux->autor << endl;
                cout << "Fator de Equilibrio: " << aux->eq << endl;
                if(aux->disponivel)
                    cout << "Disponivel: Sim" << endl;
                else
                    cout << "Disponivel: Nao" << endl;
            } else
                cout << "Erro ao buscar" << endl;
            cout << endl << "####################" << endl << endl;
        } else if(op == 4) {
            cout << "\tEmprestar" << endl << endl;
            cout << "ISBN: ";
            cin >> isbn;
            emprestar(raiz, isbn);
            cout << endl << "####################" << endl << endl;
        } else if(op == 5) {
            cout << "\tDevolver" << endl << endl;
            cout << "ISBN: ";
            cin >> isbn;
            devolver(raiz, isbn);
            cout << endl << "####################" << endl << endl;
        } else if(op == 6) {
            cout << "\nExibir" << endl << endl;
            cout << "Pre-Ordem: ";
            preOrdem(raiz);
            cout << "\nEm Ordem: ";
            emOrdem(raiz);
            cout << "\nPos-Ordem: ";
            posOrdem(raiz);
            cout << endl << endl << "####################" << endl << endl;
        } else if(op == 0) {
            cout << "Saindo...";
        } else {
            cout << "Opcao Invalida!" << endl;
            cout << endl << "####################" << endl << endl;
        }
    } while(op!=0);

}

// AVL
int altura(Livro * raiz) {
    if(raiz == NULL)
        return -1;
    else {
        int altura_esq = altura(raiz->esq);
        int altura_dir = altura(raiz->dir);
        if(altura_esq > altura_dir)
            return 1+altura_esq;
        return 1+altura_dir;
    }
}

void rotacao_direita(Livro *& raiz) {
    Livro *q, *temp;
    q = raiz->esq;
    temp = q->dir;
    q->dir = raiz;
    raiz->esq = temp;
    q->eq = altura(q->dir)-altura(q->esq);
    raiz->eq = altura(raiz->dir)-altura(raiz->esq);
    raiz = q;
}

void rotacao_esquerda(Livro *& raiz) {
    Livro *q, *temp;
    q = raiz->dir;
    temp = q->esq;
    q->esq = raiz;
    raiz->dir = temp;
    q->eq = altura(q->dir)-altura(q->esq);
    raiz->eq = altura(raiz->dir)-altura(raiz->esq);
    raiz = q;
}

// Cadastrar
void adicionar(Livro *& raiz, int isbn, string titulo, string autor) {
    if(raiz == NULL) {
        raiz = new Livro;
        raiz->isbn = isbn;
        raiz->titulo = titulo;
        raiz->autor = autor;
        raiz->disponivel = true;
        raiz->esq = NULL;
        raiz->dir = NULL;
        raiz->eq = altura(raiz->dir)-altura(raiz->esq);
    } else {
        if(isbn < raiz->isbn)
            adicionar(raiz->esq, isbn, titulo, autor);
        else if (isbn > raiz->isbn)
            adicionar(raiz->dir, isbn, titulo, autor);

        raiz->eq = altura(raiz->dir)-altura(raiz->esq);
        if(raiz->eq == -2 && raiz->esq->eq == -1) {
            rotacao_direita(raiz);
        } else if(raiz->eq == -2 && raiz->esq->eq == 1) {
            rotacao_esquerda(raiz->esq);
            rotacao_direita(raiz);
        } else if(raiz->eq == 2 && raiz->dir->eq == 1) {
            rotacao_esquerda(raiz);
        } else if(raiz->eq == 2 && raiz->dir->eq == -1) {
            rotacao_direita(raiz->dir);
            rotacao_esquerda(raiz);
        }
    }
}

// Remover
Livro * acharMenor(Livro *& raiz) {
    if(raiz->esq == NULL) {
        Livro * aux = raiz;
        raiz = raiz->dir;
        return aux;
    } else
        return acharMenor(raiz->esq);
}

void remover(Livro *& raiz, int isbn) {
    if(raiz != NULL) {
        if(isbn < raiz->isbn)
            remover(raiz->esq, isbn);
        else if(isbn > raiz->isbn)
            remover(raiz->dir, isbn);
        else if(isbn == raiz->isbn) {
            if(raiz->esq == NULL && raiz->dir == NULL) {
                delete raiz;
                raiz = NULL;
            } else if(raiz->esq != NULL && raiz->dir == NULL) {
                Livro * aux = raiz;
                raiz = raiz->esq;
                delete aux;
            } else if(raiz->esq == NULL && raiz->dir != NULL) {
                Livro * aux = raiz;
                raiz = raiz->dir;
                delete aux;
            } else if(raiz->esq != NULL && raiz->dir != NULL) {
                Livro * aux = acharMenor(raiz->dir);
                raiz->isbn = aux->isbn;
                raiz->titulo = aux->titulo;
                raiz->autor = aux->autor;
                raiz->disponivel = aux->disponivel;
                delete aux;
            }
        }
        if(raiz != NULL) {
            raiz->eq = altura(raiz->dir)-altura(raiz->esq);
            if(raiz->eq == -2 && raiz->esq->eq == -1) {
                rotacao_direita(raiz);
            } else if(raiz->eq == -2 && raiz->esq->eq == 1) {
                rotacao_esquerda(raiz->esq);
                rotacao_direita(raiz);
            } else if(raiz->eq == 2 && raiz->dir->eq == 1) {
                rotacao_esquerda(raiz);
            } else if(raiz->eq == 2 && raiz->dir->eq == -1) {
                rotacao_direita(raiz->dir);
                rotacao_esquerda(raiz);
            }
        }
    }
}

// Buscar
Livro * buscar(Livro * raiz, int isbn) {
    if(raiz != NULL) {
        if(isbn < raiz->isbn)
            return buscar(raiz->esq, isbn);
        else if(isbn > raiz->isbn)
            return buscar(raiz->dir, isbn);
        else
            return raiz;
    } else
        return NULL;
}

// Emprestar
void emprestar(Livro *& raiz, int isbn) {
    if(raiz != NULL) {
        Livro * aux = buscar(raiz, isbn);
        if(aux->disponivel)
            aux->disponivel = false;
    }
}

// Devolver
void devolver(Livro *& raiz, int isbn) {
    if(raiz != NULL) {
        Livro * aux = buscar(raiz, isbn);
        if(!aux->disponivel)
            aux->disponivel = true;
    }
}

// Exibir
void preOrdem(Livro * raiz) {
    if(raiz != NULL) {
        cout << raiz->isbn << " - ";
        preOrdem(raiz->esq);
        preOrdem(raiz->dir);
    }
}

void emOrdem(Livro * raiz) {
    if(raiz != NULL) {
        emOrdem(raiz->esq);
        cout << raiz->isbn << " - ";
        emOrdem(raiz->dir);
    }
}

void posOrdem(Livro * raiz) {
    if(raiz != NULL) {
        posOrdem(raiz->esq);
        posOrdem(raiz->dir);
        cout << raiz->isbn << " - ";
    }
}
