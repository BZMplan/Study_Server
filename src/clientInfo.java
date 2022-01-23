import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

public class clientInfo {
    public clientInfo(Socket socket) {
        try {
            InputStream in =  socket.getInputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len=in.read(buf))!=-1){
                String msg = new String(buf,0,len);
                new saveMsg(msg);
                System.out.println("接收到的信息是 "+msg);
            }
            in.close();
        } catch (Exception e) {
            //TODO: handle exception
        }
        
    }
}
