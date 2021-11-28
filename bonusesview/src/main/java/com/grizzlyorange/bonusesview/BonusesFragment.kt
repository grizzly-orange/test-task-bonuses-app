package com.grizzlyorange.bonusesview

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.grizzlyorange.bonusesview.databinding.FragmentBonusesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BonusesFragment : Fragment() {

    private var _binding: FragmentBonusesBinding? = null
    private val binding get() = _binding!!

    private val bonusesViewModel: BonusesViewModel by viewModels<BonusesViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentBonusesBinding.inflate(inflater, container, false)

        binding.bonusesVM = bonusesViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }
}