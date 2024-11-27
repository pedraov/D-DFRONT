package Personagem.Raças

import Personagem.CriarPersonagem

class GnomoFloresta : Raça {
    override fun bonusRaca(p: CriarPersonagem) {
        p.destreza += 1
        p.inteligencia += 2
        println("\nBônus de raça aplicado!\nDestreza + 1 e Inteligência + 2.")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "GNOMO DA FLORESTA"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}