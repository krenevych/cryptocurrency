package com.kre.cryptocurrency.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kre.cryptocurrency.domain.coin.CoinBaseInfo


class CoinDiffUtil : DiffUtil.ItemCallback<CoinBaseInfo>() {
    override fun areItemsTheSame(oldItem: CoinBaseInfo, newItem: CoinBaseInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CoinBaseInfo, newItem: CoinBaseInfo): Boolean {
        return oldItem == newItem
    }
}