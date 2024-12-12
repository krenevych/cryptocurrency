package com.kre.cryptocurrency.presentation

import android.content.Intent
import android.os.Bundle
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
    }

    private fun setupLiveData() {
        viewModel.remoteLiveData.observe(this) {
            adapter.submitList(it)
        }
    }

    private val adapter = CoinsAdapter()
    private fun setupCoinsRV() {
        binding.coinsLIst.layoutManager = LinearLayoutManager(this)
        binding.coinsLIst.adapter = adapter

        adapter.itemClickListener = object : CoinsAdapter.ItemClickListener {
            override fun onClick(id: Int) {
                Intent(this@MainActivity, DetailedCoinInfoActivity::class.java)
                    .apply {
                        putExtra(EXTRA_COIN_ID, id)
                    }.also {
                        startActivity(it)
                    }
            }

        }
    }

}