public class UserInterface {
    public static void main(String[] args) throws Exception {
        //Input format
        // transportId:transportDate:transportRating:transportType:brickSize,brickQuantity,brickPrice.
        // transportId:transportDate:transportRating:transportType:timberLength:timberRadius,timberType, timberPrice
        //Sample I/O example for brickTransport
        Utility util = new Utility();
        // String input = "RTS123Z:26/10/2023:2:Bricktransport:10,400,5";
        // String input = "RTS113A:12/8/21:4:Bricktransport:10,400,5";
        String input = "RTS113A:12/8/21:4:TimberTransport:20:4,Premium";
        GoodsTransport transport = util.parseDetails(input);
        System.out.println(util.validateTransportId(transport.getTransportId()));
        System.out.println(transport.calculateTotalCharge());
    }
}
