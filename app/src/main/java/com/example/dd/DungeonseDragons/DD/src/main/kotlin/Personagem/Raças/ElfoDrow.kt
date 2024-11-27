package Personagem.Raças

import Personagem.CriarPersonagem

class ElfoDrow : Raça{
    override fun bonusRaca(p: CriarPersonagem) {
        p.destreza += 2
        p.carisma += 1
        println("\nBônus de raça aplicado!\nDestreza + 2, Carisma + 1.")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "ELFO DROW"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}