package ni.bob.ant.warehouseservice.app.data.repository

import ni.bob.ant.warehouseservice.core.entity.Identity
import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import ni.bob.ant.warehouseservice.usecase.gateway.WarehouseRepository
import org.springframework.stereotype.Repository

@Repository
class WarehouseRepositoryImpl(private val warehouseRepository: JpaWarehouseRepository) : WarehouseRepository {

    override fun create(newWarehouseItem: WarehouseItem): WarehouseItem {
        require(newWarehouseItem.identity == Identity.new) { "New warehouse item expected $newWarehouseItem" }
        TODO()
    }

    override fun findByItemId(identity: Identity): WarehouseItem? {
        TODO()
    }

    override fun findAll(): List<WarehouseItem> {
        return warehouseRepository.findAll().map { TODO() }
    }

    override fun save(item: WarehouseItem) {
        TODO()
    }
}
