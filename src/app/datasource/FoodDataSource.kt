package app.datasource

import app.model.FoodMenu

interface FoodDataSource {
    fun getFoodList() : List<FoodMenu>
}

class FoodDataSourceImpl() : FoodDataSource {
    override fun getFoodList() : List<FoodMenu> {
        return listOf(
            FoodMenu(
                foodName = "Ayam Bakar",
                price = 50000,
                pricePortion = "Rp. 50.000"
            ), //food 1
            FoodMenu(
                foodName = "Ayam Goreng",
                price = 40000,
                pricePortion = "Rp. 40.000"
            ), //food 2
            FoodMenu(
                foodName = "Ayam Geprek",
                price = 40000,
                pricePortion = "Rp. 40.000"
            ), //food 3
            FoodMenu(
                foodName = "Kulit Ayam Krispi",
                price = 15000,
                pricePortion = "Rp. 15.000"
            ), //food 4
            FoodMenu(
                foodName = "Sate Usus Ayam",
                price = 5000,
                pricePortion = "Rp. 5.000"
            ) //food 5

        )
    }
}