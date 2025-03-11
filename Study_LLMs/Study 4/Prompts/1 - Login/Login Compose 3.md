danielmfr: Contexto: Sou desenvolvedor Android mobile.
Necessidade Geral: Me ajude a desenvolver uma tela de login para uma aplicação móvel Android nativa.
Elementos de Design da tela: Certifique-se de incluir campos para o nome de usuário/e-mail e senha, juntamente com botões para 'Entrar' e 'Esqueceu a senha'. Deve seguir os padrões do Material Design.
Restrições: Indique todos os arquivos necessários para compilar o código e use o Compose do Jetpack. Gere apenas um arquivo ".kt" contendo todo o código necessário.

GitHub Copilot: Aqui está um exemplo de uma tela de login usando Jetpack Compose para uma aplicação Android nativa. Este exemplo inclui campos para nome de usuário/e-mail e senha, além dos botões 'Entrar' e 'Esqueceu a senha', seguindo os padrões do Material Design.

```kotlin
package com.example.loginscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginscreen.ui.theme.LoginScreenTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* TODO: Handle login */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Entrar")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(
            onClick = { /* TODO: Handle forgot password */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Esqueceu a senha?")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenTheme {
        LoginScreen()
    }
}
```

Este código cria uma tela de login simples usando Jetpack Compose. Certifique-se de ter as dependências do Jetpack Compose configuradas no seu arquivo `build.gradle` para compilar este código.

Similar code found with 1 license type

danielmfr: Nessa tela sugerida foram encontrados erros de acessibilidade. Você é capaz de identificá-los?

GitHub Copilot: Sim, posso ajudar a identificar e corrigir os erros de acessibilidade na tela de login sugerida. Aqui estão algumas melhorias que podem ser feitas para garantir uma melhor acessibilidade:

1. **Adicionar descrições de conteúdo (contentDescription) para elementos interativos**: Isso ajuda os leitores de tela a descreverem os elementos para usuários com deficiência visual.
2. **Usar `visualTransformation` para ocultar a senha**: Isso garante que a senha não seja visível enquanto o usuário a digita.
3. **Adicionar suporte para navegação por teclado**: Isso garante que os usuários possam navegar pela tela usando apenas o teclado.

Aqui está o código atualizado com essas melhorias:

```kotlin
package com.example.loginscreen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.loginscreen.ui.theme.LoginScreenTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LoginScreenTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun LoginScreen() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        TextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Email,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Senha") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { /* TODO: Handle login */ },
            modifier = Modifier
                .fillMaxWidth()
                .semantics { contentDescription = "Botão de Entrar" }
        ) {
            Text("Entrar")
        }
        Spacer(modifier = Modifier.height(8.dp))
        TextButton(
            onClick = { /* TODO: Handle forgot password */ },
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Esqueceu a senha?")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreenTheme {
        LoginScreen()
    }
}
```

### Melhorias de Acessibilidade Implementadas:
1. **Adição de `contentDescription` ao botão "Entrar"**.
2. **Uso de `PasswordVisualTransformation` para ocultar a senha enquanto é digitada**.
3. **Configuração de `singleLine = true` para os campos de texto para melhorar a navegação por teclado**.

Essas mudanças ajudam a garantir que a tela de login seja mais acessível para todos os usuários.

Similar code found with 3 license types