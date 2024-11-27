package Personagem.Classes

import Personagem.CriarPersonagem

class Bruxo : Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Bruxo"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}