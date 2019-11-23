package ni.bob.ant.orderservice.usecase.gateway

import ni.bob.ant.orderservice.usecase.usecase.ChangeOrderStatusUseCase

interface OrderStateRepository :
        ChangeOrderStatusUseCase.OrderStateRepository
