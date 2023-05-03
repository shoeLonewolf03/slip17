import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            System.out.println("Server started. Listening on port 8000.");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String filename = in.readLine();

                File file = new File(filename);
                if (file.exists()) {
                    BufferedReader fileIn = new BufferedReader(new FileReader(file));
                    String line;
                    while ((line = fileIn.readLine()) != null) {
                        out.println(line);
                    }
                    fileIn.close();
                } else {
                    out.println("File Not Found");
                }

                socket.close();
                System.out.println("Client disconnected.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
