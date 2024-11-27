package Personagem.Classes

import Personagem.CriarPersonagem

class Bardo : Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Bardo"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}