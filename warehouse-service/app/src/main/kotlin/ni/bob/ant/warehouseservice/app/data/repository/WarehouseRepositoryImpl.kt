package ni.bob.ant.warehouseservice.app.data.repository

import ni.bob.ant.warehouseservice.app.data.model.toEntity
import ni.bob.ant.warehouseservice.app.data.model.toModel
import ni.bob.ant.warehouseservice.core.entity.Identity
import ni.bob.ant.warehouseservice.core.entity.WarehouseItem
import ni.bob.ant.warehouseservice.usecase.gateway.WarehouseRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository

@Repository
class WarehouseRepositoryImpl(private val jpaRepository: JpaWarehouseRepository) : WarehouseRepository {

    override fun create(newWarehouseItem: WarehouseItem): WarehouseItem {
        require(newWarehouseItem.identity == Identity.new) { "New warehouse item is expected $newWarehouseItem" }
        return jpaRepository.save(newWarehouseItem.toModel()).toEntity()
    }

    override fun findByItemId(identity: Identity): WarehouseItem? {
        return jpaRepository.findByIdOrNull(identity.value)?.toEntity()
    }

    override fun findAll(): List<WarehouseItem> {
        return jpaRepository.findAll().map { it.toEntity() }
    }

    override fun save(item: WarehouseItem) {
        jpaRepository.save(item.toModel())
    }
}
