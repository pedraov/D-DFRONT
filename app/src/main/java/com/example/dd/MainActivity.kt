package com.example.dd

import Personagem.CriarPersonagem
import Personagem.Raças.AnãoColina
import Personagem.Raças.AnãoMontanha
import Personagem.Raças.Draconato
import Personagem.Raças.ElfoAlto
import Personagem.Raças.ElfoDrow
import Personagem.Raças.ElfoFloresta
import Personagem.Raças.GnomoFloresta
import Personagem.Raças.GnomoRochas
import Personagem.Raças.HalflingLeve
import Personagem.Raças.HalflingRobusto
import Personagem.Raças.Humano
import Personagem.Raças.MeioElfo
import Personagem.Raças.Orc
import Personagem.Raças.Tiefling
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import com.example.dd.ui.theme.DDTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DDTheme {
                MainScreen()
            }
        }
    }
}

// Função Composable principal
@Composable
fun MainScreen() {
    val selectedRace = remember { mutableStateOf("") }  // Estado para a raça selecionada
    val characterName = remember { mutableStateOf("") }  // Estado para o nome do personagem
    val showGreeting = remember { mutableStateOf(false) }  // Estado para controlar a exibição do Greeting
    val p: CriarPersonagem = CriarPersonagem()
    val focusManager = LocalFocusManager.current  // Gerenciador de foco
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentAlignment = Alignment.Center
        ) {
            // Adiciona a capacidade de rolagem à Column principal
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),  // Permite rolar se necessário
                verticalArrangement = Arrangement.spacedBy(16.dp)  // Espaçamento entre os itens
            ) {
                EscolherNome(characterName)  // Passa o estado do nome

                RaceSelectionScreen(selectedRace, focusManager)  // Seção de seleção da raça

                // Dentro do onClick no botão de salvar
                Button(
                    onClick = {
                        if (characterName.value.isNotEmpty() && selectedRace.value.isNotEmpty()) {
                            // Preenche os dados do personagem
                            p.nome = characterName.value
                            p.raca = selectedRace.value
                            escolherRacaEBonus(selectedRace.value, p)

                            // Cria um Intent para iniciar a SecondActivity
                            val intent = Intent(context, SecondActivity::class.java).apply {
                                putExtra("personagem", p)
                            }
                            context.startActivity(intent)
                        }
                    },
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Text("Salvar Nome e Raça")
                }
            }
        }
    }
}

@Composable
fun EscolherNome(characterName: MutableState<String>) {
    var text by remember { mutableStateOf("") }
    val focusManager = LocalFocusManager.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Escolha seu nome") },
            modifier = Modifier
                .fillMaxWidth(0.8f)  // Ajuste a largura para 80% da tela
                .onFocusChanged { focusState ->
                    if (!focusState.isFocused) {
                        characterName.value = text.trim()  // Atualiza o estado do nome quando o campo perde o foco
                    }
                }
        )
    }
}

@Composable
fun RaceSelectionScreen(selectedRace: MutableState<String>, focusManager: FocusManager) {
    val races = listOf(
        "Humano", "Elfo Alto", "Elfo Drow", "Elfo da Floresta",
        "Anão da Colina", "Anão da Montanha", "Draconato",
        "Gnomo da Floresta", "Gnomo das Rochas", "Halfling Leve",
        "Halfling Robusto", "Meio Elfo", "Meio Orc", "Tiefling"
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Escolha a raça do personagem", style = MaterialTheme.typography.titleLarge)

        races.forEach { race ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { // Torna a linha clicável
                        selectedRace.value = race  // Atualiza o estado compartilhado
                        focusManager.clearFocus()  // Perde o foco do campo de texto
                    }
            ) {
                RadioButton(
                    selected = (selectedRace.value == race),
                    onClick = {
                        selectedRace.value = race  // Atualiza o estado compartilhado
                        focusManager.clearFocus()  // Perde o foco do campo de texto
                    }
                )
                Text(text = race)
            }
        }
    }
}

// Função para aplicar a raça e bônus
fun escolherRacaEBonus(race: String, personagem: CriarPersonagem) {
    val racaStrategy = when (race) {
        "Humano" -> Humano()
        "Elfo Alto" -> ElfoAlto()
        "Elfo Drow" -> ElfoDrow()
        "Elfo da Floresta" -> ElfoFloresta()
        "Anão da Colina" -> AnãoColina()
        "Anão da Montanha" -> AnãoMontanha()
        "Draconato" -> Draconato()
        "Gnomo da Floresta" -> GnomoFloresta()
        "Gnomo das Rochas" -> GnomoRochas()
        "Halfling Leve" -> HalflingLeve()
        "Halfling Robusto" -> HalflingRobusto()
        "Meio Elfo" -> MeioElfo()
        "Meio Orc" -> Orc()
        "Tiefling" -> Tiefling()
        else -> throw IllegalArgumentException("Raça desconhecida")
    }

    racaStrategy.escolherRaça(personagem)
    racaStrategy.bonusRaca(personagem)
}
//
//@Composable
//@Preview(showBackground = true)
//fun DefaultPreview() {
//    MainScreen()
//}
