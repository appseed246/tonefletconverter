package com.example.tonefletconverter.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.tonefletconverter.R
import com.example.tonefletconverter.databinding.MainFragmentBinding
import com.example.tonefletconverter.model.TestState

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = DataBindingUtil.inflate<MainFragmentBinding>(
            inflater,
            R.layout.main_fragment,
            container,
            false
        )

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel

        // 出題状態に応じてボタンに表示する文字を切り替える
        button = binding.root.findViewById(R.id.button)
        viewModel.state.observe(viewLifecycleOwner, Observer {
            val stringRes = when (it) {
                TestState.Question -> R.string.button_name_on_question
                TestState.Answer -> R.string.button_name_on_answer
                else -> throw IllegalStateException("invalid status: $it")
            }
            button.text = getString(stringRes)
        })

        return binding.root
    }
}
