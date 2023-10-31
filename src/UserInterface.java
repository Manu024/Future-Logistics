import java.util.Scanner;

public class UserInterface {
    public static void main(String[] args) throws Exception {
        //Input format
        // transportId:transportDate:transportRating:transportType:brickSize,brickQuantity,brickPrice.
        // transportId:transportDate:transportRating:transportType:timberLength:timberRadius,timberType, timberPrice
        Utility util = new Utility();
        //Sample I/O example for brickTransport
        // String input = "RTS120A:12/8/21:5:Bricktransport:6:800:40";
        // String input = "RTS113:12/8/21:4:TimberTransport:20:4:Premium:500";
        Scanner s = new Scanner(System.in);
        String input = s.nextLine();
        GoodsTransport transport = util.parseDetails(input);
        if(util.validateTransportId(transport.getTransportId())) {
            System.out.println(transport.calculateTotalCharge());
        }
        else {
            System.out.println("Transport id "+transport.getTransportId()+" is invalid\nPlease provide a valid record");
        }
    }
}