package org.example.data.datasource

import org.example.data.repository.OutfitsDataSource
import org.example.logic.models.extra_models.Outfit

class OutfitsDataSourceImpl : OutfitsDataSource {
    override fun getFreezingOutfits(): List<Outfit> {
        return listOf(
            Outfit("Wool Hat", "Thermal Jacket", "Fleece Pants", "Snow Boots"),
            Outfit("Beanie", "Puffer Coat", "Thick Jeans", "Insulated Boots"),
            Outfit("Ear Muffs", "Down Jacket", "Thermal Leggings", "Heavy-duty Boots"),
            Outfit("Balaclava", "Parkha", "Snow Pants", "Winter Boots"),
            Outfit("Knit Cap", "Heavy Hoodie", "Thermal Pants", "Lug Sole Boots"),
            Outfit("Ski Mask", "Insulated Coat", "Sweatpants", "Snow Shoes"),
            Outfit("Fur Hat", "Layered Sweaters", "Lined Jeans", "Insulated Sneakers"),
            Outfit("Ear Warmers", "Fleece Coat", "Wool Pants", "Hiking Boots")
        )
    }

    override fun getColdOutfits(): List<Outfit> {
        return listOf(
            Outfit("Cap", "Wool Sweater", "Jeans", "Leather Boots"),
            Outfit("Hood", "Coat", "Corduroy Pants", "Sneakers"),
            Outfit("Scarf", "Bomber Jacket", "Joggers", "High-top Shoes"),
            Outfit("Knit Hat", "Fleece Pullover", "Thick Pants", "Combat Boots"),
            Outfit("Flat Cap", "Turtleneck Sweater", "Chinos", "Ankle Boots"),
            Outfit("Ear Warmers", "Trench Coat", "Work Pants", "Chelsea Boots"),
            Outfit("Baseball Cap", "Thick Hoodie", "Denim", "Running Shoes"),
            Outfit("Wool Hat", "Windbreaker", "Canvas Pants", "Suede Boots")
        )
    }

    override fun getAverageOutfits(): List<Outfit> {
        return listOf(
            Outfit("Baseball Cap", "Hoodie", "Chinos", "Casual Shoes"),
            Outfit("Scarf", "Light Jacket", "Denim", "Loafers"),
            Outfit("Flat Cap", "Sweatshirt", "Cargo Pants", "Skate Shoes"),
            Outfit("Bandana", "Windbreaker", "Jeans", "Trainers"),
            Outfit("Bucket Hat", "Zip-up Jacket", "Athletic Pants", "Tennis Shoes"),
            Outfit("Cap", "Pullover", "Drawstring Pants", "Canvas Sneakers"),
            Outfit("Beret", "Long Sleeve Shirt", "Slim-fit Pants", "Derby Shoes"),
            Outfit("Sun Visor", "Denim Jacket", "Khakis", "Sport Shoes")
        )
    }

    override fun getWarmOutfits(): List<Outfit> {
        return listOf(
            Outfit("Cap", "T-Shirt", "Shorts", "Sandals"),
            Outfit("Bucket Hat", "Polo Shirt", "Cargo Shorts", "Sneakers"),
            Outfit("Headband", "Linen Shirt", "Cotton Shorts", "Slip-ons"),
            Outfit("Light Cap", "Short Sleeve Shirt", "Jogger Shorts", "Canvas Shoes"),
            Outfit("Sun Hat", "Breezy Shirt", "Light Trousers", "Boat Shoes"),
            Outfit("Visor", "Hawaiian Shirt", "Swim Shorts", "Slides"),
            Outfit("Snapback", "V-neck Tee", "Bermuda Shorts", "Espadrilles"),
            Outfit("Flat Cap", "Mesh Tee", "Chino Shorts", "Walking Shoes")
        )
    }

    override fun getHotOutfits(): List<Outfit> {
        return listOf(
            Outfit("Sun Hat", "Tank Top", "Light Shorts", "Flip-Flops"),
            Outfit("None", "Sleeveless Shirt", "Swim Trunks", "Slides"),
            Outfit("Visor", "Dry-Fit Shirt", "Sport Shorts", "Water Shoes"),
            Outfit("Baseball Cap", "Mesh Shirt", "Board Shorts", "Barefoot or Sandals"),
            Outfit("Light Bandana", "Workout Tank", "Running Shorts", "Minimal Sandals"),
            Outfit("None", "Open Shirt", "Light Swim Shorts", "Foam Flip-Flops"),
            Outfit("Cap", "Jersey Top", "Biker Shorts", "Slide Sandals"),
            Outfit("Sun Visor", "Athletic Tee", "Polyester Shorts", "Crocs")
        )
    }

    override fun getDeathOutfits(): List<Outfit> {
        return listOf(
            Outfit("Death Coat", "Death Coat", "Death Coat", "Death Coat")
        )
    }
}
