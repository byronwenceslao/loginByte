package com.example.login2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.login2.databinding.ListadoDonutsBinding

class DonutAdapter(
    private val lista: List<Donut>,
    private val onClick: (Donut) -> Unit
) : RecyclerView.Adapter<DonutAdapter.MiViewHolder>() {

    inner class MiViewHolder(val binding: ListadoDonutsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        val binding = ListadoDonutsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MiViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        val donut = lista[position]

        holder.binding.tvPostTitle.text = donut.name
        holder.binding.tvPostId.text = donut.id

        holder.binding.root.setOnClickListener {
            onClick(donut)
        }
    }

    override fun getItemCount() = lista.size
}