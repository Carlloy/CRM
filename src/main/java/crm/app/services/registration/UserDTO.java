package crm.app.services.registration;

public class UserDTO {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String confirmPassword;

    public UserDTO(String name, String surname, String email, String password, String confirmPassword) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
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

        public UserDTO build() {
            return new UserDTO(name, surname, email, password, confirmPassword);
        }
    }
}
