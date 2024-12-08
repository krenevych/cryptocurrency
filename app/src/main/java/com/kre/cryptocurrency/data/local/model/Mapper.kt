package com.kre.cryptocurrency.data.local.model

fun entitiesToItems(entities: List<CoinInfoEntity>) = entities.map { it.toCoinInfo() } // functional approach