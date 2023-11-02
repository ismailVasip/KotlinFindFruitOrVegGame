package com.example.fruitvegetablegame.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fruitvegetablegame.Data.DataClass
import com.example.fruitvegetablegame.R
import com.example.fruitvegetablegame.Singleton.MySingleton

class MainActivity : AppCompatActivity() {
    private lateinit var hashMapFruit:HashMap<String,Int>
    private lateinit var listFruit:List<DataClass>

    private lateinit var hashMapVeg:HashMap<String,Int>
    private lateinit var listMVeg:List<DataClass>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hashMapFruit = hashMapOf(
            "Avokado" to R.drawable.avokado,
            "Çilek" to R.drawable.cilek,
            "Domates" to R.drawable.domates,
            "İncir" to R.drawable.incir,
            "Kabak" to R.drawable.kabak,
            "Kayısı" to R.drawable.kayisi,
            "Keçiboynuzu" to R.drawable.keciboynuzu,
            "Kivi" to R.drawable.kivi,
            "Kuşburnu" to R.drawable.kusburnu,
            "Limon" to R.drawable.limon,
            "Mandalina" to R.drawable.mandalina,
            "Muz" to R.drawable.muz,
            "Nar" to R.drawable.nar,
            "Salatalık" to R.drawable.salatalik,
            "Şeftali" to R.drawable.seftali,
            "Üzüm" to R.drawable.uzum,
            "Vişne" to R.drawable.visne,
            "Zeytin" to R.drawable.zeytin,
            "Portakal" to R.drawable.portakal,
            "Kestane" to R.drawable.kestane
        )
        listFruit = hashMapFruit.map { (key,value) ->
            DataClass(key,value)
        }
        MySingleton.setListFruit(listFruit)

        hashMapVeg = hashMapOf(
            "Brokoli" to R.drawable.brokoli,
            "Enginar" to R.drawable.enginar,
            "Havuç" to R.drawable.havuc,
            "Ispanak" to R.drawable.ispanak,
            "Kereviz" to R.drawable.kereviz,
            "Kuşkonmaz" to R.drawable.kuskonmaz,
            "Lahana" to R.drawable.lahana,
            "Mantar" to R.drawable.mantar,
            "Marul" to R.drawable.marul,
            "Pancar"  to R.drawable.pancar,
            "Patates" to R.drawable.patates,
            "Pırasa" to R.drawable.pirasa,
            "Sarımsak" to R.drawable.sarimsak,
            "Soğan" to R.drawable.sogan,
            "Tere" to R.drawable.tere,
            "Turp" to R.drawable.turp
        )
        listMVeg = hashMapVeg.map { (key,value) ->
            DataClass(key,value)
        }
        MySingleton.setListVeg(listMVeg)

    }

}