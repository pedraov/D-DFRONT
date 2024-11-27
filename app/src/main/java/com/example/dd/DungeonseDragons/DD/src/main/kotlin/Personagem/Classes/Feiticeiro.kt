package Personagem.Classes

import Personagem.CriarPersonagem

class Feiticeiro : Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Feiticeiro"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}