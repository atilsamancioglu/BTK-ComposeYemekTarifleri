package com.atilsamancioglu.yemektariflericompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.atilsamancioglu.yemektariflericompose.model.Yemek
import com.atilsamancioglu.yemektariflericompose.ui.theme.YemekTarifleriComposeTheme
import com.google.gson.Gson

@Composable
fun YemekListesi(yemekler : List<Yemek>, navController: NavController) {
    LazyColumn(contentPadding = PaddingValues(5.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colorScheme.background)
        ) {
        items(yemekler) {
            YemekRow(yemek = it, navController = navController)
        }
    }
}

@Composable
fun YemekRow(yemek: Yemek, navController: NavController) {
    Column(modifier= Modifier
        .fillMaxWidth()
        .background(color = MaterialTheme.colorScheme.background)
        .clickable {
            navController.navigate("detay_ekrani/${Gson().toJson(yemek)}")
        }
    ) {
        Text(text=yemek.isim,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Bold

            )
        Text(text=yemek.malzemeler,
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(5.dp),
            fontWeight = FontWeight.Normal
            )
    }
}

/*
@Preview(showBackground = true)
@Composable
fun YemekListesiPreview() {
    YemekTarifleriComposeTheme {
        val yemekListesi = arrayListOf<Yemek>()
        val pizza = Yemek("Pizza", "Hamur, Peynir, Sucuk", R.drawable.pizza)
        val makarna = Yemek("Makarna", "Penne, Domates, Fesleğen", R.drawable.makarna)
        val kofte = Yemek("Kofte", "Kıyma, Ekmek, Pirinç", R.drawable.kofte)
        val salata = Yemek("Salata", "Domates, Salatalık, Soğan", R.drawable.salata)
        val ekmek = Yemek("Ekmek", "Hamur, Maya", R.drawable.ekmek)

        yemekListesi.add(pizza)
        yemekListesi.add(makarna)
        yemekListesi.add(kofte)
        yemekListesi.add(salata)
        yemekListesi.add(ekmek)
        yemekListesi.add(pizza)
        yemekListesi.add(makarna)
        yemekListesi.add(kofte)
        yemekListesi.add(salata)
        yemekListesi.add(ekmek)
        YemekListesi(yemekler = yemekListesi)
    }
}

 */