package crm.app.services.user.usermanagement;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ChangePasswordDTO {
    private String email;
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;

    public ChangePasswordDTO(@JsonProperty("email") String email, @JsonProperty("oldPassword") String oldPassword,
                             @JsonProperty("newPassword") String newPassword, @JsonProperty("confirmPassword") String confirmPassword) {
        this.email = email;
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getEmail() {
        return email;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

}
