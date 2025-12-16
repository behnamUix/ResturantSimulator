

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    val cart=mutableListOf<OrderItem>()
    while (true) {
        val menu = listOf(
                MenuItem(id = 1, name = "مرغ سوخاری (۲ تکه)", price = 180_000.0, category = "سوخاری"),
                MenuItem(id = 2, name = "مرغ سوخاری (۴ تکه)", price = 320_000.0, category = "سوخاری"),
                MenuItem(id = 3, name = "فیله سوخاری", price = 210_000.0, category = "سوخاری"),

                MenuItem(id = 4, name = "پیتزا پپرونی", price = 295_000.0, category = "پیتزا"),
                MenuItem(id = 5, name = "پیتزا مخصوص", price = 340_000.0, category = "پیتزا"),
                MenuItem(id = 6, name = "پیتزا سبزیجات", price = 260_000.0, category = "پیتزا"),

                MenuItem(id = 7, name = "چیزبرگر", price = 220_000.0, category = "برگر"),
                MenuItem(id = 8, name = "دوبل برگر", price = 290_000.0, category = "برگر"),
                MenuItem(id = 9, name = "برگر مرغ", price = 200_000.0, category = "برگر"),

                MenuItem(id = 10, name = "چلوکباب کوبیده", price = 250_000.0, category = "ایرانی"),
                MenuItem(id = 11, name = "جوجه کباب زعفرانی", price = 280_000.0, category = "ایرانی"),
                MenuItem(id = 12, name = "زرشک پلو با مرغ", price = 240_000.0, category = "ایرانی"),

                MenuItem(id = 13, name = "نوشابه", price = 25_000.0, category = "نوشیدنی"),
                MenuItem(id = 14, name = "دوغ محلی", price = 30_000.0, category = "نوشیدنی"),
                MenuItem(id = 15, name = "آب معدنی", price = 15_000.0, category = "نوشیدنی")
        )



        println(
            """
            ----------------------------------------
                    سامانه سفارش غذا
            ----------------------------------------
            1 - نمایش منو
            2 - افزودن غذا یا نوشیدنی به سبد خرید
            3 - مشاهده سبد خرید
            4 - حذف از سبذ خرید
            5 - نهایی‌سازی سفارش
            0 - خروج
            ----------------------------------------
            """.trimIndent()
        )
        println("لطفا یکی  از گزینه های بالا را انتخاب کنید:")
        when (readLine()) {
            "0" -> {
                print("بابت خرید از سامانه ما صمیمانه متشکریم:)")
                return
            }

            "1" -> {
                showMenu(menu)

            }
            "2" -> {
                addToCart(menu,cart)

            }
            "3" -> {
                showCart(cart)

            }
            "4" -> {
                removeFromCart(menu,cart)

            }
            "5" -> {
                checkout(cart)

            }
        }

    }
}





