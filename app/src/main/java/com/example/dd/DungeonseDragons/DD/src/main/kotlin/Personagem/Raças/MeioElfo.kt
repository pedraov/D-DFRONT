package Personagem.Raças

import Personagem.CriarPersonagem

class MeioElfo : Raça {
    override fun bonusRaca(p: CriarPersonagem) {
        p.carisma += 2
    }

    override fun escolherRaça(p: CriarPersonagem) {
        p.raca = "MEIO ELFO"

    }
}