package com.example.lancelotmatecrate.matecratedemoapp.matecrate

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.lancelotmatecrate.matecratedemoapp.databinding.ItemMatecrateBinding


/**
 * Created by lancelotmatecrate on 20.12.17.
 */
class MateCrateAdapter(val viewModel: MateCratesViewModel, val context : Context) : RecyclerView.Adapter<MateCrateAdapter.MateCrateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MateCrateViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ItemMatecrateBinding.inflate(inflater, parent, false)
        return MateCrateViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MateCrateViewHolder, position: Int) {
        val mateCrateViewModel = viewModel.getMateCrateViewModel(position)
        holder.binding.viewModel = mateCrateViewModel
    }

    override fun getItemCount() = viewModel.getNumberOfAnimals()

    class MateCrateViewHolder(val binding: ItemMatecrateBinding) : RecyclerView.ViewHolder(binding.root)
}