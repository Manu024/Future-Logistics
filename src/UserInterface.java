public class UserInterface {
    public static void main(String[] args) throws Exception {
        //Sample I/O example for brickTransport
        String input = "'RTS123Z':'26/10/2023':2:'Bricktransport':10,400,5";
        GoodsTransport transport = new Utility().parseDetails(input);
        System.out.println(transport.calculateTotalCharge());
    }
}
