package sia.mansys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeManageController {
    @GetMapping("/employeeManage")
    public String employeeManage(HttpServletRequest request, HttpServletResponse response, Model model) {

        
        return "employeeManage";
    }
}
