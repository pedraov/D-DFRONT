package Personagem.Classes

import Personagem.CriarPersonagem

class Monge: Classe{
    override fun escolherClasse(p: CriarPersonagem) {
        p.classe = "Monge"
        print("\nVocê é então ${p.nome}, o ${p.raca} ${p.classe}")
    }
}