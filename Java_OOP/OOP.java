public class OOP {
    public static void main(String[]args) {
        System.out.println("hello world");
        User u = new User();
        u.name = "Thiago";
        u.membership = "Gold";

        User u2 = new User();
        u2.name = "Sally";
        u2.membership = "Silver";

        System.out.println(u.name);
        System.out.println(u2.name);
        System.out.println(u.age);
        
    }
    
}
