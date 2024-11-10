package com.atilsamancioglu.yemektariflericompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.atilsamancioglu.yemektariflericompose.model.Yemek
import com.atilsamancioglu.yemektariflericompose.ui.theme.YemekTarifleriComposeTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {

    private val yemekListesi = ArrayList<Yemek>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            YemekTarifleriComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(navController = navController, startDestination = "liste_ekrani") {

                            composable("liste_ekrani") {
                                verileriOlustur()
                                YemekListesi(yemekler = yemekListesi,navController=navController)
                            }

                            composable("detay_ekrani/{secilenYemek}",
                                arguments = listOf(
                                    navArgument("secilenYemek") {
                                        type = NavType.StringType
                                    }
                                )
                            ) {
                                val yemekString = remember {
                                    it.arguments?.getString("secilenYemek")
                                }

                                val secilenYemek = Gson().fromJson(yemekString,Yemek::class.java)

                                DetayEkrani(yemek = secilenYemek)
                            }



                        }
                    }
                }
            }
        }
    }

    private fun verileriOlustur() {

        val pizza = Yemek("Pizza","Hamur, Peynir, Sucuk", R.drawable.pizza)
        val makarna = Yemek("Makarna","Penne, Domates, Fesleğen",R.drawable.makarna)
        val kofte = Yemek("Kofte","Kıyma, Ekmek, Pirinç",R.drawable.kofte)
        val salata = Yemek("Salata","Domates, Salatalık, Soğan", R.drawable.salata)
        val ekmek = Yemek("Ekmek","Hamur, Maya",R.drawable.ekmek)

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
        yemekListesi.add(pizza)
        yemekListesi.add(makarna)
        yemekListesi.add(kofte)
        yemekListesi.add(salata)
        yemekListesi.add(ekmek)

    }


}