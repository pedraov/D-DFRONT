package com.example.dd

import Personagem.CriarPersonagem
import Personagem.Melhora.*
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.KeyboardType
import com.example.dd.ui.theme.DDTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recupera os dados do personagem vindo da intent
        val personagem = intent.getSerializableExtra("personagem") as? CriarPersonagem ?: CriarPersonagem()

        setContent {
            DDTheme {
                AtributosScreen(personagem)
            }
        }
    }
}

@Composable
fun AtributosScreen(personagem: CriarPersonagem) {
    val context = LocalContext.current
    var novaAtributo by remember { mutableStateOf("") }
    var atributoSelecionado by remember { mutableStateOf("Escolha um atributo") }
    var showDialog by remember { mutableStateOf(false) }

    // Melhoria de atributos
    val melhorarForca = MelhorarForca()
    val melhorarInteligencia = MelhorarInteligencia()
    val melhorarDestreza = MelhorarDestreza()
    val melhorarSabedoria = MelhorarSabedoria()
    val melhorarConstituicao = MelhorarConstituicao()
    val melhorarCarisma = MelhorarCarisma()

    val atributos = listOf("Força", "Inteligência", "Destreza", "Sabedoria", "Constituição", "Carisma")

    // Armazena o estado de cada atributo se foi melhorado
    val atributosMelhorados = remember { mutableMapOf<String, Boolean>().withDefault { false } }

    // Verifica se todos os atributos foram melhorados
    val isFormValid = atributos.all { atributosMelhorados.getValue(it) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Escolha um atributo para melhorar:", style = MaterialTheme.typography.titleLarge)
        Text(text = "Defina todos os seus atributos antes de continuar. Após definir o atributo clique no botão 'Melhorar Atributo'.", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Pontos disponíveis: ${personagem.pontos}", style = MaterialTheme.typography.titleMedium)
        // Botão para abrir o diálogo de seleção de atributos
        Button(onClick = { showDialog = true }) {
            Text(text = atributoSelecionado)
        }

        // Exibir dialog para selecionar atributos
        if (showDialog) {
            AlertDialog(
                onDismissRequest = { showDialog = false },
                title = { Text(text = "Escolha um Atributo") },
                text = {
                    Column {
                        atributos.forEach { atributo ->
                            Text(
                                text = atributo,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable {
                                        atributoSelecionado = atributo
                                        showDialog = false
                                    }
                                    .padding(8.dp)
                            )
                        }
                    }
                },
                confirmButton = {
                    Button(onClick = { showDialog = false }) {
                        Text("Fechar")
                    }
                }
            )
        }

        // Campo de entrada para o novo valor do atributo
        TextField(
            value = novaAtributo,
            onValueChange = { novaAtributo = it },
            label = { Text("Digite o novo valor ($atributoSelecionado) (8-15)") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Botão para melhorar o atributo selecionado
        Button(
            onClick = {
                val novoValor = novaAtributo.toIntOrNull()
                if (novoValor != null && novoValor in 8..15 && atributoSelecionado != "Escolha um atributo") {
                    when (atributoSelecionado) {
                        "Força" -> {
                            melhorarForca.setAtributo(personagem, novoValor)
                            atributosMelhorados["Força"] = true
                        }
                        "Inteligência" -> {
                            melhorarInteligencia.setAtributo(personagem, novoValor)
                            atributosMelhorados["Inteligência"] = true
                        }
                        "Destreza" -> {
                            melhorarDestreza.setAtributo(personagem, novoValor)
                            atributosMelhorados["Destreza"] = true
                        }
                        "Sabedoria" -> {
                            melhorarSabedoria.setAtributo(personagem, novoValor)
                            atributosMelhorados["Sabedoria"] = true
                        }
                        "Constituição" -> {
                            melhorarConstituicao.setAtributo(personagem, novoValor)
                            atributosMelhorados["Constituição"] = true
                        }
                        "Carisma" -> {
                            melhorarCarisma.setAtributo(personagem, novoValor)
                            atributosMelhorados["Carisma"] = true
                        }
                    }
                    novaAtributo = "" // Limpa o campo após a melhoria
                } else {
                    println("\nPor favor, preencha todos os campos corretamente: atributo selecionado e valor entre 8 e 15.")
                }
            },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Melhorar Atributo")
        }

        // Botão para ir para a terceira Activity
        Button(
            onClick = {
                val intent = Intent(context, ThirdActivity::class.java).apply {
                    putExtra("personagem", personagem)
                }
                context.startActivity(intent)
            },
            enabled = isFormValid,
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Mostrar Personagem")
        }
    }
}

//
//@Composable
//@Preview(showBackground = true)
//fun DefaultPreview() {
//    val personagem = intent.getSerializableExtra("personagem") as? CriarPersonagem ?: CriarPersonagem()
//    AtributosScreen(personagem)
//}