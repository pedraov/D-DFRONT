package Personagem.Raças

import Personagem.CriarPersonagem

class Tiefling : Raça {
    override fun bonusRaca(p: CriarPersonagem) {
        p.carisma += 2
        p.inteligencia += 1
        println("\nBônus de classe aplicado!\nCarisma + 2 e Inteligência + 1")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "TIEFLING"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}