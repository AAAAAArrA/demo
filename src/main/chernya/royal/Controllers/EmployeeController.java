package royal.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import royal.DAO.ALL_DATA;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final ALL_DATA employeeDAO;
    @Autowired
    public EmployeeController(ALL_DATA employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @GetMapping
    public String emp_list(Model model){
        model.addAttribute("employee", employeeDAO.empl_display());
        return "chocolate/employee";
    }
    @GetMapping("/about")
    public String about(){
        return "chocolate/About";
    }
}
