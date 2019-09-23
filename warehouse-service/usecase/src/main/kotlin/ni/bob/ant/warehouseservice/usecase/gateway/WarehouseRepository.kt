package ni.bob.ant.warehouseservice.usecase.gateway

import ni.bob.ant.warehouseservice.usecase.usecase.CreateItemUseCase
import ni.bob.ant.warehouseservice.usecase.usecase.FindWarehouseItemUseCase
import ni.bob.ant.warehouseservice.usecase.usecase.GetAllWarehouseItemsUseCase
import ni.bob.ant.warehouseservice.usecase.usecase.ReplenishItemUseCase

interface WarehouseRepository:
        CreateItemUseCase.WarehouseRepository,
        FindWarehouseItemUseCase.WarehouseRepository,
        GetAllWarehouseItemsUseCase.WarehouseRepository,
        ReplenishItemUseCase.WarehouseRepository