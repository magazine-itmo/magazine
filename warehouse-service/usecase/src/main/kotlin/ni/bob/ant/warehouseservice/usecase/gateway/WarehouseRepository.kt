package ni.bob.ant.warehouseservice.usecase.gateway

import ni.bob.ant.warehouseservice.usecase.usecase.CreateWarehouseItemUseCase
import ni.bob.ant.warehouseservice.usecase.usecase.FindWarehouseItemUseCase
import ni.bob.ant.warehouseservice.usecase.usecase.GetAllWarehouseItemsUseCase
import ni.bob.ant.warehouseservice.usecase.usecase.ReplenishItemUseCase

interface WarehouseRepository :
        CreateWarehouseItemUseCase.WarehouseRepository,
        FindWarehouseItemUseCase.WarehouseRepository,
        GetAllWarehouseItemsUseCase.WarehouseRepository,
        ReplenishItemUseCase.WarehouseRepository