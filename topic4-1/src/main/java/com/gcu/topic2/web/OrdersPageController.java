package com.gcu.topic2.web;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import com.gcu.topic2.data.DataAccessInterface;
import com.gcu.topic2.model.OrderModel;
import java.util.List;

@Controller
public class OrdersPageController {
    @Autowired
    private DataAccessInterface<OrderModel> service; // wired to OrdersDataService

    @GetMapping("/orders")
    public String orders(Model model) {
        List<OrderModel> orders = service.findAll();
        model.addAttribute("orders", orders);
        return "orders";
    }
}