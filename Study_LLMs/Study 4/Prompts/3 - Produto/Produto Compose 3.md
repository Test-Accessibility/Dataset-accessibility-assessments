### *MobileDev:* 
Contexto: Sou desenvolvedor Android mobile.
Necessidade Geral: Me ajude a desenvolver uma tela de detalhes do produto para uma aplicação móvel Android nativa.
Elementos de Design da tela: Esta tela deve exibir informações detalhadas sobre um produto específico, incluindo seu nome, descrição, preço e imagem. Além disso, inclua elementos interativos, como botões para adicionar ao carrinho ou favoritos. Deve seguir os padrões do Material Design. Gere os textos para cada elemento.
Restrições: Indique todos os arquivos necessários para compilar o código e use Compose Jetpack. Gere apenas um arquivo ".kt" contendo todo o código necessário.

### *GitHub Copilot:*
Aqui está um exemplo de como você pode criar uma tela de detalhes do produto usando Jetpack Compose em um arquivo Kotlin:

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourappname.ui.theme.YourAppNameTheme

class ProductDetailScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourAppNameTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ProductDetail(
                        productName = "Nome do Produto",
                        productDescription = "Esta é a descrição detalhada do produto. Ele possui várias características e benefícios que são importantes para o usuário.",
                        productPrice = "R$ 199,99",
                        productImageRes = R.drawable.product_image // Substitua pelo seu recurso de imagem
                    )
                }
            }
        }
    }
}

@Composable
fun ProductDetail(
    productName: String,
    productDescription: String,
    productPrice: String,
    productImageRes: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = productImageRes),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = productName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = productDescription,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = productPrice,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4CAF50),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* TODO: Adicionar ao carrinho */ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f).padding(end = 8.dp)
            ) {
                Text(text = "Adicionar ao Carrinho")
            }
            Button(
                onClick = { /* TODO: Adicionar aos favoritos */ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f).padding(start = 8.dp)
            ) {
                Text(text = "Adicionar aos Favoritos")
            }
        }
    }
}
```

Certifique-se de substituir `R.drawable.product_image` pelo recurso de imagem real do seu produto. Além disso, ajuste o nome do pacote `com.example.yourappname` para corresponder ao nome do seu aplicativo.

Este código cria uma tela de detalhes do produto que exibe o nome, descrição, preço e imagem do produto, além de botões para adicionar ao carrinho e aos favoritos, seguindo os padrões do Material Design.

Similar code found with 4 license types

### *MobileDev:* 
Nessa tela sugerida foram encontrados erros de acessibilidade. Você é capaz de identificá-los?

### *GitHub Copilot:*
Sim, posso ajudar a identificar e corrigir os erros de acessibilidade na tela sugerida. Aqui estão algumas melhorias que podem ser feitas:

1. **Adicionar descrições de conteúdo para a imagem**: A imagem do produto deve ter uma descrição de conteúdo para que leitores de tela possam descrever a imagem.

2. **Adicionar rótulos de acessibilidade para os botões**: Os botões devem ter rótulos de acessibilidade para que leitores de tela possam descrever a ação dos botões.

Aqui está o código atualizado com essas melhorias:

```kotlin
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yourappname.ui.theme.YourAppNameTheme

class ProductDetailScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YourAppNameTheme {
                Surface(color = MaterialTheme.colors.background) {
                    ProductDetail(
                        productName = "Nome do Produto",
                        productDescription = "Esta é a descrição detalhada do produto. Ele possui várias características e benefícios que são importantes para o usuário.",
                        productPrice = "R$ 199,99",
                        productImageRes = R.drawable.product_image // Substitua pelo seu recurso de imagem
                    )
                }
            }
        }
    }
}

@Composable
fun ProductDetail(
    productName: String,
    productDescription: String,
    productPrice: String,
    productImageRes: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = productImageRes),
            contentDescription = "Imagem do produto: $productName",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(bottom = 16.dp)
        )
        Text(
            text = productName,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = productDescription,
            fontSize = 16.sp,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = productPrice,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF4CAF50),
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* TODO: Adicionar ao carrinho */ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
                    .semantics { contentDescription = "Adicionar ao Carrinho" }
            ) {
                Text(text = "Adicionar ao Carrinho")
            }
            Button(
                onClick = { /* TODO: Adicionar aos favoritos */ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
                    .semantics { contentDescription = "Adicionar aos Favoritos" }
            ) {
                Text(text = "Adicionar aos Favoritos")
            }
        }
    }
}
```

Essas alterações garantem que a imagem do produto e os botões tenham descrições de conteúdo apropriadas, melhorando a acessibilidade da tela para usuários que utilizam leitores de tela.

Similar code found with 3 license types
