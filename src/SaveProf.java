import java.io.*;


public class SaveProf {
    static String database = "profiles.txt";

    public static void saveProfile(String value){
        try{
            FileWriter fw = new FileWriter(database,true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(value);
            bw.newLine();
            bw.close();
            fw.close();
            System.out.println("New profile saved");
        } catch (IOException e){
            System.out.println("Profile couldn't be created\n" + "Error: " + e);
        }
    }

    public static String getProfile(){
        String profile = "";
        String value;

        try{
            FileReader fr = new FileReader(database);
            BufferedReader br = new BufferedReader(fr);
            profile = br.readLine().trim();

            br.close();
            fr.close();
            System.out.println("Connected to the database");
        } catch (IOException e){
            System.out.println("Profile couldn't be loaded\n" + "Error: " + e);
        }
        return profile;
    }

    public static boolean profileNotExists(){
        File file = new File("profiles.txt");
        return !(file.exists() && !file.isDirectory());
    }
}
