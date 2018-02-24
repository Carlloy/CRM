package crm.app.tools.parsers;

import crm.app.services.registration.RegistrationUserDTO;
import org.junit.Assert;
import org.junit.Test;

public class JSONParserTest {

    @Test
    public void parseFromUrl() {
    }

    @Test
    public void parseJSON() {
        JSONParser<RegistrationUserDTO> jsonParser = new JSONParser<>(RegistrationUserDTO.class);
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"name\" : \"Andrzej\",");
        json.append("\"surname\" : \"surname\",");
        json.append("\"email\" : \"email\",");
        json.append("\"password\" : \"password\",");
        json.append("\"confirmPassword\" : \"password\"");
        json.append("}");

        RegistrationUserDTO userDTO = jsonParser.parseJSON(json.toString());

        RegistrationUserDTO expectedResult = new RegistrationUserDTO.UserDTOBuilder().
                withName("Andrzej").
                withSurname("surname").
                withEmail("email").
                withPassword("password").
                withConfirmPassword("password").
                build();

        Assert.assertEquals(expectedResult, userDTO);


    }
}