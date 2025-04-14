package com.microservices;

import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    // Create a new order
    public Order createOrder(OrderRequest orderRequest) throws Exception {
        List<OrderItem> orderItems = orderRequest.orderItems().stream().map(orderItemRequest ->
                OrderItem.builder()
                        .order(null)
                        .productId(orderItemRequest.productId())
                        .quantity(orderItemRequest.quantity())
                        .build()
        ).collect(Collectors.toList());
        validateCustomer(orderRequest.customerId());
        Order order = Order.builder().customerId(orderRequest.customerId()).orderItems(orderItems).build();
        orderItems.forEach(orderItem -> orderItem.setOrder(order));
        return orderRepository.save(order);
    }

    private void validateCustomer(Integer customerId) throws Exception {
        customerClient.findById(customerId).orElseThrow(() -> new Exception("Customer not found"));
    }

    // Get all orders
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Get a specific order by ID
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }

    // Update an existing order
    public Optional<Order> updateOrder(Integer id, OrderRequest orderRequest) {
        return orderRepository.findById(id).map(order -> {
            // Update orderItems
            List<OrderItem> orderItems = orderRequest.orderItems().stream().map(orderItemRequest ->
                    OrderItem.builder()
                            .order(order)
                            .productId(orderItemRequest.productId())
                            .quantity(orderItemRequest.quantity())
                            .build()
            ).collect(Collectors.toList());
            order.setOrderItems(orderItems);
            order.setCustomerId(orderRequest.customerId());
            return orderRepository.save(order);
        });
    }

    // Delete an order
    public void deleteOrder(Integer id) {
        orderRepository.deleteById(id);
    }
}
