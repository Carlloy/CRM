package crm.app.services.registration;

import crm.app.data.dao.AppUserDAO;
import crm.app.services.registration.exception.InvalidCredentialsException;
import crm.app.services.registration.transfer.UserDTO;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RegistrationService.class, AppUserDAO.class})
public class RegistrationServiceTest {

    @Autowired
    RegistrationService registrationService;

    @MockBean
    AppUserDAO appUserDAO;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        when(appUserDAO.isEmailExists(any(String.class))).thenReturn(false); //tutaj mowimy, ze jezeli wykonamy metode z jakimkolwiek stringiem to una zwroci nam false
    }

    @Test
    public void when_fields_are_ok_dto_should_be_saved() throws InvalidCredentialsException {
        UserDTO userDTO = new UserDTO("Andrzej", "Krul", "andrzej.krul@gmail.com", "Password123", "Password123");
        UserDTO userDTOByBuilder = new UserDTO.UserDTOBuilder().
                withName("Andrzej").
                withSurname("Krul").
                withEmail("andrzej.krul@gmail.com").
                withPassword("Password123").
                withConfirmPassword("Password123").build();
        registrationService.registration(userDTO);
    }

}
