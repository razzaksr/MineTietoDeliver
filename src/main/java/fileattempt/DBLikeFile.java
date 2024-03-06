package fileattempt;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.InflaterInputStream;

public class DBLikeFile {
    private ResourceBundle resourceBundle=ResourceBundle.getBundle("application");
    private String filePath= resourceBundle.getString("file");

    /*
    private byte[] objectToBytes(KYC kyc)throws IOException{
        try(ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(byteArrayOutputStream)){
            objectOutputStream.writeObject(kyc);
            return byteArrayOutputStream.toByteArray();
        }
    }

    private KYC byteToObject(byte[] bytes)throws IOException,ClassNotFoundException{
        try(ByteArrayInputStream byteArrayInputStream=new ByteArrayInputStream(bytes);
        ObjectInputStream objectInputStream=new ObjectInputStream(byteArrayInputStream)){
            return (KYC)objectInputStream.readObject();
        }
    }

    public String save(KYC kyc) throws IOException {
        try(FileOutputStream fileOutputStream=new FileOutputStream(filePath,true);
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream)){
            byte[] size=objectToBytes(kyc);
            objectOutputStream.writeInt(size.length);
            objectOutputStream.writeObject(kyc);
        }
        return "KYC added";
    }

    public List<KYC> findAll() throws IOException,ClassNotFoundException{
        List<KYC> myList=new ArrayList<>();
        try(FileInputStream fileInputStream=new FileInputStream(filePath);
        ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream)){
            while(true){
                try{
                    int size = objectInputStream.readInt();
                    byte[] arr=new byte[size];
                    objectInputStream.readFully(arr);
                    myList.add(byteToObject(arr));
                }
                catch (EOFException eofException){
                    eofException.printStackTrace();
                    break;
                }
            }
        }
        return myList;
    }
    */


    /*
    public void findAll()throws IOException{
        //List<KYC> kycs=new ArrayList<>();
        try(BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(new InflaterInputStream(new FileInputStream(filePath))))){
            String line=null;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
                String[] arr=line.split(",");
//                KYC kyc=new KYC();
//                kyc.setNumber(Integer.parseInt(arr[0]));
//                kyc.setName(arr[1]);kyc.setBalance(Double.parseDouble(arr[2]));
//                System.out.println(kyc);
            }
        }
    }

    public String save(KYC kyc)throws IOException{
        try(PrintWriter writer=new PrintWriter(new DeflaterOutputStream(new FileOutputStream(filePath,true)))){
            writer.println(kyc.toString().getBytes());
            //deflaterOutputStream.write(kyc.toString().getBytes());
            return kyc.getName()+" has inserted";
        }
    }
    */

    public KYC findById(int id)throws IOException{
        KYC kyc=new KYC();
        try(BufferedReader reader=new BufferedReader(new FileReader(filePath))){
            StandardPBEStringEncryptor encryptor=new StandardPBEStringEncryptor();
            encryptor.setPassword("razak@srmd7");
            String line;
            while((line=reader.readLine())!=null){
                String each=encryptor.decrypt(line);
                String[] arr=each.split(",");
                if(Integer.parseInt(arr[0])==id){
                    kyc.setNumber(Integer.parseInt(arr[0]));
                    kyc.setName(arr[1]);
                    kyc.setBalance(Double.parseDouble(arr[2]));
                    break;
                }
            }
        }
        return kyc;
    }


    public List<KYC> findAll()throws IOException{
        List<KYC> every=new ArrayList<>();
        try(BufferedReader reader=new BufferedReader(new FileReader(filePath))){
            StandardPBEStringEncryptor encryptor=new StandardPBEStringEncryptor();
            encryptor.setPassword("razak@srmd7");
            String line;
            while((line=reader.readLine())!=null){
                String each=encryptor.decrypt(line);
                String[] arr=each.split(",");
                KYC kyc=new KYC();
                kyc.setNumber(Integer.parseInt(arr[0]));
                kyc.setName(arr[1]);
                kyc.setBalance(Double.parseDouble(arr[2]));
                every.add(kyc);
            }
        }
        return every;
    }

    public String save(KYC kyc)throws IOException{
        try(PrintWriter printWriter=new PrintWriter(new FileWriter(filePath,true))){
            StandardPBEStringEncryptor stringEncryptor=new StandardPBEStringEncryptor();
            stringEncryptor.setPassword("razak@srmd7");
            String line=stringEncryptor.encrypt(kyc.toString());
            printWriter.println(line);
            return kyc.getName()+" has written";
        }
    }

}
