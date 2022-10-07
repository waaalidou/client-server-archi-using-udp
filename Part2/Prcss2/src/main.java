import java.io.IOException;
import java.net.*;

public class main {
    public static void main(String[] args) {
        receive();
        send();
    }

    public static void receive () {
        try {
            DatagramSocket ds = new DatagramSocket(8000);

            byte[] tampon = new byte[1000];

            DatagramPacket dp = new DatagramPacket(tampon, tampon.length);

            try {
                ds.receive(dp);
                String s = new String(dp.getData());
                System.out.println(s);

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    public static void send() {
        try {
            DatagramSocket ds = new DatagramSocket();

            try
            {
                InetAddress AdrrP1 = InetAddress.getByName("127.0.0.1");

                String s = "Hello I'm process 2";
                byte[] m = s.getBytes();

                DatagramPacket dp = new DatagramPacket(m, m.length, AdrrP1, 7000);

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
