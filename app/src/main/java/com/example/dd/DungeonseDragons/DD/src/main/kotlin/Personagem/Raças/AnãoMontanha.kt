package Personagem.Raças

import Personagem.CriarPersonagem

class AnãoMontanha : Raça{
    override fun bonusRaca(p: CriarPersonagem) {
        p.forca += 2
        p.constituicao += 2
        println("\nBônus de raça aplicado!\nForça + 2 e Constituição + 2.")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "ANÃO DA MONTANHA"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}