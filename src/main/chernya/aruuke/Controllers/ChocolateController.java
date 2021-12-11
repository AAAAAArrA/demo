package aruuke.Controllers;

import aruuke.DAO.ALL_DATA;
import aruuke.Models.all_choc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.sql.SQLException;

@Controller
@RequestMapping("/chocolate")
public class ChocolateController {
    private final ALL_DATA chocolateDAO;
    @Autowired
    //Внедряем зависимость ALL_DATA, чтобы получать информацию о шоколаде
    public ChocolateController(ALL_DATA chocolateDAO) {
        this.chocolateDAO = chocolateDAO;
    }
    @GetMapping()
    //Получение всех шоколадов из ALL_DATA и передача на отображение
    public  String display(Model model) throws SQLException, InterruptedException {
        model.addAttribute("chocolateList", chocolateDAO.display());
        return "/chocolate/display";
    }
    @GetMapping("/home")
    public String home(){
        return "/chocolate/main";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        model.addAttribute("all_choc", chocolateDAO.show(id));
        return "/chocolate/show";
    }

    @GetMapping("/new")
    public String newChoc(Model model){
        model.addAttribute("all_choc", new all_choc());
        return "/chocolate/new";
    }

    @PostMapping
    public String create(@ModelAttribute("all_choc") all_choc all_choc){
        chocolateDAO.save(all_choc);
        return "redirect:/chocolate";

    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id){
        model.addAttribute("all_choc", chocolateDAO.show(id));
        return "/chocolate/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("all_choc")all_choc all_choc, @PathVariable("id")int id){
        chocolateDAO.update(id, all_choc);
        return "redirect:/chocolate";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id){
        chocolateDAO.delete(id);
        return "redirect:/chocolate";
    }
}

