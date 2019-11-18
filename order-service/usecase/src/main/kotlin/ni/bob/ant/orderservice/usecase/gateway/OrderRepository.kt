package ni.bob.ant.orderservice.usecase.gateway

import ni.bob.ant.orderservice.usecase.usecase.AddOrderItemUseCase
import ni.bob.ant.orderservice.usecase.usecase.ChangeOrderStatusUseCase
import ni.bob.ant.orderservice.usecase.usecase.FindOrderUseCase
import ni.bob.ant.orderservice.usecase.usecase.GetAllOrdersUseCase

interface OrderRepository :
        ChangeOrderStatusUseCase.OrdersRepository,
        GetAllOrdersUseCase.OrderRepository,
        FindOrderUseCase.OrderRepository,
        AddOrderItemUseCase.OrderRepository