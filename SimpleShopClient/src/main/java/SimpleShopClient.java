import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import pl.gda.zsl.Book;
import pl.gda.zsl.CartBeanRemote;

public class SimpleShopClient {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		CartBeanRemote cart = lookupRemoteHelloWorldCartService();
		for (Book b : cart.getWarehouseState()) {
			System.out.println("BookId: " + b.getBookId());
			System.out.println("BookName: " + b.getName());
			System.out.println("Book Available amount: " + b.getAmount());
			System.out.println("");
		}
		cart.addBook(0);
		cart.addBook(1);
		for (Book b : cart.getWarehouseState()) {
			System.out.println("BookId: " + b.getBookId());
			System.out.println("BookName: " + b.getName());
			System.out.println("Book Available amount: " + b.getAmount());
			System.out.println("");
		}
		cart.removeBean();
	}
	
	private static CartBeanRemote lookupRemoteHelloWorldCartService() throws NamingException {
		Properties jndiProperties = new Properties();
        
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		
		Context context = new InitialContext(jndiProperties);
		final String appName = "SimpleShopBasicEAR";
		final String moduleName = "SimpleShopBean";
		final String beanName = "CartBean";
		final String viewClassName = CartBeanRemote.class.getName();
		return (CartBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + beanName + "!" + viewClassName + "?stateful");
	}
}


