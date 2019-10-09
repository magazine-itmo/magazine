package ni.bob.ant.warehouseservice.core.entity

data class Identity(val value: Long) {

    companion object {
        val new = Identity(0)
    }
}
