package com.kre.cryptocurrency.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.kre.cryptocurrency.databinding.ItemCoinInfoBinding
import com.kre.cryptocurrency.domain.coin.CoinInfo
import com.squareup.picasso.Picasso

class CoinsAdapter : ListAdapter<CoinInfo, CoinsAdapter.ViewHolder>(CoinDiffUtil()) {

    class ViewHolder(
        val binding: ItemCoinInfoBinding,
    ) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        LayoutInflater.from(parent.context).inflate(R.layout.shop_item_disabled, parent, false)
        val binding =
            ItemCoinInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val coinInfo = getItem(position)

        with(holder.binding) {
            tvSymbols.text = "${coinInfo.name} (${coinInfo.id}) / ${coinInfo.toCurrency}"
            tvPrice.text = coinInfo.price.toString()
            tvLastUpdate.text = "Last update: " + coinInfo.lastUpdate

            Picasso.get().load(coinInfo.imageUrl).into(ivLogoCoin)
        }
    }

}