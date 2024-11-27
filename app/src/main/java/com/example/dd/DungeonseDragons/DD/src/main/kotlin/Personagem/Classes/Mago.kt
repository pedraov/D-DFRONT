package Personagem.Classes

import Personagem.CriarPersonagem

class Mago : Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Mago"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}