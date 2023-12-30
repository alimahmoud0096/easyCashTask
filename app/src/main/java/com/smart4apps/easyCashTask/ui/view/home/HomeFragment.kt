package com.smart4apps.easyCashTask.ui.view.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.smart4apps.easyCashTask.BuildConfig
import com.smart4apps.easyCashTask.data.model.Competition
import com.smart4apps.easyCashTask.databinding.FragmentHomeBinding
import com.smart4apps.easyCashTask.ui.adapter.CompetitionsAdapter
import com.smart4apps.easyCashTask.ui.viewmodel.MainViewModel
import com.smart4apps.easyCashTask.utils.Utils
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class HomeFragment : Fragment(), CompetitionsAdapter.OnItemClickListeners {

    private val mainViewModel: MainViewModel by viewModels()

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var adapter: CompetitionsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //we used this condition to verify if app is authorized or not
        if (!BuildConfig.DEBUG) {
            Utils.verifyInstaller(requireContext(), Utils.Installer.GOOGLE_PLAY_STORE)?.let {
                if (it) {
                    init()
                    // App is installed from Google Play
                } else {
                    // App is not installed from Google Play
                    requireActivity().finish()
                }
            }
        } else {
            init()
        }

    }


    private fun init() {
        binding.viewModel = mainViewModel
        binding.lifecycleOwner=viewLifecycleOwner
        binding.rvCompetitions.adapter = adapter
        adapter.onItemClickListeners = this
        mainViewModel.getAllCompetitions()


    }


    override fun onCompetitionClicked(competition: Competition?) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToCompetitionDetailsFragment(
                competition
            )
        )
    }


}