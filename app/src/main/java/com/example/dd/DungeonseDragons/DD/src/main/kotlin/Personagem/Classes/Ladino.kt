package Personagem.Classes

import Personagem.CriarPersonagem

class Ladino : Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Ladino"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}