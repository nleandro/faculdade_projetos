#include <iostream>

using namespace std;

struct noArvore {
    string dado;
    noArvore * esq;
    noArvore * dir;
};

noArvore * cria_no(string dado) {
    noArvore * novo = new noArvore;
    novo -> dado = dado;
    novo -> esq = NULL;
    novo -> dir = NULL;
    return novo;
}

noArvore * busca(noArvore *& raiz, string dado) {
    if(raiz != NULL) {
        if(raiz -> dado == dado) {
            return raiz;
        }
        noArvore * nesq = busca(raiz -> esq, dado);
        if (nesq != NULL) {
            return nesq;
        }
        return busca(raiz -> dir, dado);
    }
    return NULL;
}

void adicionar(noArvore *& raiz, string pai, string dado, char filho) {
    noArvore * noPai = busca(raiz, pai);
    if(noPai != NULL) {
        if(filho == 'n' || filho == 'N') {
            noPai -> esq = cria_no(dado);
        } else {
            noPai -> dir = cria_no(dado);
        }
    }
}

void pre_ordem(noArvore * raiz) {
    if(raiz != NULL) {
        cout << raiz -> dado << " - ";
        pre_ordem(raiz -> esq);
        pre_ordem(raiz -> dir);
    }
}

void em_ordem(noArvore * raiz) {
    if(raiz != NULL) {
        em_ordem(raiz -> esq);
        cout << raiz -> dado << " - ";
        em_ordem(raiz -> dir);
    }
}

void pos_ordem(noArvore * raiz) {
    if(raiz != NULL) {
        pos_ordem(raiz -> esq);
        pos_ordem(raiz -> dir);
        cout << raiz -> dado << " - ";
    }
}

void jogo(noArvore * raiz){
    if(raiz != NULL) {
        if(raiz -> esq == NULL && raiz -> dir == NULL) {
            cout << "Voce pensou em " << raiz -> dado;
            return;
        }
        char resp;
        cout << raiz -> dado << "(S/N): ";
        cin >> resp;
        if(resp == 'S' || resp == 's') {
            jogo(raiz->dir);
        } else {
            jogo(raiz->esq);
        }
    }
}

int main() {
    noArvore * raiz = cria_no("O numero e par?");
    adicionar(raiz, "O numero e par?", "E divisivel por 3?", 'N');
    adicionar(raiz, "E divisivel por 3?", "Qualquer numero multiplicado por ele mesmo dar ele mesmo?", 'N');
    adicionar(raiz, "Qualquer numero multiplicado por ele mesmo dar ele mesmo?", "E maior que 6?", 'N');
    adicionar(raiz, "Qualquer numero multiplicado por ele mesmo dar ele mesmo?", "1", 'S');
    adicionar(raiz, "E maior que 6?", "5", 'N');
    adicionar(raiz, "E maior que 6?", "7", 'S');
    adicionar(raiz, "E divisivel por 3?", "E primo??", 'S');
    adicionar(raiz, "E primo??", "9", 'N');
    adicionar(raiz, "E primo??", "3", 'S');
    adicionar(raiz, "O numero e par?", "E divisivel por 5?", 'S');
    adicionar(raiz, "E divisivel por 5?", "E primo?", 'N');
    adicionar(raiz, "E primo?", "Qualquer numero e multiplicado por ele dar 0?", 'N');
    adicionar(raiz, "Qualquer numero e multiplicado por ele dar 0?", "6", 'N');
    adicionar(raiz, "Qualquer numero e multiplicado por ele dar 0?", "0", 'S');
    adicionar(raiz, "E primo?", "2", 'S');
    adicionar(raiz, "E divisivel por 5?", "E maior que 5?", 'S');
    adicionar(raiz, "E maior que 5?", "4", 'N');
    adicionar(raiz, "E maior que 5?", "8", 'S');

    cout << "Pense em um numero e responda:\n";
    jogo(raiz);
}
