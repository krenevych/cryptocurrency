package com.kre.cryptocurrency.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.kre.cryptocurrency.R
import com.kre.cryptocurrency.databinding.ActivityMainBinding
import com.kre.cryptocurrency.presentation.adapter.CoinsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupLiveData()
        setupCoinsRV()
        setupButtons()
    }

    override fun onStart() {
        super.onStart()

        viewModel.retrieve()
    }

    private fun setupLiveData() {
        viewModel.remoteLiveData.observe(this) {
            Log.d(TAG, "setupLiveData: $it")
            adapter.submitList(it)
        }
    }

    private fun setupButtons() {
        binding.buttonReceive.setOnClickListener {
            Log.d(TAG, "button click: ")
            viewModel.retrieve()
        }
    }

    private val adapter = CoinsAdapter()
    private fun setupCoinsRV() {
        binding.coinsLIst.layoutManager = LinearLayoutManager(this)
        binding.coinsLIst.adapter = adapter
    }

}