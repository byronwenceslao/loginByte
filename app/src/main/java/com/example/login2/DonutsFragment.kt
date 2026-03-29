package com.example.login2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.login2.databinding.FragmentDonutsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DonutsFragment : Fragment() {

    private lateinit var binding: FragmentDonutsBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDonutsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cargando.visibility = View.VISIBLE

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://private-1ca53c-training45.apiary-mock.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val api = retrofit.create(DonutsAPI::class.java)
                val donuts = api.getDonuts()

                withContext(Dispatchers.Main) {
                    binding.cargando.visibility = View.GONE

                    val adapter = DonutAdapter(donuts) { donut ->
                        (activity as HomeActivity).abrirDetalle(donut)
                    }
                    binding.listDonuts.layoutManager = LinearLayoutManager(requireContext())
                    binding.listDonuts.adapter = adapter
                }

            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    binding.cargando.visibility = View.GONE
                    Snackbar.make(binding.root, "Error: ${e.message}", Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }
}