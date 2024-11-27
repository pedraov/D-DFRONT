package Personagem.Classes

import Personagem.CriarPersonagem

class Clérigo : Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Clérigo"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}