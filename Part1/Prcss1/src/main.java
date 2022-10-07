import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket();

            try
            {
                InetAddress AdrrP1 = InetAddress.getByName("127.0.0.1");

                Scanner input = new Scanner(System.in);
                System.out.print("Entrer un msg: ");
                String s = input.nextLine();

                byte[] m = s.getBytes();

                DatagramPacket dp = new DatagramPacket(m, m.length, AdrrP1, 8000);

                try
                {
                    ds.send(dp);
                }
                catch (IOException e) {
                    e.printStackTrace();
                }

            }
            catch (UnknownHostException e)
            {
                e.printStackTrace();
            }

            System.out.print("MSG Sent");
            ds.close();
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }
    }
}

