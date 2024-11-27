package Personagem.Classes

import Personagem.CriarPersonagem

class Barbaro : Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Bárbaro"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}