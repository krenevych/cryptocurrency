package com.kre.cryptocurrency.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.kre.cryptocurrency.domain.coin.CoinInfo


class CoinDiffUtil : DiffUtil.ItemCallback<CoinInfo>() {
    override fun areItemsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CoinInfo, newItem: CoinInfo): Boolean {
        return oldItem == newItem
    }
}