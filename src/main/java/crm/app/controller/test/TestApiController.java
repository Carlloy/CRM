package crm.app.controller.test;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {

    @RequestMapping(value = "/test/get", method = RequestMethod.GET)
    public String test() {
        return "Is working";
    }

    @RequestMapping(value = "/test/post", method = RequestMethod.POST)
    public String testPost() {
        return "Is working";
    }

    @RequestMapping(value = "/api/test", method = RequestMethod.GET)
    public String testApi() {
        return "Is working";
    }

}
