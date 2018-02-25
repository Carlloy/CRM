package crm.app.data.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "APPUSER")
public class AppUser implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false, length = 25)
    private String name;
    @Column(nullable = false, length = 25)
    private String surname;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(nullable = false, length = 25, unique = true)
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Role> role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRole() {
        return role;
    }

    public void setRole(List<Role> roles) {
        this.role = roles;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", roles=" + role +
                '}';
    }

    public static final class AppUserBuilder {
        private Long id;
        private String name;
        private String surname;
        private String password;
        private String email;
        private List<Role> roles;

        public AppUserBuilder() {
        }

        public AppUserBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public AppUserBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public AppUserBuilder withSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public AppUserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public AppUserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public AppUserBuilder withRoles(List<Role> roles) {
            this.roles = roles;
            return this;
        }

        public AppUser build() {
            AppUser appUser = new AppUser();
            appUser.setId(id);
            appUser.setName(name);
            appUser.setSurname(surname);
            appUser.setPassword(password);
            appUser.setEmail(email);
            appUser.setRole(roles);
            return appUser;
        }
    }
}
