package com.example.aitest2.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.aitest2.databinding.FragmentSecondBinding
import com.example.aitest2.viewModels.UserViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[UserViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        lifecycleScope.launch {
            viewModel.getUsers().collect { users ->
                // Update UI with users data
                _binding?.textView?.text = users.joinToString { it.name }
            }
        }
        return _binding?.root
    }
}