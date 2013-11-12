import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloWorldNetwork {

    /**
     * Hello world example containing network socket
     */
    
    static int iCount = 0;

    public static void main(String[] args) throws IOException {
	ServerSocket listener = new ServerSocket(10000); //Bind to all interfaces on the TCP port 10000
	try {
	    while (true) {
		Socket socket = listener.accept();
		try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println("Hello World across TCP: ");
		    out.println(Integer.toString(iCount++));
                    out.println("\r\n");
		} finally {
		    socket.close();
		}
	    }
	}
	finally {
	    listener.close();
	}
    }
}
