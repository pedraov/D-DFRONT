package Personagem.Raças

import Personagem.CriarPersonagem

interface Raça {
    fun escolherRaça(p:CriarPersonagem){}
    fun bonusRaca(p: CriarPersonagem){}
}