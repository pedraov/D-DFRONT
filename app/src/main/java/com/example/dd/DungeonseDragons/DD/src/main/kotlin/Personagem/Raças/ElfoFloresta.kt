package Personagem.Raças

import Personagem.CriarPersonagem

class ElfoFloresta : Raça{
    override fun bonusRaca(p: CriarPersonagem) {
        p.destreza += 2
        p.sabedoria += 1
        println("\nBônus de raça aplicado!\nDestreza + 2 e Sabedoria + 1.")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "ELFO DA FLORESTA"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}