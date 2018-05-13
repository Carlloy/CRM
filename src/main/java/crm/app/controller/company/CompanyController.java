package crm.app.controller.company;


import crm.app.services.company.CompanyDTO;
import crm.app.services.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/company")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<String> createCompany(@RequestBody CompanyDTO companyDTO) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        companyDTO.setCreatedby(authentication.getName());
        companyService.createCompany(companyDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}