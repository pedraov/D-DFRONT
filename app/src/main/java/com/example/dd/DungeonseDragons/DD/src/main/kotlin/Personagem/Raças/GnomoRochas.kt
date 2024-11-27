package Personagem.Raças

import Personagem.CriarPersonagem

class GnomoRochas : Raça {
    override fun bonusRaca(p: CriarPersonagem) {
        p.constituicao += 1
        p.inteligencia += 2
        println("\nBônus de classe aplicado!\nConstiuição + 1 e Inteligência + 2.")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "GNOMO DAS ROCHAS"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}