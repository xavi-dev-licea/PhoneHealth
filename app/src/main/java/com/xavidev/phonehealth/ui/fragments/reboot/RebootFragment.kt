package com.xavidev.phonehealth.ui.fragments.reboot

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.xavidev.phonehealth.databinding.FragmentRebootBinding

/**
 * A simple [Fragment] subclass.
 * Use the [RebootFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RebootFragment : Fragment() {

    private var _binding: FragmentRebootBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRebootBinding.inflate(inflater, container, false)
        return binding.root
    }

}