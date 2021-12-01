package com.grizzlyorange.bonusesview.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.google.android.material.snackbar.Snackbar
import com.grizzlyorange.bonusesview.R
import com.grizzlyorange.bonusesview.databinding.FragmentBonusesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BonusesFragment : Fragment(), BonusesUserActionsHandler {

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

        initBinding()
        initObservers()

        return binding.root
    }

    private fun initBinding() {
        binding.bonusesVM = bonusesViewModel
        binding.userActionsHandler = this
        binding.lifecycleOwner = viewLifecycleOwner
    }

    private fun initObservers() {
        bonusesViewModel.isError.observe(viewLifecycleOwner, { errorEvent ->
            errorEvent.getContentIfNotHandled()?.let { messageId ->
                showSnackbar(messageId)
            }
        })
    }

    override fun onBtInfoClicked() {
        showSnackbar(R.string.messageOnDummyBtClicked)
    }

    override fun onBtNextClicked() {
        showSnackbar(R.string.messageOnDummyBtClicked)
    }

    override fun onFireClicked() {
        showSnackbar(R.string.messageOnFireClicked)
    }

    private fun showSnackbar(messageId: Int) {
        view?.let {
            Snackbar
                .make(binding.bottom, messageId, Snackbar.LENGTH_LONG)
                .setAnchorView(binding.messagesAnchor)
                .show()
        }
    }
}