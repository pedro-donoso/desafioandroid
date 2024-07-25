// DetailFragment.kt
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.desafiolatam.weatherlatam.R

class DetailFragment : Fragment() {

    private lateinit var cityEditText: EditText
    private lateinit var communicationInterface: CommunicationInterface

    interface CommunicationInterface {
        fun updateCityName(newCityName: String)
    }

    fun setCommunicationInterface(communicationInterface: CommunicationInterface) {
        this.communicationInterface = communicationInterface
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)

        cityEditText = view.findViewById<EditText>(R.id.city_edit_text)

        cityEditText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val newCityName = cityEditText.text.toString()
                communicationInterface.updateCityName(newCityName)
            }
            true
        }

        return view
    }

    fun setCityData(cityName: String) {
        cityEditText.setText(cityName)
    }
}