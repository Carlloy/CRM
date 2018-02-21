package crm.app.tools.parsers;

import crm.app.services.registration.transfer.UserDTO;
import org.junit.Assert;
import org.junit.Test;

public class JSONParserTest {

    private String getTestJSON() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"name\" : \"Andrzej\",");
        json.append("\"surname\" : \"surname\",");
        json.append("\"email\" : \"email\",");
        json.append("\"password\" : \"password\",");
        json.append("\"confirmPassword\" : \"password\"");
        json.append("}");
        return json.toString();
    }

    @Test
    public void parse_JSON() {
        JSONParser<UserDTO> jsonParser = new JSONParser<>(UserDTO.class);
        UserDTO userDTO = jsonParser.parseJSON(getTestJSON());
        UserDTO expectedResult = new UserDTO.UserDTOBuilder().
                withName("Andrzej").
                withSurname("surname").
                withEmail("email").
                withPassword("password").
                withConfirmPassword("password").
                build();
        Assert.assertEquals(expectedResult, userDTO);
    }

    @Test
    public void parse_Static_JSON() {
        UserDTO userDTO = (UserDTO) JSONParser.parseJSON(getTestJSON(), UserDTO.class);
        UserDTO expectedResult = new UserDTO.UserDTOBuilder().
                withName("Andrzej").
                withSurname("surname").
                withEmail("email").
                withPassword("password").
                withConfirmPassword("password").
                build();
        Assert.assertEquals(expectedResult, userDTO);
    }
}