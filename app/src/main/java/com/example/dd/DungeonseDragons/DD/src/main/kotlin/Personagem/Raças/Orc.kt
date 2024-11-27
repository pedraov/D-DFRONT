package Personagem.Raças

import Personagem.CriarPersonagem

class Orc : Raça{
    override fun bonusRaca(p: CriarPersonagem) {
            p.forca += 2
            p.constituicao += 2
            println("\nBônus de classe aplicado!\nForça + 2 e Constiuição + 1.")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "MEIO ORC"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}