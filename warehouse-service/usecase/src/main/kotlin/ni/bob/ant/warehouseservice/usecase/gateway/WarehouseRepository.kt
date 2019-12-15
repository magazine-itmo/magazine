package ni.bob.ant.warehouseservice.usecase.gateway

import ni.bob.ant.warehouseservice.usecase.usecase.*

interface WarehouseRepository :
        CreateWarehouseItemUseCase.WarehouseRepository,
        FindWarehouseItemUseCase.WarehouseRepository,
        GetAllWarehouseItemsUseCase.WarehouseRepository,
        ReplenishItemUseCase.WarehouseRepository,
        ReservationItemUseCase.ReservationRepository