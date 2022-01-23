import java.io.*;
import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public class saveMsg {
    public saveMsg(String msg) throws Exception{
        //获取文件保存的位置
        File file=new File("setting/setting.json");
        String content= FileUtils.readFileToString(file,"UTF-8");
        JSONObject jsonFile=new JSONObject(content);
        String location = jsonFile.getString("save_location");
        File msgFile = new File(location);
        FileOutputStream fos = new FileOutputStream(msgFile,true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw);
        bw.write("消息是:");
        bw.write(msg);
        bw.newLine();
        bw.flush();
        bw.close();
        osw.close();
        fos.close();
        //写入文件
    }
}
