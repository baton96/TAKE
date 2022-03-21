/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package view.backing;

import java.util.Locale;
import java.util.ResourceBundle;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlCommandButton;
import javax.faces.component.html.HtmlSelectBooleanCheckbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

/**
 *
 * @author bartosz
 */
@Named(value = "loginBean")
@RequestScoped
public class LoginBean {

    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;
    private String username;
    private String password;

    public String login() {
        if ("scott".equals(username) & "tiger".equals(password)) {
            FacesContext context = FacesContext.getCurrentInstance();
            ResourceBundle bundle = context.getApplication().getResourceBundle(context, "AppMessages");
            String message_text = bundle.getString("error.not_oracle");
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, message_text, null);
            context.addMessage(null, message);
            return "index";
        }

        if (username != null & password != null & username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }

    public void activateButton(ValueChangeEvent e) {
        if (acceptCheckbox.isSelected()) {
            loginButton.setDisabled(false);
        } else {
            loginButton.setDisabled(true);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the acceptCheckbox
     */
    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    /**
     * @param acceptCheckbox the acceptCheckbox to set
     */
    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckbox) {
        this.acceptCheckbox = acceptCheckbox;
    }

    /**
     * @return the loginButton
     */
    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    /**
     * @param loginButton the loginButton to set
     */
    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }

}
