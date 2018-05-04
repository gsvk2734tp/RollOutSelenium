public class RegEx {
    public static void main(String[] args) {
        String testLine1 = "+79212312312331312423154131";
        String testLine2 = "+23";
        System.out.println(testLine2.replaceAll("^[+0-9][0-9]{2,15}$", ""));
    }
}
