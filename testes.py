import random

def rolard6(n):
    resultados = []
    for i in range(n):
        rolagem = random.randint(1, 6)
        resultados.append(rolagem)
    return resultados

class Criatura:
    def _init_(self, nome, pv, pd, pa):
        self.nome = nome
        self.pv = pv
        self.pd = pd
        self.pa = pa

zumbi = Criatura("Zumbi", 5, 2, 2)
aventureiro = Criatura("Aventureiro", sum(rolard6(2)), 7, 2)
print(aventureiro.pv)

def atacar(entidade, alvo):
    rolagemAtaque = sum(rolard6(entidade.pa))
    print(rolagemAtaque)
    if rolagemAtaque > alvo.pd:
        dano = rolagemAtaque - alvo.pd
        print(f"Você causou {dano} de dano no alvo.")
        
while True:
    
    print("Fim do combate")
    break

inimigo = zumbi
print(atacar(zumbi, zumbi))