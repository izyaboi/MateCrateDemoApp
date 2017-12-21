package com.example.lancelotmatecrate.matecratedemoapp.matecrate

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.lancelotmatecrate.matecratedemoapp.MateCrate
import io.reactivex.disposables.Disposable
import android.support.v7.widget.DividerItemDecoration
import com.example.lancelotmatecrate.matecratedemoapp.databinding.FragmentMateCrateBinding
import javax.inject.Inject

/**
 * Created by lancelotmatecrate on 20.12.17.
 */
class MateCrateFragment : Fragment() {

    @Inject
    lateinit var baseRepository: BaseRepository

    var disposable: Disposable? = null

    lateinit var viewModel: MateCratesViewModel
    lateinit var mateCrateAdapter: MateCrateAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        MateCrate.appComponent.inject(this)
        viewModel = MateCratesViewModel(baseRepository)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = FragmentMateCrateBinding.inflate(inflater!!)
        val layoutManager = LinearLayoutManager(context)

        mateCrateAdapter = MateCrateAdapter(viewModel, context)

        binding.animals.adapter = mateCrateAdapter
        binding.animals.layoutManager = layoutManager
        binding.animals.addItemDecoration(DividerItemDecoration(context, layoutManager.orientation))

        binding.viewModel = viewModel
        return binding.root
    }



    override fun onResume() {
        super.onResume()
        disposable = viewModel.loadAnimals(mateCrateAdapter::notifyDataSetChanged)
    }


    private fun notifyChanges() {
        mateCrateAdapter.notifyDataSetChanged()
    }
    override fun onDestroy() {
        super.onDestroy()
        disposable?.dispose()
    }
}