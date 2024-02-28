package app

import app.model.FoodMenu
import app.datasource.FoodDataSourceImpl

class App() { //Constructor
    private var Food = FoodDataSourceImpl().getFoodList()
    lateinit var selectedMenu: FoodMenu
    private var userInputPayment: Int = -1
    private var userSelectedMethod: Int = -1
    fun run() {
        printHeader()
        getSelectedMenu()
        giveChange(selectedMenu)
        printDeliveryMenu()
        getDeliveryMethod()
        printDeliveryMethod()
    }

    private fun printHeader() {
        println("======================================")
        println("           List Menu Makanan")
        println("======================================")
        Food.forEachIndexed {index,data ->
            println("${index+1}.${data.foodName} : ${data.pricePortion}/porsi")
        }
    }

    private fun getSelectedMenu() {
        println("\nPilih Menu Makanan : ")
        try {
            val userInput = readln().toInt()
            if (userInput in 1..Food.size) {
                selectedMenu = Food[userInput - 1]
                println("Kamu memilih menu $userInput")
                println("Nama Menu : ${selectedMenu.foodName}")
                println("Harga\t: ${selectedMenu.pricePortion}")
                getPayment(selectedMenu)
            } else {
                println("Menu Anda Salah!")
                getSelectedMenu()
            }
        } catch (e: NumberFormatException) {
            println("Inputan salah mohon ulangi!")
            getSelectedMenu()
        }
    }

    private fun getPayment(userMenu: FoodMenu){
        println("\nMasukkan pembayaran : ")
        try {
            userInputPayment = readln().toInt()
        } catch (e: NumberFormatException) {
            println("Inputan salah mohon ulangi!")
            getPayment(selectedMenu)
        }
    }

    private fun giveChange(userMenu: FoodMenu){
        if (userInputPayment >= userMenu.price) {
            val change: Int = userInputPayment - userMenu.price
            println("Terima kasih, Anda berhasil memesan makanan")
            println("Uang kembalian = $change")
        } else {
            println("Maaf pembayaran Anda gagal!")
            getPayment(selectedMenu)
        }
    }

    private fun printDeliveryMenu(){
        println("\nMetode pengiriman makanan: ")
        println("1. Take Away")
        println("2. Delivery")
        println("Pilih metode pengiriman: ")
    }

    private fun getDeliveryMethod() {
        try {
            userSelectedMethod = readln().toInt()
        }catch (e: NumberFormatException) {
            println("Inputan salah mohon ulangi!")
            getDeliveryMethod()
        }
    }

    private fun printDeliveryMethod(){
        if(userSelectedMethod in 1 .. 2){
            when (userSelectedMethod) {
                1 -> showTakeAway()
                2 -> showDelivery()
            }
        } else {
            println("Inputan salah mohon ulangi!")
            getDeliveryMethod()
        }
    }

    private fun showTakeAway() {
        println("\nAnda memilih Take Away")
        println("Makananmu sedang dimasak (5 detik) .....")
        for (i in 1..5) {
            Thread.sleep(1000)
        }
        println("Makananmu sudah siap! Silakan ambil di resto ya! (5 detik) .....")
        for (i in 1..5) {
            Thread.sleep(1000)
        }
        println("Pesanan selesai! Terima kasih! (3 detik) ...")
        for (i in 1..3) {
            Thread.sleep(1000)
        }
    }

    private fun showDelivery(){
        println("\nAnda memilih Delivery")
        println("Makananmu sedang dimasak (5 detik) .....")
        for (i in 1..5) {
            Thread.sleep(1000)
        }
        println("Makananmu sudah siap! Driver segera menuju tempatmu! (5 detik) .....")
        for (i in 1..5) {
            Thread.sleep(1000)
        }
        println("Driver sampai! Pesanan selesai! (3 detik) ...")
        for (i in 1..3) {
            Thread.sleep(1000)
        }
    }

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}