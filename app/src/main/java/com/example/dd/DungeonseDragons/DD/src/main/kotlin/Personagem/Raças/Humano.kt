package Personagem.Raças

import Personagem.CriarPersonagem

class Humano : Raça{
    override fun bonusRaca(p: CriarPersonagem) {
            p.forca += 1
            p.carisma += 1
            p.destreza += 1
            p.constituicao += 1
            p.inteligencia += 1
            p.sabedoria += 1
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "HUMANO"
    }
}