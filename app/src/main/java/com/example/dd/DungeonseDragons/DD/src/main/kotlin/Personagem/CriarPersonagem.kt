package Personagem

import Personagem.Classes.*
import Personagem.Melhora.*
import Personagem.Raças.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import java.io.Serializable

class CriarPersonagem() : Serializable {

    var nome: String? = null
    var raca: String? = null
    var classe: String? = null
    var nivel: Int = 1
    var vida: Int = 0
    var pontos = 27
    var forca = 0
    var destreza = 0
    var inteligencia = 0
    var constituicao = 0
    var sabedoria = 0
    var carisma = 0

    fun EscolherRaça(r: Raça){
        r.escolherRaça(this)
    }

    fun EscolherNome(nome: String){
        this.nome = nome
    }

    fun MelhorarPersonagem(m: MelhorarPersonagem, valor: Int){
        m.setAtributo(this, valor)
    }

    fun BonusRaça(r: Raça) {
        r.bonusRaca(this)
    }

    fun EscolherClasse(c : Classe){
        c.escolherClasse(this)
    }

    fun CalcularPV(){
        var modificador: Int = 0
        when(constituicao){
            8 -> modificador = -1
            9 -> modificador = -1
            10 -> modificador = 0
            11 -> modificador = 0
            12 -> modificador = 1
            13 -> modificador = 1
            14 -> modificador = 2
            15 -> modificador = 2
            16 -> modificador = 3
            17 -> modificador = 3
            18 -> modificador = 4
            19 -> modificador = 4
            else -> modificador = 0
        }

        vida = 10 + modificador
    }
}



