package com.gl.spring.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.gl.spring.ecommerce.Dto.OrderDTO;
import com.gl.spring.ecommerce.service.OrderServiceImpl;


@Controller
public class OrderController {

    private final OrderServiceImpl orderService;

    @Autowired
    public OrderController(OrderServiceImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/allOrders")
    public String listOfOrders(Model model) {
        List<OrderDTO> orders = orderService.findallOrders();
        model.addAttribute("orders", orders);
        return "ordersList";
    }

    @GetMapping("/addOrder")
    public String createOrderForm(Model model) {
        model.addAttribute("newOrder", new OrderDTO());
        return "createOrder";
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@ModelAttribute("newOrder") OrderDTO orderDto) {
        orderService.addOrder(orderDto);
        return "redirect:/allOrders";
    }

    @GetMapping("/order/edit/{id}")
    public String editOrderForm(@PathVariable("id") int orderId, Model model) {
        OrderDTO orderDto = orderService.getOrderById(orderId);
        model.addAttribute("orders", orderDto);
        return "editOrders";
    }

    @PostMapping("/updateOrder/{id}")
    public String updateOrder(@PathVariable("id") int id, @ModelAttribute("order") OrderDTO orderDto) {
        OrderDTO existingOrder = orderService.getOrderById(id);
        existingOrder.setOrder_id(id);
        existingOrder.setCustomer_name(orderDto.getCustomer_name());
        existingOrder.setOrder_date(orderDto.getOrder_date());
        existingOrder.setOrder_price(orderDto.getOrder_price());
        existingOrder.setOrder_stage(orderDto.getOrder_stage());
        existingOrder.setPayment_status(orderDto.getPayment_status());

        orderService.addOrder(existingOrder);
        return "redirect:/allOrders";
    }

    @GetMapping("/view/{id}")
    public String viewOrder(@PathVariable int id, Model model) {
        OrderDTO orderDto = orderService.getOrderById(id);
        model.addAttribute("order", orderDto);
        return "OrderDetails";
    }
    
    @PostMapping("/updateOrderStatus/{orderId}")
    public String updateOrderStatus(@RequestParam("status") String status, @PathVariable("orderId") int orderId, RedirectAttributes redirectAttributes) {
        try {
            OrderDTO order = orderService.getOrderById(orderId);
            if (order != null) {
                order.setOrder_stage(status);
                orderService.addOrder(order);
                redirectAttributes.addFlashAttribute("successMessage", "Order status updated successfully.");
            } else {
                redirectAttributes.addFlashAttribute("errorMessage", "Order not found.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Failed to update order status.");
        }
        return "redirect:/allOrders";
    }
}