public class Main {

    public static void main(String[] args) {

        if(SaveProf.profileNotExists()){
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Signup();
                }
            });
        }
        else{
            java.awt.EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new Signin();
                }
            });
        }
    }
}