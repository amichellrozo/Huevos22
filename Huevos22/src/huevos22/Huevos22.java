
package huevos22;

public class Huevos22 {

    public static void main(String[] args) {
         Vista_login v1 = new Vista_login();
        BD_huevos m =new  BD_huevos ();
         Controlador_Login n = new  Controlador_Login (v1,m);
    }
    
}
