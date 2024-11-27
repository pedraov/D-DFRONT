package Personagem.Classes

import Personagem.CriarPersonagem

class Guerreiro: Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Guerreiro"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}