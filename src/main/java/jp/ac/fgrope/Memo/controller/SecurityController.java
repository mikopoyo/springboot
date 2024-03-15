package jp.ac.fgrope.Memo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.ac.fgrope.Memo.service.MemoBookService;
 
@Controller
public class SecurityController{

@Autowired
private MemoBookService MemoBookService;

@GetMapping("/")
public String index(Model model) {
	model.addAttribute("list",this.MemoBookService.getMemoList());
	// TODO: model.addAttributeに一覧取得結果を追加
	return "top";
}
@RequestMapping("/secret")
public ModelAndView secret (ModelAndView mav, HttpServletRequest request) {
String user = request.getRemoteUser();
String msg = "This is secret page. [login by \"" + user + "\"]";
mav.setViewName("Secret");
mav.addObject("title", "Secret page");
mav.addObject("msg", msg);
return mav;
}

@RequestMapping("/logout")
public String logout(HttpServletRequest request, HttpServletResponse response) {
    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
    if (auth != null) {
        new SecurityContextLogoutHandler().logout(request, response, auth);
    }
    return "top"; // Redirect to the home page after logout
}
}