import kotlin.random.Random

fun showMenu(menu: List<MenuItem>) {
    println("***************************************")
    menu.forEach {
        println("${it.id}. ${it.name} | ${it.price} تومان | ${it.category}")
    }
    println("***************************************")
    println("\n")

}

fun addToCart(menu: List<MenuItem>, cart: MutableList<OrderItem>) {
    while (true) {
        println("برگشت:0")
        println("شماره غذای مورد نظر را وارد کنید:")
        val foodNum = readln().toInt()
        if(foodNum == 0) return
        println("تعداد را وارد کنید:")
        val quantity = readln().toInt()
        if (foodNum in (1..menu.size)) {
        menu.forEach {
            if(it.id==foodNum){
                val foundedItem =OrderItem(it,quantity)
                println("${it.id}. ${it.name} | ${it.price} | ${it.category} | ${foundedItem.quantity}X")
                println("اضافه شد به سبد خرید")
                cart.add(foundedItem)
            }
        }

        } else {
            return
        }

    }

}
fun removeFromCart(menu: List<MenuItem>, cart: MutableList<OrderItem>) {
    while (true) {

        showCart(cart)
        println("برگشت: 0")
        println("شماره غذای مورد نظر جهت حذف را وارد کنید:")

        val foodNum = readln().toInt()
        if (foodNum == 0) return

        val itemInCart = cart.find { it.menuItem.id == foodNum }

        if (itemInCart != null) {
            println("${itemInCart.menuItem.id}. ${itemInCart.menuItem.name} | ${itemInCart.menuItem.price} | ${itemInCart.menuItem.category} | ${itemInCart.quantity}X")
            println("از سبد خرید حذف شد")

            cart.remove(itemInCart)

        } else {
            println(" آیتمی با این شماره در سبد خرید وجود ندارد")
        }
    }
}



fun showCart(cart: MutableList<OrderItem>) {
    if (cart.isEmpty()) {
        println("سبد شما خالی است!"); return
    }
    println("***************************************")

    println("لیست سفارشات شما:")
    cart.forEach {
        println(".${it.menuItem.id} | ${it.menuItem.category} | ${it.menuItem.name} | ${it.menuItem.price}  | ${it.quantity}X")
        println(it.totalPrice())

    }
    println("***************************************")

}
fun checkout(cart: MutableList<OrderItem>) {
    println("********** نهایی کردن خرید **********")
    if (cart.isEmpty()){
        println("سبد شما خالی است!")
        return
    }
    while (true){
        val discount= Random(System.currentTimeMillis()).nextInt(10,50)
        showCart(cart)
        println("برگشت:0")
        println("جهت نهایی کردن خرید * را وارد کنید")
        var cmd= readln().toString()
        when (cmd) {
            "0" -> return
            "*" -> {
                println("********** فاکتور نهایی **********")
                var fullCartPrice = cart.sumOf {
                    it.totalPrice()
                }
                if (fullCartPrice > 500000.0) {
                    showCart(cart)
                    fullCartPrice = ((fullCartPrice - discount) / 100)
                    println("\n")
                    println("*****************************")
                    println("میزان تخفیف از این خرید: $discount%")
                    println("جمع کل قابل پرداخت: $fullCartPrice")
                    println("*****************************")
                } else {
                    showCart(cart)
                    println("\n")
                    println("*****************************")
                    println("جمع کل قابل پرداخت: $fullCartPrice")
                    println("*****************************")
                }

                cart.clear()
                println("##################################")
                println("با تشکر از خرید شما مشتری عزیز")
                println("سبد شما خالی شد!")
                println("##################################")
                return


            }
        }
    }




}
