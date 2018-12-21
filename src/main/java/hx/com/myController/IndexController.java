package hx.com.myController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.ModelAndView;


import hx.com.modle.User;
import hx.com.services.IService;
import net.sf.json.JSONArray;

/**@version:
 * @Description: 
 * @author: sun
 * @date: 2018年11月21日 下午2:43:05
 *
 */
@Controller
public class IndexController {
	@Autowired
	IService services ;
	@GetMapping("/Start")
	public ModelAndView tostart() {
		ModelAndView mv = new ModelAndView();
		ArrayList<User> list ;
		list = services.getAllUsers();
		mv.addObject("list",list);
		//3.设置响应的逻辑结果的视图名称
		mv.setViewName("start");
		return mv;
	}
	/*@GetMapping("/Start")
	public String tostart(Model model) {
		ArrayList<User> list ;
		list = addUser.getAllUsers();
		model.addAttribute("list",list);
		return "start";
	}*/
	/*@GetMapping("/Start")
	public User tostart() {
		return new User();
	}*/
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	public String addUser(User user) {
		services.addUser(user);
		return "redirect:Start";
//		return "success";
	}
	@PostMapping("/delete")
	public String deleteUser(String userId) {
		services.deleteUser(userId);
		return "redirect:Start";
	}
	@PostMapping("/update")
	public String updateUser(User user) {
		services.updateUser(user);
		return "redirect:Start";
	}
	/*@PostMapping("/ajax")
	public String test(Model model,String name) {
		ArrayList<User> list ;
		list = services.getAllUsersByName(name);
		model.addAttribute("list",list);
		return "start";
	}*/
	@PostMapping("/ajax")
	public @ResponseBody String test(String name) {
		System.out.println(name);
		ArrayList<User> list ;
		list = services.getAllUsersByName(name);
		JSONArray json = JSONArray.fromObject(list);
		return json.toString();
	}
}
