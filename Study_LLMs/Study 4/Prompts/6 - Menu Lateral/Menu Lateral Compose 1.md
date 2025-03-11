Ribas5: Contexto: Sou desenvolvedor Android mobile. Necessidade Geral: Me ajude a desenvolver um menu lateral retrátil para uma aplicação móvel Android nativa. Elementos de Design da tela: Certifique-se de incluir duas seções. Uma com os itens de navegação “Página Inicial”, “Promoções”, “Meus Pedidos” e “Meu Carrinho”. E a outra com os itens “Minha Conta” e “Sair”. O menu deve possuir uma divisão e deve seguir os padrões do Material Design. Restrições: Utilize Jetpack Compose e indique todos os arquivos necessários para compilar o código. Gere os textos necessários para os elementos. Restrições: Indique todos os arquivos necessários para compilar o código e use Jetpack Compose. Gere apenas um arquivo ".kt" contendo todo o código necessário.

GitHub Copilot: Aqui está um exemplo de como você pode criar um menu lateral retrátil utilizando Jetpack Compose para uma aplicação Android nativa. O código abaixo inclui todas as seções e itens de navegação especificados, seguindo os padrões do Material Design.

```kotlin
package com.example.drawerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.drawerexample.ui.theme.DrawerExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawerExampleTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("App Title") },
                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch { scaffoldState.drawerState.open() }
                    }) {
                        Icon(Icons.Filled.Menu, contentDescription = "Menu")
                    }
                }
            )
        },
        drawerContent = {
            DrawerContent(navController, scaffoldState)
        }
    ) {
        NavigationHost(navController)
    }
}

@Composable
fun DrawerContent(navController: NavHostController, scaffoldState: ScaffoldState) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Navegação",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        Divider(color = Color.Gray)
        DrawerItem("Página Inicial", navController, scaffoldState)
        DrawerItem("Promoções", navController, scaffoldState)
        DrawerItem("Meus Pedidos", navController, scaffoldState)
        DrawerItem("Meu Carrinho", navController, scaffoldState)
        Divider(color = Color.Gray, modifier = Modifier.padding(vertical = 8.dp))
        DrawerItem("Minha Conta", navController, scaffoldState)
        DrawerItem("Sair", navController, scaffoldState)
    }
}

@Composable
fun DrawerItem(text: String, navController: NavHostController, scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    Text(
        text = text,
        fontSize = 18.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable {
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                navController.navigate(text)
            }
    )
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = "Página Inicial") {
        composable("Página Inicial") { ScreenContent("Página Inicial") }
        composable("Promoções") { ScreenContent("Promoções") }
        composable("Meus Pedidos") { ScreenContent("Meus Pedidos") }
        composable("Meu Carrinho") { ScreenContent("Meu Carrinho") }
        composable("Minha Conta") { ScreenContent("Minha Conta") }
        composable("Sair") { ScreenContent("Sair") }
    }
}

@Composable
fun ScreenContent(text: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = text, fontSize = 24.sp)
    }
}
```

Este arquivo `MainActivity.kt` contém todo o código necessário para criar um menu lateral retrátil com Jetpack Compose. Certifique-se de ter as dependências do Jetpack Compose configuradas no seu arquivo `build.gradle` para compilar o código corretamente.

Similar code found with 2 license types

Ribas5: Nessa tela sugerida foram encontrados erros de acessibilidade. Você é capaz de identificá-los?

GitHub Copilot: Sim, posso ajudar a identificar e corrigir alguns problemas de acessibilidade no código sugerido. Aqui estão algumas melhorias que podem ser feitas:

1. **Adicionar descrições de conteúdo para ícones**: Adicionar descrições de conteúdo para ícones ajuda os leitores de tela a descreverem o que o ícone representa.
2. **Adicionar rótulos para itens clicáveis**: Certifique-se de que todos os itens clicáveis tenham rótulos descritivos.
3. **Usar cores com contraste adequado**: Verifique se as cores usadas têm contraste suficiente para serem legíveis.

Aqui está o código atualizado com essas melhorias:

```kotlin
package com.example.drawerexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import com.example.drawerexample.ui.theme.DrawerExampleTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DrawerExampleTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                title = { Text("App Title") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            scope.launch { scaffoldState.drawerState.open() }
                        },
                        contentDescription = "Abrir menu de navegação"
                    ) {
                        Icon(Icons.Filled.Menu, contentDescription = null)
                    }
                }
            )
        },
        drawerContent = {
            DrawerContent(navController, scaffoldState)
        }
    ) {
        NavigationHost(navController)
    }
}

@Composable
fun DrawerContent(navController: NavHostController, scaffoldState: ScaffoldState) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Navegação",
            fontSize = 20.sp,
            modifier = Modifier.padding(16.dp)
        )
        Divider(color = Color.Gray)
        DrawerItem("Página Inicial", navController, scaffoldState)
        DrawerItem("Promoções", navController, scaffoldState)
        DrawerItem("Meus Pedidos", navController, scaffoldState)
        DrawerItem("Meu Carrinho", navController, scaffoldState)
        Divider(color = Color.Gray, modifier = Modifier.padding(vertical = 8.dp))
        DrawerItem("Minha Conta", navController, scaffoldState)
        DrawerItem("Sair", navController, scaffoldState)
    }
}

@Composable
fun DrawerItem(text: String, navController: NavHostController, scaffoldState: ScaffoldState) {
    val scope = rememberCoroutineScope()
    Text(
        text = text,
        fontSize = 18.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable(
                onClickLabel = "Navegar para $text"
            ) {
                scope.launch {
                    scaffoldState.drawerState.close()
                }
                navController.navigate(text)
            }
    )
}

@Composable
fun NavigationHost(navController: NavHostController) {
    NavHost(navController, startDestination = "Página Inicial") {
        composable("Página Inicial") { ScreenContent("Página Inicial") }
        composable("Promoções") { ScreenContent("Promoções") }
        composable("Meus Pedidos") { ScreenContent("Meus Pedidos") }
        composable("Meu Carrinho") { ScreenContent("Meu Carrinho") }
        composable("Minha Conta") { ScreenContent("Minha Conta") }
        composable("Sair") { ScreenContent("Sair") }
    }
}

@Composable
fun ScreenContent(text: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = text, fontSize = 24.sp)
    }
}
```

### Melhorias de Acessibilidade Implementadas:
1. **Adição de `contentDescription` para o ícone do menu**: Adicionamos uma descrição de conteúdo para o botão do ícone do menu.
2. **Adição de `onClickLabel` para itens clicáveis**: Adicionamos rótulos descritivos para os itens clicáveis no menu lateral.

Essas melhorias ajudam a garantir que a interface seja mais acessível para usuários que dependem de leitores de tela.

Similar code found with 2 license types