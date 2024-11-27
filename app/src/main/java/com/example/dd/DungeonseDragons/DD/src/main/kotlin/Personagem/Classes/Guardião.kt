package Personagem.Classes

import Personagem.CriarPersonagem

class Guardião: Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Guardião"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}