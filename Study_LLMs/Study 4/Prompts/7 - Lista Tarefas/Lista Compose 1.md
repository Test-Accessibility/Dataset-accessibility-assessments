Ribas5: Contexto: Sou desenvolvedor Android mobile.
Necessidade Geral: Me ajude a desenvolver uma tela com uma lista de tarefas para uma aplicação móvel Android nativa.
Elementos de Design da tela: Certifique-se de incluir, pelo menos, três itens na lista e em cada item deve possuir uma checkbox, uma tarefa e uma data. A lista deve ser organizada de acordo com as datas em ordem decrescente. Deve seguir os padrões do Material Design. Gere os textos necessários.
Restrições: Utilize Jetpack Compose e indique todos os arquivos necessários para compilar o código. Gere apenas um arquivo ".kt" contendo todo o código necessário.

GitHub Copilot: Aqui está um exemplo de como você pode criar uma tela com uma lista de tarefas usando Jetpack Compose para uma aplicação Android nativa. O código inclui uma lista de tarefas com checkbox, tarefa e data, organizada em ordem decrescente de datas, seguindo os padrões do Material Design.

```kotlin
package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

data class Task(val description: String, val date: LocalDate, var isChecked: Boolean)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListScreen()
        }
    }
}

@Composable
fun TodoListScreen() {
    val tasks = remember {
        mutableStateListOf(
            Task("Tarefa 1", LocalDate.of(2025, 3, 10), false),
            Task("Tarefa 2", LocalDate.of(2025, 3, 9), false),
            Task("Tarefa 3", LocalDate.of(2025, 3, 8), false)
        ).sortedByDescending { it.date }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Tarefas") }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(tasks) { task ->
                TaskItem(task)
            }
        }
    }
}

@Composable
fun TaskItem(task: Task) {
    var isChecked by remember { mutableStateOf(task.isChecked) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(text = task.description, fontSize = 20.sp)
            Text(text = task.date.toString(), fontSize = 14.sp)
        }
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
                task.isChecked = it
            }
        )
    }
}
```

Este código cria uma tela com uma lista de tarefas usando Jetpack Compose. Cada item da lista contém uma checkbox, uma descrição da tarefa e uma data. A lista é organizada em ordem decrescente de datas. Certifique-se de ter as dependências do Jetpack Compose configuradas no seu arquivo `build.gradle` para compilar o código corretamente.

Similar code found with 1 license type

Ribas5: Nessa tela sugerida foram encontrados erros de acessibilidade. Você é capaz de identificá-los?

GitHub Copilot: Sim, posso ajudar a identificar e corrigir os erros de acessibilidade na tela sugerida. Aqui estão algumas melhorias que podem ser feitas para garantir que a tela seja mais acessível:

1. **Adicionar descrições de conteúdo para elementos interativos**: Adicionar descrições de conteúdo para a checkbox para que leitores de tela possam identificar o propósito do elemento.

2. **Usar cores acessíveis**: Certifique-se de que as cores usadas tenham contraste suficiente para serem legíveis por pessoas com deficiências visuais.

3. **Adicionar suporte para navegação por teclado**: Garantir que todos os elementos interativos possam ser acessados e manipulados usando o teclado.

Aqui está o código atualizado com melhorias de acessibilidade:

```kotlin
package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate

data class Task(val description: String, val date: LocalDate, var isChecked: Boolean)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoListScreen()
        }
    }
}

@Composable
fun TodoListScreen() {
    val tasks = remember {
        mutableStateListOf(
            Task("Tarefa 1", LocalDate.of(2025, 3, 10), false),
            Task("Tarefa 2", LocalDate.of(2025, 3, 9), false),
            Task("Tarefa 3", LocalDate.of(2025, 3, 8), false)
        ).sortedByDescending { it.date }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Lista de Tarefas") }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            items(tasks) { task ->
                TaskItem(task)
            }
        }
    }
}

@Composable
fun TaskItem(task: Task) {
    var isChecked by remember { mutableStateOf(task.isChecked) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = task.description,
                fontSize = 20.sp,
                modifier = Modifier.semantics { contentDescription = "Descrição da tarefa: ${task.description}" }
            )
            Text(
                text = task.date.toString(),
                fontSize = 14.sp,
                modifier = Modifier.semantics { contentDescription = "Data da tarefa: ${task.date}" }
            )
        }
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
                task.isChecked = it
            },
            modifier = Modifier.semantics { contentDescription = "Marcar tarefa como concluída" }
        )
    }
}
```

Com essas melhorias, a tela agora inclui descrições de conteúdo para os elementos interativos, o que ajuda os leitores de tela a identificar o propósito de cada elemento. Certifique-se de testar a aplicação com ferramentas de acessibilidade para garantir que todas as melhorias funcionem conforme o esperado.

Similar code found with 1 license type