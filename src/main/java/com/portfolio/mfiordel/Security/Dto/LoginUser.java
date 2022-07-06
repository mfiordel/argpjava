
package com.portfolio.mfiordel.Security.Dto;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;

public class LoginUser {
    private String nameUser;
    @NotBlank
    private String password;
    private Set<String> roles = new HashSet<>();

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
    
}
