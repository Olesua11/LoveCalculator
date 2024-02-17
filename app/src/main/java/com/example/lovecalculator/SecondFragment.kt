package com.example.lovecalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.lovecalculator.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(this)
            .load("https://i.pinimg.com/564x/08/11/a8/0811a81fbd17426d1a4fd173aa051ea1.jpg")
            .into(binding.imgSf)

        var result = arguments?.getString("result")
        var fname = arguments?.getString("fname")
        var sname = arguments?.getString("sname")
        var persantage = arguments?.getString("persantage")

        with(binding) {
            tvFirstName.text = fname.toString()
            tvSecondName.text = sname.toString()
            tvPercentage.text = persantage.toString()
            tvResult.text = result.toString()

            btnTryAgain.setOnClickListener {
                requireActivity().supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment()).commit()
            }
        }
    }
}