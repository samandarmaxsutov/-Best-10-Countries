package com.example.best10countriesapp.feature1.ui.screens.favourite

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.best10countriesapp.R
import com.example.best10countriesapp.databinding.FragmentFavouriteScreenBinding
import com.example.best10countriesapp.databinding.FragmentHomeScreenBinding
import com.example.best10countriesapp.feature1.ui.screens.adapter.CityAdapter
import com.example.best10countriesapp.feature1.ui.screens.home.HomeScreenDirections
import com.example.best10countriesapp.feature1.ui.screens.home.HomeScreenViewModel

class FavouriteScreen : Fragment(R.layout.fragment_favourite_screen) {

    private var _binding: FragmentFavouriteScreenBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavouriteScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private val viewModel: FavouriteScreenViewModel by viewModels()
    private val adapter= CityAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        binding.list.layoutManager = layoutManager
        binding.list.adapter=adapter
        viewModel.countriesLiveData.observe(viewLifecycleOwner){
            adapter.submitItems(it)
        }
        adapter.onClick{viewModel.open(it)}

        binding.backBtn.setOnClickListener { findNavController().navigateUp() }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.openCountryScreenLiveData.observe(this){
            findNavController().navigate(FavouriteScreenDirections.actionFavouriteScreenToCountryAboutScreen(it))
        }
    }
}