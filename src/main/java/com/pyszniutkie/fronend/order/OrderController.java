package com.pyszniutkie.fronend.order;

import com.pyszniutkie.backend.order.Address;
import com.pyszniutkie.backend.order.Bill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // TODO: 06.01.2022 REDIRECTS!
    @PostMapping("/order")
    public String sendOrder(@RequestParam Map<String,String> order, Model model, RedirectAttributes redirectAttributes) {
      return   sendForm(order, model, redirectAttributes);
    }

    @GetMapping("order-resend")
    public String sendForm(@RequestParam Map<String,String> order, Model model, RedirectAttributes redirectAttributes){
        try {
            Bill bill = orderService.sendDishesOrder(order);
            model.addAttribute("bill", bill);
            model.addAttribute("address",new Address());
            return "order-address-form";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorText",e.getMessage());
            //wstawić info o wyjątku na stronę i wrócić do listy dań
            return "redirect:/dishes";
        }
    }

    @PostMapping("/order-finish")
    public String finishOrder(@Valid @ModelAttribute("address") Address address,BindingResult bindingResult,  int orderId,Model model) {
      //  Address address = new Address(fullName, street, city, postCode);
        if (bindingResult.hasErrors()) {
            return "redirect:/order";
        }
        orderService.finishDishOrder(address, orderId);
        model.addAttribute("message","Potrawa zamówiona, będzie u Ciebie za 30 min!");
        return "index";
    }


    //metoda reagujaca na akcje forma z poprzedniej metody
}


//wybrór dań
//front: zebrałem wybrane dania, wysyłam do backendu
//backend: ok, dania są poprawne, przydzielam id zapisując do bazy danych ze statsem "niedokończone zamowienie"
//dostawa i płatność
//front: powiadamiam ousera ze wszystko ok i ma podać dane adresowe
//front: po pobraniu adresowych wysyłam dane do dokończenia zamówienia z informacja ktorych poraw (id) dotyczyło
//backend: kontroluje dane adresowe i ostatecznie zatwierdza zamówienie


//html -> front controller -> front service -> client -> backend controller -> backend service -> backend repo