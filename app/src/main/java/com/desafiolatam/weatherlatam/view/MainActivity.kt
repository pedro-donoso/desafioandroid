// MainActivity.kt
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.desafiolatam.weatherlatam.R
import org.json.JSONObject

interface CommunicationInterface {
    fun updateCityName(newCityName: String)
}

class MainActivity : AppCompatActivity(), CommunicationInterface {

    private lateinit var detailFragment: DetailFragment
    private lateinit var mainFragment: MainFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        detailFragment = DetailFragment()
        mainFragment = MainFragment()

        try {
            val inputStream = assets.open("weather_data.json")
            val json = inputStream.bufferedReader().use { it.readText() }
            val jsonObject = JSONObject(json)

            mainFragment.setCities(jsonObject.getJSONArray("cities"))

            val fragmentManager = supportFragmentManager
            fragmentManager.beginTransaction()
                .add(R.id.fragment_container, mainFragment)
                .add(R.id.fragment_container, detailFragment)
                .commit()

            updateCityData(jsonObject.getJSONObject("city_data"))
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun updateCityData(cityData: JSONObject) {
        val cityName = cityData.getString("city_name")
        detailFragment.setCityData(cityName)
    }

    override fun updateCityName(newCityName: String) {
        val cityNameTextView = findViewById<TextView>(R.id.city_name_textview)
        cityNameTextView.text = newCityName
    }
}