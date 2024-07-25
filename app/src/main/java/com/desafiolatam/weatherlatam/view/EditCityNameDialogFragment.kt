package com.desafiolatam.weatherlatam.view

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.compose.ui.window.Dialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.desafiolatam.weatherlatam.R
import com.desafiolatam.weatherlatam.WeatherApplication
import com.desafiolatam.weatherlatam.databinding.DialogEditCityNameBinding
import com.desafiolatam.weatherlatam.extension.setupWidthToMatchParent
import com.desafiolatam.weatherlatam.view.viewmodel.WeatherViewModel
import com.desafiolatam.weatherlatam.view.viewmodel.WeatherViewModelFactory

class EditCityNameDialogFragment : DialogFragment() {

    private lateinit var cityName: String

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        // Inflate the layout for the dialog
        val view = LayoutInflater.from(context).inflate(R.layout.dialog_edit_city_name, null)

        // Initialize the city name from the arguments
        cityName = arguments?.getString(ARG_CITY_NAME) ?: ""

        // Set up the views
        val cityNameEditText = view.findViewById<EditText>(R.id.et_city_name)
        cityNameEditText.setText(cityName)

        // Set up the positive button
        view.findViewById<Button>(R.id.btn_save).setOnClickListener {
            // Get the new city name from the EditText
            val newCityName = cityNameEditText.text.toString()

            // Validate the new city name
            if (newCityName.isNotEmpty()) {
                // Save the new city name
                saveCityName(newCityName)

                // Update the city name in the arguments
                arguments?.putString(ARG_CITY_NAME, newCityName)

                // Dismiss the dialog
                dismiss()
            } else {
                // Show an error message
                Toast.makeText(context, "El nombre de la ciudad no puede estar vacío", Toast.LENGTH_SHORT).show()
            }
        }

        // Set up the negative button
        view.findViewById<Button>(R.id.btn_cancel).setOnClickListener {
            dismiss()
        }

        // Create the dialog
        return AlertDialog.Builder(requireContext())
            .setView(view)
            .create()
    }

    private fun saveCityName(cityName: String) {
        // Save the city name to a database, SharedPreferences, or another storage
        //...
    }

    companion object {
        const val ARG_CITY_NAME = "city_name"

        fun newInstance(cityName: String): EditCityNameDialogFragment {
            val fragment = EditCityNameDialogFragment()
            val args = Bundle()
            args.putString(ARG_CITY_NAME, cityName)
            fragment.arguments = args
            return fragment
        }
    }
}