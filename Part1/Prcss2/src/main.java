import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class main {
    public static void main(String[] args) {

        try {
            DatagramSocket ds = new DatagramSocket(8000);

            while(true) {

                byte[] tampon = new byte[1000];

                DatagramPacket dp = new DatagramPacket(tampon, tampon.length);

                try {
                    ds.receive(dp);
                    String s = new String(dp.getData());
                    System.out.println(s);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
