// DetailFragment.kt
import android.os.Bundle
import androidx.fragment.app.Fragment

class DetailFragment<T> : Fragment() {

    interface CommunicationInterface {
        fun updateCityName(newCityName: String)
    }

    private lateinit var communicationInterface: CommunicationInterface

    fun setCommunicationInterface(communicationInterface: CommunicationInterface) {
        this.communicationInterface = communicationInterface
    }

    // ...
    // En algún lugar de este fragment, llamas al método updateCityName
    // ...
    fun someMethod() {
        communicationInterface.updateCityName("Nueva ciudad")
    }
}

