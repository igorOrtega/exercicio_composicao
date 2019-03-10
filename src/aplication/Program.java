package aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.Product;
import entities.enums.OrderStatus;
import services.OrderItem;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
		//client
		System.out.println("Enter client data: ");
		System.out.print("Name: ");
		String clientName = sc.next();
		System.out.print("Email: ");
		String clientEmail = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		//order data
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String status = sc.next();
		//Instance order
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(clientName, clientEmail, birthDate));
		//items
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		
		for(int i = 1; i <= n ; i++) {
			System.out.println("Enter #" + i + " item data: ");
			System.out.print("Product name: ");
			String name = sc.next();
			System.out.print("Product price: ");
			double price = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			order.addItem(new OrderItem(quantity, price, new Product(name, price)));	
		}
	}
	
	
	sc.close();
}
