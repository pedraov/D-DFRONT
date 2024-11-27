package Personagem.Classes

import Personagem.CriarPersonagem

class Druida : Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Druida"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}