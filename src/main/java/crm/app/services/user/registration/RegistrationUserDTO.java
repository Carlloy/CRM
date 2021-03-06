package crm.app.services.user.registration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationUserDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String confirmPassword;

    public RegistrationUserDTO(String name, String surname, String email, String password, String confirmPassword) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public RegistrationUserDTO() {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegistrationUserDTO userDTO = (RegistrationUserDTO) o;
        return Objects.equals(name, userDTO.name) &&
                Objects.equals(surname, userDTO.surname) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(password, userDTO.password) &&
                Objects.equals(confirmPassword, userDTO.confirmPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, email, password, confirmPassword);
    }

    public static final class UserDTOBuilder {
        private String name;
        private String surname;
        private String email;
        private String password;
        private String confirmPassword;


        public UserDTOBuilder() {
        }

        public UserDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public UserDTOBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public UserDTOBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserDTOBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserDTOBuilder withConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public RegistrationUserDTO build() {
            return new RegistrationUserDTO(name, surname, email, password, confirmPassword);
        }
    }
}
