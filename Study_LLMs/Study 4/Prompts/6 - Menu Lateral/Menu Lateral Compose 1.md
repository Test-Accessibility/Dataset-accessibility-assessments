### *MobileDev:*
Contexto: Sou desenvolvedor Android mobile.
Necessidade Geral: Me ajude a desenvolver um menu lateral retrátil para uma aplicação móvel Android nativa.
Elementos de Design da tela: Certifique-se de incluir duas seções. Uma com os itens de navegação “Página Inicial”, “Promoções”, “Meus Pedidos” e “Meu Carrinho”. E a outra com os itens “Minha Conta” e “Sair”. O menu deve possuir uma divisão e deve seguir os padrões do Material Design 3.
Restrições: Utilize Jetpack Compose e indique todos os arquivos necessários para compilar o código. Gere os textos necessários para os elementos. Restrições: Indique todos os arquivos necessários para compilar o código e use Jetpack Compose. Gere apenas um arquivo ".kt" contendo todo o código necessário.

### *GitHub Copilot:*
Para criar um menu lateral retrátil (Drawer) em uma aplicação Android nativa usando Jetpack Compose e seguindo os padrões do Material Design 3, você pode usar o código abaixo. Este código inclui todas as seções e itens de navegação especificados.

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController)
        }
    ) {
        NavHost(navController, startDestination = "home") {
            composable("home") { Text("Página Inicial") }
            composable("promotions") { Text("Promoções") }
            composable("orders") { Text("Meus Pedidos") }
            composable("cart") { Text("Meu Carrinho") }
            composable("account") { Text("Minha Conta") }
            composable("logout") { Text("Sair") }
        }
    }
}

@Composable
fun DrawerContent(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Menu",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Divider()
        DrawerItem("Página Inicial", navController, "home")
        DrawerItem("Promoções", navController, "promotions")
        DrawerItem("Meus Pedidos", navController, "orders")
        DrawerItem("Meu Carrinho", navController, "cart")
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        DrawerItem("Minha Conta", navController, "account")
        DrawerItem("Sair", navController, "logout")
    }
}

@Composable
fun DrawerItem(text: String, navController: NavHostController, route: String) {
    TextButton(
        onClick = {
            navController.navigate(route) {
                popUpTo(navController.graph.startDestinationId) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        modifier = Modifier.fillMaxWidth().padding(8.dp)
    ) {
        Text(text, fontSize = 18.sp)
    }
}
```

Este código define uma `MainActivity` que configura o conteúdo da tela usando Jetpack Compose. A função `MyApp` configura um `ModalNavigationDrawer` com um estado de gaveta e um controlador de navegação. A função `DrawerContent` define os itens do menu lateral, divididos conforme solicitado. Cada item de menu é definido pela função `DrawerItem`, que navega para a rota correspondente quando clicado.

Para compilar e executar este código, você precisa ter as dependências do Jetpack Compose configuradas no seu projeto. Certifique-se de que seu arquivo `build.gradle` (ou `build.gradle.kts`) inclua as dependências necessárias para o Jetpack Compose e o Material Design 3.

Similar code found with 2 license types

### *MobileDev:*
Nessa tela sugerida foram encontrados erros de acessibilidade. Você é capaz de identificá-los?

### *GitHub Copilot:*
Sim, posso ajudar a identificar e corrigir possíveis problemas de acessibilidade no código sugerido. Aqui estão algumas melhorias que podem ser feitas para garantir que a tela seja mais acessível:

1. **Adicionar descrições de conteúdo (contentDescription) para elementos de texto e botões**: Isso ajuda leitores de tela a descreverem os elementos para usuários com deficiência visual.
2. **Usar cores e contrastes adequados**: Certifique-se de que o texto tenha contraste suficiente com o fundo.
3. **Adicionar suporte para navegação por teclado**: Isso é importante para usuários que não podem usar uma tela sensível ao toque.

Aqui está o código atualizado com melhorias de acessibilidade:

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(navController)
        }
    ) {
        NavHost(navController, startDestination = "home") {
            composable("home") { Text("Página Inicial", modifier = Modifier.semantics { contentDescription = "Página Inicial" }) }
            composable("promotions") { Text("Promoções", modifier = Modifier.semantics { contentDescription = "Promoções" }) }
            composable("orders") { Text("Meus Pedidos", modifier = Modifier.semantics { contentDescription = "Meus Pedidos" }) }
            composable("cart") { Text("Meu Carrinho", modifier = Modifier.semantics { contentDescription = "Meu Carrinho" }) }
            composable("account") { Text("Minha Conta", modifier = Modifier.semantics { contentDescription = "Minha Conta" }) }
            composable("logout") { Text("Sair", modifier = Modifier.semantics { contentDescription = "Sair" }) }
        }
    }
}

@Composable
fun DrawerContent(navController: NavHostController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Menu",
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp).semantics { contentDescription = "Menu" }
        )
        Divider()
        DrawerItem("Página Inicial", navController, "home")
        DrawerItem("Promoções", navController, "promotions")
        DrawerItem("Meus Pedidos", navController, "orders")
        DrawerItem("Meu Carrinho", navController, "cart")
        Divider(modifier = Modifier.padding(vertical = 8.dp))
        DrawerItem("Minha Conta", navController, "account")
        DrawerItem("Sair", navController, "logout")
    }
}

@Composable
fun DrawerItem(text: String, navController: NavHostController, route: String) {
    TextButton(
        onClick = {
            navController.navigate(route) {
                popUpTo(navController.graph.startDestinationId) {
                    saveState = true
                }
                launchSingleTop = true
                restoreState = true
            }
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .semantics { contentDescription = text }
    ) {
        Text(text, fontSize = 18.sp)
    }
}
```

### Melhorias de Acessibilidade Implementadas:
1. **Adição de `contentDescription`**: Adicionei descrições de conteúdo para os textos e botões para que leitores de tela possam descrever os elementos.
2. **Uso de `semantics`**: Utilizei o modificador `semantics` para definir descrições de conteúdo para os elementos de texto e botões.

Essas melhorias ajudam a garantir que a aplicação seja mais acessível para todos os usuários, incluindo aqueles que utilizam leitores de tela.

Similar code found with 1 license type