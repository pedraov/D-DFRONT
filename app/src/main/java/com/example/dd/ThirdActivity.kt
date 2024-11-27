package com.example.dd

import Personagem.CriarPersonagem
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dd.ui.theme.DDTheme

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Recupera os dados do personagem vindo da intent
        val personagem = intent.getSerializableExtra("personagem") as? CriarPersonagem

        setContent {
            DDTheme {
                PersonagemScreen(personagem)
            }
        }
    }
}

@Composable
fun PersonagemScreen(personagem: CriarPersonagem?) {
    if (personagem == null) {
        Text("Personagem não encontrado.")
        return
    }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Nome: ${personagem.nome}", style = MaterialTheme.typography.titleLarge)
        Text(text = "Raça: ${personagem.raca}", style = MaterialTheme.typography.titleMedium)
        Text(text = "Força: ${personagem.forca}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Inteligência: ${personagem.inteligencia}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Destreza: ${personagem.destreza}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Sabedoria: ${personagem.sabedoria}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Constituição: ${personagem.constituicao}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Carisma: ${personagem.carisma}", style = MaterialTheme.typography.bodyMedium)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewPersonagemScreen() {
    val personagem = CriarPersonagem()
    PersonagemScreen(personagem)
}
