package ni.bob.ant.orderservice.core.entity

data class Identity(val value: Long) {

    companion object {
        val new = Identity(0)
    }
}
