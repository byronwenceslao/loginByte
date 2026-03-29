package com.example.login2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.login2.databinding.FragmentDetailBinding

class DonutDetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val donut = (activity as HomeActivity).donutSeleccionado

        if (donut != null) {
            binding.tvPostId.text = "ID: ${donut.id}"
            binding.tvTitle.text = donut.name
            binding.tvUserId.text = "Tipo: ${donut.type}  |  Precio: $${donut.ppu}"


            var textoBatters = "Batters:\n"
            for (batter in donut.batters.batter) {
                textoBatters += "  • ${batter.type}\n"
            }

            var textoToppings = "\nToppings:\n"
            for (topping in donut.topping) {
                textoToppings += "  • ${topping.type}\n"
            }

            binding.tvBody.text = textoBatters + textoToppings
        }
    }
}