public class MainClass {
    public static void main(String[] args) {

        try {
            JSONManagement jsonManagement = new JSONManagement();
            jsonManagement.readJSONFromApijsonplaceholder();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
