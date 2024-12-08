package com.kre.cryptocurrency.data.local.model

import com.kre.cryptocurrency.data.local.model.CoinInfoEntity.Companion.toEntity
import com.kre.cryptocurrency.domain.coin.CoinInfo

fun entitiesToItems(entities: List<CoinInfoEntity>) = entities.map { it.toCoinInfo() }

fun coinsToEntities(coins: List<CoinInfo>) = coins.map { it.toEntity() }