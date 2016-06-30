@Controller
public class HelloWorldController {
	@RequestMapping("/hello")
	public ModelAndView helloWorld() {
		String message = "HELLO SPRING MVC HOW R U";
		System.out.println("Here.............");
		return new ModelAndView("hellopage", "message", message);
	}
}