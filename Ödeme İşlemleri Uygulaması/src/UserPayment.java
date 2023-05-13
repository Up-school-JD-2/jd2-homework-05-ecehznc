import java.util.Scanner;
import java.util.Random;

class BaseException extends Exception{
	public BaseException(String message) {
		super(message);
	}
}

public class UserPayment {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		
		try {
			if(pay()) {
				throw new SystemNotWorkingException("System is not working");
			}

			System.out.print("Enter the amount of payment:");
			int amount= scanner.nextInt();
			scanner.nextLine();
			if(!isValidAmount(amount)) {
				throw new AmountInvalidException("Invalid payment amount:" + amount);
			 }
			
			System.out.print("Enter the card number:");
			String cardNumber= scanner.nextLine();
			if(!isValidCardNumber(cardNumber)) {
				throw new CardInvalidException("Invalid card number" + cardNumber);
			}
			
			System.out.print("Enter expiration date (MM/YYY): ");
			String expirationDate= scanner.nextLine();
			if(isValidDate(expirationDate)) {
				throw new DateInvalidException("Invalid expiration date" + expirationDate);
			}
			
			System.out.print("Enter security code: ");
			String securityCode= scanner.nextLine();
			if(isValidSecurityCode(securityCode)) {
				throw new CodeInvalidException("Invalid security code");
			}	
			
			System.out.println("Entered information is right.");
		  } 
		catch (AmountInvalidException e) {
		    System.out.println(e.getMessage());
		}
		catch (CardInvalidException e) {
            System.out.println(e.getMessage());
            
        } 
		catch (DateInvalidException e) {
            System.out.println(e.getMessage());
        } 
		catch (SystemNotWorkingException e) {
            System.out.println("System is not working properly. ");
        } 
		catch (CodeInvalidException e) {
            System.out.println(e.getMessage());
        } 
	}
		
	
		private static boolean isValidAmount(int amount) {
			if(amount<0 ) {
				return false;
			}
			return true;
		}
		
		private static boolean isValidCardNumber(String cardNumber) {
			if(cardNumber.length()!=16 ) {
				return false;
			}
			for(char c: cardNumber.toCharArray()) {
				if(!Character.isDigit(c)) {
					return false;
				}
				
			}
			return true;
			
		}

		
		private static boolean isValidDate(String expirationDate) {
		    int month = Integer.parseInt(expirationDate.substring(0, 2));
		    int year = Integer.parseInt(expirationDate.substring(3));
			
			if(year < 2023 || month <1 || month > 12) {
				return true;
			}
		return false;
    }

		private static boolean isValidSecurityCode(String securityCode) {
			if(securityCode.length()==3 ) {
				return false;
			}
			for(char c: securityCode.toCharArray()) {
				if(!Character.isDigit(c)) {
					return false;
				}
				
			  }
			return true;
			}
		private static boolean pay() {
			Random random= new Random();
			int randomNumber= random.nextInt(100)+1;
			if( randomNumber>75) {
				return true;
			}
			return false;
         }
}
 
	
