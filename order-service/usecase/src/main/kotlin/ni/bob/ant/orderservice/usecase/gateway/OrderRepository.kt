package ni.bob.ant.orderservice.usecase.gateway

import ni.bob.ant.orderservice.usecase.usecase.*

interface OrderRepository :
        ChangeOrderStatusUseCase.OrdersRepository,
        GetAllOrdersUseCase.OrderRepository,
        FindOrderUseCase.OrderRepository,
        AddOrderItemUseCase.OrderRepository,
        PerformPaymentUseCase.PaymentRepository