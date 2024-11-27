package Personagem.Raças

import Personagem.CriarPersonagem

class HalflingRobusto : Raça{
    override fun bonusRaca(p: CriarPersonagem) {
        p.destreza += 2
        p.constituicao += 1
        println("\nBônus de classe aplicado!\nDestreza + 2 e Constiuição + 1.")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "HALFLING ROBUSTO"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}