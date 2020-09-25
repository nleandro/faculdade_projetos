#Problema: https://www.urionlinejudge.com.br/judge/pt/problems/view/1088

trocas = 0


def bubbleshort(vetor):
    global trocas

    for j in range(1, len(vetor) - 1):
        for i in range(1, len(vetor) - 1):
            if vetor[i] > vetor[i + 1]:
                aux = vetor[i]
                vetor[i] = vetor[i + 1]
                vetor[i + 1] = aux
                trocas += 1


print("Digite uma sequência de números separado por espaço: ")
vetor = [int(n) for n in input().split()]

bubbleshort(vetor)

print("Marcelo" if trocas % 2 != 0 else "Carlos")
