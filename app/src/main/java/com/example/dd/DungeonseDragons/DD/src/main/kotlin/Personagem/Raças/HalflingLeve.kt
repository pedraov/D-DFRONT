package Personagem.Raças

import Personagem.CriarPersonagem

class HalflingLeve : Raça {
    override fun bonusRaca(p: CriarPersonagem) {
        p.destreza += 2
        p.carisma += 1
        print("\n" +
                "Bônus de classe aplicado!\n" +
                "Carisma + 1 e Destreza + 2")
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "HALFLING LEVE"
        print("\nRaça escolhida: " + p.raca + "\n")
    }
}