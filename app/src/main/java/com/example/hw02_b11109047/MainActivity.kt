package com.example.hw02_b11109047

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : ComponentActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dataList: ArrayList<DataClass>
    lateinit var imagList: Array<Int>
    lateinit var titleList: Array<String>
    lateinit var latitudeList: Array<Double>
    lateinit var longitudeList: Array<Double>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imagList = arrayOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5
        )

        titleList = arrayOf(
            "景點1",
            "景點2",
            "景點3",
            "景點4",
            "景點5"
        )

        latitudeList = arrayOf(
            25.013947440847428, // 假设的纬度
            25.02048375003858,
            25.013664034473656,
            25.030174241868078,
            25.035577963166777
        )

        longitudeList = arrayOf(
            121.54102122401879, // 假设的经度
            121.53763058509287,
            121.53500199513027,
            121.5354421142678,
            121.52016573388515
        )

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        dataList = arrayListOf()
        getDate()
    }

    private fun getDate() {
        for (i in imagList.indices) {
            val dataClass = DataClass(imagList[i], titleList[i], latitudeList[i], longitudeList[i])
            dataList.add(dataClass)
        }

        recyclerView.adapter = AdapterClass(dataList) { dataClass ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("dataImage", dataClass.dataImage)
                putExtra("dataTitle", dataClass.dataTitle)
                putExtra("latitude", dataClass.latitude)
                putExtra("longitude", dataClass.longitude)
            }
            startActivity(intent)
        }
    }
}