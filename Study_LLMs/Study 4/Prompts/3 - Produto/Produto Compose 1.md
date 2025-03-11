danielmfr: Contexto: Sou desenvolvedor Android mobile.<br>
Necessidade Geral: Me ajude a desenvolver uma tela de detalhes do produto para uma aplicação móvel Android nativa.<br>
Elementos de Design da tela: Esta tela deve exibir informações detalhadas sobre um produto específico, incluindo seu nome, descrição, preço e imagem. Além disso, inclua elementos interativos, como botões para adicionar ao carrinho ou favoritos. Deve seguir os padrões do Material Design. Gere os textos para cada elemento.<br>
Restrições: Indique todos os arquivos necessários para compilar o código e use Compose Jetpack. Gere apenas um arquivo ".kt" contendo todo o código necessário.

GitHub Copilot: Aqui está um exemplo de como você pode criar uma tela de detalhes do produto usando Jetpack Compose em um arquivo Kotlin:

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
                        productDescription = "Descrição detalhada do produto.",
                        productPrice = "R$ 99,99",
                        productImage = R.drawable.product_image // Substitua pelo seu recurso de imagem
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
    productImage: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = productImage),
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
            color = Color.Green,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* TODO: Adicionar ao carrinho */ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Adicionar ao Carrinho")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { /* TODO: Adicionar aos favoritos */ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Adicionar aos Favoritos")
            }
        }
    }
}
```

Certifique-se de substituir `R.drawable.product_image` pelo recurso de imagem real do seu produto. Além disso, ajuste o nome do pacote `com.example.yourappname` para corresponder ao nome do seu aplicativo.

Este código cria uma tela de detalhes do produto com Jetpack Compose, seguindo os padrões do Material Design. A tela inclui uma imagem do produto, nome, descrição, preço e botões interativos para adicionar ao carrinho e aos favoritos.

Similar code found with 4 license types

danielmfr: Nessa tela sugerida foram encontrados erros de acessibilidade. Você é capaz de identificá-los?

GitHub Copilot: Sim, posso ajudar a identificar e corrigir os erros de acessibilidade na tela sugerida. Aqui estão algumas melhorias que podem ser feitas:

1. Adicionar descrições de conteúdo (`contentDescription`) para a imagem do produto.
2. Usar `contentDescription` apropriado para os botões para que leitores de tela possam identificar suas funções.

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
                        productDescription = "Descrição detalhada do produto.",
                        productPrice = "R$ 99,99",
                        productImage = R.drawable.product_image // Substitua pelo seu recurso de imagem
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
    productImage: Int
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = productImage),
            contentDescription = "Imagem do $productName",
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
            color = Color.Green,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { /* TODO: Adicionar ao carrinho */ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Adicionar ao Carrinho", contentDescription = "Botão para adicionar $productName ao carrinho")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(
                onClick = { /* TODO: Adicionar aos favoritos */ },
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Adicionar aos Favoritos", contentDescription = "Botão para adicionar $productName aos favoritos")
            }
        }
    }
}
```

Essas mudanças garantem que a imagem do produto e os botões tenham descrições de conteúdo apropriadas, melhorando a acessibilidade para usuários que utilizam leitores de tela.

Similar code found with 2 license types