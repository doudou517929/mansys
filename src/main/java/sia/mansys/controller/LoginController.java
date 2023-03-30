package sia.mansys.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import sia.mansys.exception.PasswordNotMatchException;
import sia.mansys.exception.UserNotFoundException;
import sia.mansys.model.User;
import sia.mansys.service.UserService;


@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String home(HttpServletRequest request, HttpServletResponse response, Model model) {
    	String userCode = "";
    	Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userCode")) {
                    userCode = cookie.getValue();
                    break;
                }
            }
        }
        model.addAttribute("userCode", userCode);
        return "login";
    }


    @PostMapping("/login")
    public ResponseEntity<?> loginAjax(@RequestParam String userCode, @RequestParam String password, HttpServletRequest request, HttpServletResponse response, HttpSession session, Model model) {
        User user = null;
        try {
            user = userService.findByCode(userCode, password);
        } catch (UserNotFoundException | PasswordNotMatchException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + e.getMessage() + "\"}");
        }
        Cookie cookie = new Cookie("userCode", userCode);
        cookie.setMaxAge(3600);
        cookie.setPath("/");
        response.addCookie(cookie);
        session.setAttribute("user", user);
        return ResponseEntity.ok().build();
    }
}
