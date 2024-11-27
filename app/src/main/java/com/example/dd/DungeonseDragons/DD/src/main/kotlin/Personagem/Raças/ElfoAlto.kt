package Personagem.Raças

import Personagem.CriarPersonagem

class ElfoAlto : Raça {
    override fun bonusRaca(p: CriarPersonagem) {
        p.destreza += 2
        p.inteligencia += 1
        println("\nBônus de raça aplicado!\nDestreza + 2 e Inteligência + 1.")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "ELFO ALTO"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}