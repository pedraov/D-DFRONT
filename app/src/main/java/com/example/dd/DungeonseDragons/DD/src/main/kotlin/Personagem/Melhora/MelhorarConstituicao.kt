package Personagem.Melhora

import Personagem.CriarPersonagem

class MelhorarConstituicao : MelhorarPersonagem {
    override fun setAtributo(p: CriarPersonagem, newConstituicao: Int) {
        val tabelaDeCusto = mapOf(
            8 to 0,
            9 to 1,
            10 to 2,
            11 to 3,
            12 to 4,
            13 to 5,
            14 to 7,
            15 to 9
        )

        if (p.pontos > 0) {
            val custo = tabelaDeCusto[newConstituicao]

            if (custo != null  && custo in 8..15) {
                if (p.pontos >= custo) {
                    p.constituicao += newConstituicao
                    println("\nMelhora feita! Nível de Constituição atual: ${p.forca}\n")
                    p.pontos -= custo
                } else {
                    println("\nQuantidade de pontos inválida, digite outro valor.")
                }
            } else {
                println("\nPor favor, digite um número entre 8 e 15.\n")
            }
        } else {
            p.constituicao = 8
            println("\nSem pontos disponíveis, seu nível nesta habilidade será 8.")
        }
    }
}