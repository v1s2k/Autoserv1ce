package CourseWork.Autoservice.controllers;

import CourseWork.Autoservice.models.Message;
import CourseWork.Autoservice.models.Product;
import CourseWork.Autoservice.models.ProductType;
import CourseWork.Autoservice.repo.MessageRepository;
import CourseWork.Autoservice.repo.ProductRepository;
import CourseWork.Autoservice.repo.ProductTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class MainController {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductTypeRepository productTypeRepository;
    @Autowired
    MessageRepository messageRepo;


    // home page
    @GetMapping("/")
    public String greeting(Model model) {
        model.addAttribute("name", "Главная страница");
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model){
        model.addAttribute("name","Авторизация");
        return "login";
    }




    @GetMapping("/products")
    public String products(Model model){


        Iterable<ProductType> types =productTypeRepository.findAll();
        Map<ProductType, List<Product>> map = new HashMap<>();

        types.forEach(type -> map.put(type, productRepository.findByProductType(type)));
        model.addAttribute("map", map);
        return "products";
    }

    @GetMapping("/products/{id}")
    public String productDetails(@PathVariable(value = "id") long id, Model model){
        Product product = productRepository.findById(id).orElse(null);

        Iterable<Message> messages = messageRepo.findAll();

        model.addAttribute("product", product);
        model.addAttribute("messages", messages);

        return "catalog/product";
    }



}
