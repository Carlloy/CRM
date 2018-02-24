package crm.app.services.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import crm.app.services.user.registration.RegistrationUserDTO;

import java.util.Objects;

public class AppUserDTO {
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private Integer appUserType_ID;

    public AppUserDTO(@JsonProperty("name") String name, @JsonProperty("surname") String surname,
                      @JsonProperty("password") String password, @JsonProperty("email") String email, @JsonProperty("appUserType_ID") Integer appUserType_ID) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.appUserType_ID = appUserType_ID;
    }

    public Long getId() {
        return id;
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

    public Integer getAppUserType_ID() {
        return appUserType_ID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, password, email, appUserType_ID);
    }

    public static final class AppUserDTOBuilder {
        private String name;
        private String surname;
        private String email;
        private String password;
        private Integer appUserType_ID;

        public AppUserDTOBuilder() {
        }

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

        public AppUserDTOBuilder withAppUserType(Integer appUserType_ID) {
            this.appUserType_ID = appUserType_ID;
            return this;
        }

        public AppUserDTO build() {
            return new AppUserDTO(name, surname, email, password, appUserType_ID);
        }
    }
}
