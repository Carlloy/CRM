package crm.app.services.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AppUserDTO {
    private String name;
    private String surname;
    private String password;
    private String email;

    public AppUserDTO(String name, String surname, String password, String email) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.email = email;
    }


    public AppUserDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }


    @Override
    public int hashCode() {
        return Objects.hash(name, surname, password, email);
    }

    public static final class AppUserDTOBuilder {
        private String name;
        private String surname;
        private String email;
        private String password;


        public AppUserDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AppUserDTOBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public AppUserDTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AppUserDTOBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

    }
}
