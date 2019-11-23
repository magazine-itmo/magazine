package ni.bob.ant.orderservice.app.controller

import ni.bob.ant.orderservice.app.dto.OrderItemRequest
import ni.bob.ant.orderservice.app.dto.OrderResponse
import ni.bob.ant.orderservice.app.dto.toResponse
import ni.bob.ant.orderservice.usecase.dto.ItemDto
import ni.bob.ant.orderservice.usecase.usecase.AddOrderItemUseCase
import ni.bob.ant.orderservice.usecase.usecase.ChangeOrderStatusUseCase
import ni.bob.ant.orderservice.usecase.usecase.FindOrderUseCase
import ni.bob.ant.orderservice.usecase.usecase.GetAllOrdersUseCase
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("api/orders")
class OrderController(
    private val changeOrderStatusUseCase: ChangeOrderStatusUseCase,
    private val getAllOrdersUseCase: GetAllOrdersUseCase,
    private val findOrderUseCase: FindOrderUseCase,
    private val addOrderItemUseCase: AddOrderItemUseCase
) {

    @GetMapping
    fun getAllOrders(): List<OrderResponse> = getAllOrdersUseCase.execute().map { it.toResponse() }

    @GetMapping("/{id}")
    fun getOrderById(@PathVariable id: Long): OrderResponse = findOrderUseCase.execute(id).toResponse()

    @PutMapping("/{id}/status/{status}")
    fun changeOrderStatus(@PathVariable id: Long, @PathVariable status: String): OrderResponse =
            changeOrderStatusUseCase.execute(id, status).toResponse()

    @PostMapping("/{id}/item")
    fun addItemToOrder(@PathVariable id: Long, @RequestBody request: OrderItemRequest): Long {
        return addOrderItemUseCase.execute(id, ItemDto(request.id, request.amount)).id
    }
}
