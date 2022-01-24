import org.apache.commons.io.FileUtils;
import org.json.JSONObject;
import java.io.File;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;


public class serverStart{
    public serverStart() throws Exception{
        //获取json文件中的数据
        File file=new File("setting/setting.json");
        String content= FileUtils.readFileToString(file,"UTF-8");
        JSONObject jsonFile=new JSONObject(content);
        //定义ip与端口
        String portString = jsonFile.getString("port");
        int port = Integer.parseInt(portString);//将String类型的数据转换为int
        //创建socket对象

        ServerSocket serverSocket = new ServerSocket(port);
        Socket clientSocket = new Socket();
        while(true){
            // 监听客户端
            clientSocket = serverSocket.accept();
            serverThread thread = new serverThread();
            thread.start();
            InetAddress address=clientSocket.getInetAddress();
            new clientInfo(clientSocket);
            System.out.println(address);
            // new clientInfo(clientSocket);
        }
        


        
        
    }
}