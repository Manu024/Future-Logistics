import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utility {
    public boolean validateTransportId(String transportId) {
        String regex = "^RTS[0-9]{3}[A-Z]$";

        // Compile the regular expression into a pattern
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher with the input string
        Matcher matcher = pattern.matcher(transportId);

        // Check if the input string matches the pattern
        return matcher.matches();
    }

    public GoodsTransport parseDetails(String input) {
        // transportId:transportDate:transportRating:transportType:brickSize,brickQuantity,brickPrice.
        // transportId:transportDate:transportRating:transportType:timberLength:timberRadius,timberType, timberPrice
        String[] ipArrStrings = input.split(":");
        // String[] subInputStrings = ipArrStrings[4].split(",");
        GoodsTransport transport;

        if (ipArrStrings[3].equalsIgnoreCase("TimberTransport")) {
            transport = new TimberTransport(ipArrStrings[0], ipArrStrings[1], Integer.parseInt(ipArrStrings[2]),
                    ipArrStrings[3], Float.parseFloat(ipArrStrings[4]), Float.parseFloat(ipArrStrings[5]),
                    ipArrStrings[6], Float.parseFloat(ipArrStrings[7]));
        } else {
            transport = new BrickTransport(
                    ipArrStrings[0], ipArrStrings[1], Integer.parseInt(ipArrStrings[2]),
                    ipArrStrings[3], Float.parseFloat(ipArrStrings[4]), Integer.parseInt(ipArrStrings[5]),
                    Float.parseFloat(ipArrStrings[6]));
        }
        return transport;
    }
}
