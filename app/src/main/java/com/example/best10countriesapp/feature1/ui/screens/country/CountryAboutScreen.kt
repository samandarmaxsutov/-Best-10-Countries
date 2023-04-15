package com.example.best10countriesapp.feature1.ui.screens.country

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.best10countriesapp.R
import com.example.best10countriesapp.databinding.FragmentCountryAboutScreenBinding
import com.example.best10countriesapp.databinding.FragmentHomeScreenBinding
import com.example.best10countriesapp.feature1.ui.screens.home.HomeScreenViewModel

class CountryAboutScreen : Fragment() {

    private var _binding: FragmentCountryAboutScreenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCountryAboutScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val viewModel: CountryAboutScreenViewModel by viewModels()

    private val args:CountryAboutScreenArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageViewMain2.setImageResource(args.country.image)
        binding.textTitle.text=args.country.name
        binding.locationTxt.text=args.country.name
        binding.text.text=args.country.aboutText
        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }

    }
}