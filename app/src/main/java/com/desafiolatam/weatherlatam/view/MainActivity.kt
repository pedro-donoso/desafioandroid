// MainActivity.kt
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.desafiolatam.weatherlatam.R

class MainActivity : AppCompatActivity(), DetailFragment.CommunicationInterface {

    private lateinit var mainFragment: MainFragment
    private lateinit var detailFragment: DetailFragment<Any?>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainFragment = MainFragment()
        detailFragment = DetailFragment()

        // No necesitas establecer la interfaz de comunicación aquí
        // detailFragment.setCommunicationInterface(this) // ya no es necesario
    }

    override fun updateCityName(newCityName: String) {
        val cityNameTextView = findViewById<TextView>(R.id.city_name_textview)
        cityNameTextView.text = newCityName
    }
}