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
import com.example.best10countriesapp.feature1.model.repository.local.room.entities.CountryEntity
import com.example.best10countriesapp.feature1.ui.screens.home.HomeScreenViewModel

class CountryAboutScreen : Fragment(R.layout.fragment_country_about_screen) {

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

    private val args: CountryAboutScreenArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.imageViewMain2.setImageResource(
            args.country.image)
        binding.textTitle.text = args.country.name
        binding.locationTxt.text = args.country.name
        binding.text.text = args.country.aboutText
        viewModel.fav=args.country.favourite
        binding.backBtn.setOnClickListener {
            findNavController().navigateUp()
        }
        if (args.country.favourite) binding.likeButton.setImageResource(R.drawable.baseline_favorite_24)
        else binding.likeButton.setImageResource(R.drawable.unlike)
        binding.likeButton.setOnClickListener {
            viewModel.update(
                CountryEntity(
                    id=args.country.id,
                    name = args.country.name,
                    capital = args.country.capital,
                    image = args.country.image,
                    aboutText = args.country.aboutText,
                    location = args.country.location,
                    starts = args.country.starts,
                    favourite = !viewModel.fav
                )
            )
        }

        viewModel.getUiChange.observe(viewLifecycleOwner){
            viewModel.fav=it.favourite
            binding.imageViewMain2.setImageResource(it.image)
            binding.textTitle.text = it.name
            binding.locationTxt.text = it.name
            binding.text.text = it.aboutText
            if (it.favourite) binding.likeButton.setImageResource(R.drawable.baseline_favorite_24)
            else binding.likeButton.setImageResource(R.drawable.unlike)

        }

    }
}