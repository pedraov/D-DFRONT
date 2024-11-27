package Personagem.Raças

import Personagem.CriarPersonagem

class AnãoColina : Raça{
    override fun bonusRaca(p: CriarPersonagem) {
        p.constituicao += 2
        p.sabedoria += 1
        println("\nBônus de raça aplicado!\nConstiuição + 2 e sabedoria + 1")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "ANÃO DA COLINA"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}