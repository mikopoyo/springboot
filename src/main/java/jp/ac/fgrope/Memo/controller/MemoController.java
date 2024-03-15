package jp.ac.fgrope.Memo.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.fgrope.Memo.model.MemoBook;
import jp.ac.fgrope.Memo.service.MemoBookService;

@Controller
public class MemoController {
	@Autowired
	private MemoBookService MemoBookService;
 
	@GetMapping("/top")
	public String index(Model model) {
		model.addAttribute("list",this.MemoBookService.getMemoList());
		// TODO: model.addAttributeに一覧取得結果を追加
		return "top";
	}
 
	@GetMapping("/add/")
	public ModelAndView add(MemoBook MemoBook, ModelAndView model) {
		model.addObject("Memobook", MemoBook);
		model.setViewName("form");
		return model;
	}
 
	@PostMapping("/add/")
	public String add(@Validated @ModelAttribute @NonNull MemoBook MemoBook, RedirectAttributes result, ModelAndView model,
			RedirectAttributes redirectAttributes) {
		try {
			this.MemoBookService.save(MemoBook);
			redirectAttributes.addFlashAttribute("exception", "");
 
		} catch (Exception e) {
			redirectAttributes.addFlashAttribute("exception", e.getMessage());
		}
		return "redirect:/";
	}
	@GetMapping("/syousai/{id}")
	public ModelAndView detail(@PathVariable(name = "id") Long id, MemoBook MemoBook, ModelAndView model) {
		model.addObject("detaillist", this.MemoBookService.get(id));
		model.setViewName("syousai");
		return model;
	}
	
	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable(name = "id") Long id, MemoBook ProductList, ModelAndView model) {
		this.MemoBookService.delete(id);
		model.setViewName("delete");
		return model;
		
	}
	
	
}