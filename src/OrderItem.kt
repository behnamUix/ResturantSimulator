class OrderItem(var menuItem: MenuItem,var quantity:Int=1) {

    fun totalPrice():Double {
        return quantity*menuItem.price
    }
}