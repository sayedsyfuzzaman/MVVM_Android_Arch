package com.syfuzzaman.mvvm_android_arch.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import android.widget.Toolbar
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.databinding.FragmentMovieDetailsBinding
import com.syfuzzaman.mvvm_android_arch.ui.common.BaseFragment
import com.syfuzzaman.mvvm_android_arch.ui.home.HomeActivity

class MovieDetailsFragment : BaseFragment() {

    private lateinit var binding: FragmentMovieDetailsBinding

    private val bloodGroups = arrayOf(
        "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"
    )

    private val bloodGroupMapping = mapOf(
        "A+" to "aPos",
        "A-" to "aNeg",
        "B+" to "bPos",
        "B-" to "bNeg",
        "AB+" to "abPos",
        "AB-" to "abNeg",
        "O+" to "oPos",
        "O-" to "oNeg"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMovieDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Movie Details"

        val autoCompleteTextView = binding.autoCompleteTextView
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_dropdown_item_1line, bloodGroups)

        autoCompleteTextView.setAdapter(adapter)
        autoCompleteTextView.setOnItemClickListener { parent, view, position, id ->
            val selectedBloodGroup = parent.getItemAtPosition(position) as String
            val mappedValue = bloodGroupMapping[selectedBloodGroup]
            if (mappedValue != null) {
                Toast.makeText(requireContext(), mappedValue, Toast.LENGTH_SHORT).show()
            } else {
                showError("Invalid blood group")
                autoCompleteTextView.setText("")
            }
        }
    }

    private fun showError(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
}