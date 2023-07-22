package tiketkeretaapi;

import GUI.FormAdministrator;
import GUI.FormLogin;
import GUI.FormOperatorTiket;

public class Tiketkeretaapi {   
    public static void main(String[] args) {
        FormAdministrator admin = new FormAdministrator();
        admin.setVisible(true);
        FormOperatorTiket opr = new FormOperatorTiket();
        opr.setVisible(true);
        FormLogin login = new FormLogin();
        login.setVisible(true);
 }
}
    