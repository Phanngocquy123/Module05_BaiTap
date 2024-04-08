package com.crud.bai3.controller;

import com.crud.bai3.exception.NotFoundEntityException;
import com.crud.bai3.model.dto.ProductRequest;
import com.crud.bai3.model.entity.Product;
import com.crud.bai3.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final IProductService productService;
    @RequestMapping // mapping http://localhost:8888/
    public String home(Model model){
        model.addAttribute("productList",productService.getAll());
        return "home";
    }
    @RequestMapping("/add-new-product")
    public String add(){
        return "form-add";
    }
    @RequestMapping(value = "/do-add",method = RequestMethod.POST)
    public String doAdd(@ModelAttribute ProductRequest productRequest){
        Product product = productService.addProduct(productRequest);
        if (product!=null){
            return "redirect:/";
        }
        //  loi
        return "form-add";

    }
    @RequestMapping(value = "/do-edit",method = RequestMethod.POST)
    public String doEdit(@ModelAttribute("edit") Product productEdit, @RequestParam("file") MultipartFile file) throws NotFoundEntityException {
        Product product =productService.updateProduct(productEdit, file);
        if (product!=null){
            return "redirect:/";
        }
        //  loi
        return "form-add";

    }
    @RequestMapping("/delete")
    public String doDelete(@RequestParam("id") Long id) throws NotFoundEntityException {
        productService.findById(id); // kieam tra ton tai
        productService.deleteById(id);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id}")
    public String doEdit(@PathVariable Long id, Model model)throws NotFoundEntityException{
        Product p =  productService.findById(id); // kieam tra ton tai
        model.addAttribute("edit",p);
        return "form-edit";
    }
}
