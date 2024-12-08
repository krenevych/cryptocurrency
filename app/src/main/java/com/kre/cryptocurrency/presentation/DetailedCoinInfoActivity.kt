package com.kre.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.kre.cryptocurrency.databinding.CoinDetailBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailedCoinInfoActivity : AppCompatActivity() {

    private val binding by lazy {
        CoinDetailBinding.inflate(layoutInflater)
    }

    private val viewModel by viewModels<DetailedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        parseIntent()
        setupLiveData()
    }

    private var coinId: Int = UNDEFINED_COIN_ID
    private fun parseIntent() {
        if (intent.hasExtra(EXTRA_COIN_ID)) {
            coinId = intent.getIntExtra(EXTRA_COIN_ID, UNDEFINED_COIN_ID)
            if (coinId == UNDEFINED_COIN_ID) {
                throw IllegalStateException("coin id isn't defined ")
            }
        } else {
            throw IllegalStateException("coin id isn't defined ")
        }
    }

    private fun setupLiveData() {
        viewModel.getCoinInfo(coinId).observe(this) {coinInfo ->
//        viewModel.remoteLiveData.observe(this) {
            with(binding) {
//                val coinInfo = it.filter {
//                    it.id == coinId
//                }.first()

                Picasso.get().load(coinInfo.imageUrl).into(ivLogoCoin)
                tvFromSymbol.text = coinInfo.name
                tvToSymbol.text = coinInfo.toCurrency
                tvPrice.text = coinInfo.price.toString()
                tvLastUpdate.text = coinInfo.lastUpdate
            }
        }
    }

}