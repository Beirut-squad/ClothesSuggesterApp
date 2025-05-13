package org.example.data.repository

import org.example.logic.models.Outfit

interface OutfitsDataSource {
    fun getFreezingOutfits(): List<Outfit>
    fun getColdOutfits(): List<Outfit>
    fun getAverageOutfits(): List<Outfit>
    fun getWarmOutfits(): List<Outfit>
    fun getHotOutfits(): List<Outfit>
    fun getDeathOutfits(): List<Outfit>
}