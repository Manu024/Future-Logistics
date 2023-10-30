public class UserInterface {
    public static void main(String[] args) throws Exception {
        //Sample I/O example for brickTransport
        Utility util = new Utility();
        String input = "RTS123Z:26/10/2023:2:Bricktransport:10,400,5";
        GoodsTransport transport = util.parseDetails(input);
        System.out.println(util.validateTransportId(transport.getTransportId()));
        System.out.println(transport.calculateTotalCharge());
    }
}
