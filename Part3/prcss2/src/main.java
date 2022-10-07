import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class main {
    public static void main(String[] args) {
        receive();
    }

    public static void receive () {
        try {
            DatagramSocket ds = new DatagramSocket(8000);

            int i = 0;

           while(i < 11)
           {
               byte[] tampon = new byte[1000];

               DatagramPacket dp = new DatagramPacket(tampon, tampon.length);

               try {
                   ds.receive(dp);
                   String s = new String(dp.getData());
                   System.out.println(s);

               } catch (IOException e) {
                   e.printStackTrace();
               }
               i++;
           }

        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}
