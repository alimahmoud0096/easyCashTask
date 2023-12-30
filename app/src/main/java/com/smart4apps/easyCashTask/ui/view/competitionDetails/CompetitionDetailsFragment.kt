package com.smart4apps.easyCashTask.ui.view.competitionDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.smart4apps.easyCashTask.databinding.FragmentCompetitionDetailsBinding
import com.smart4apps.easyCashTask.ui.adapter.CompetitionsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CompetitionDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class CompetitionDetailsFragment : Fragment() {

    private val args by navArgs<CompetitionDetailsFragmentArgs>()

    @Inject
    lateinit var adapter: CompetitionsAdapter

    private var _binding: FragmentCompetitionDetailsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCompetitionDetailsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }


    private fun init() {
        binding.lifecycleOwner=viewLifecycleOwner
        binding.item=args.competition

    }


}