import java.io.IOException;
import java.net.*;

public class main {
    public static void main(String[] args) {
        send();
    }

    public static void send() {
        try {
            DatagramSocket ds = new DatagramSocket();

            try
            {
                InetAddress AdrrP1 = InetAddress.getByName("127.0.0.1");
                String s;
                byte[] m;

                DatagramPacket dp;

                for (int i = 1; i < 11; i++)
                {
                   s = Integer.toString(i * i);
                   m = s.getBytes();
                   dp = new DatagramPacket(m, m.length, AdrrP1, 8000);

                    try
                    {
                        ds.send(dp);
                    }
                    catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("MSG Sent");
                }


            }
            catch (UnknownHostException e)
            {
                e.printStackTrace();
            }


            ds.close();
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }
    }
}
