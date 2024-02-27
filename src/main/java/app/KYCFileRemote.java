package app;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class KYCFileRemote implements KYCRemote{
    private String filePath="";
    public KYCFileRemote(String path){
        filePath=path;
    }

    private List<KYC> myMedium=new ArrayList<>();

    private void write(){
        try{
            FileOutputStream fos=new FileOutputStream(filePath);
            ObjectOutputStream oos=new ObjectOutputStream(fos);
            oos.writeObject(myMedium);
            oos.close();
            fos.close();
        }
        catch (IOException ioException){}
    }

    private void read(){
        try{
            FileInputStream fis=new FileInputStream(filePath);
            ObjectInputStream ois=new ObjectInputStream(fis);
            myMedium=(List<KYC>) ois.readObject();
            ois.close();
            fis.close();
        }
        catch (IOException | ClassNotFoundException ioException){}
    }

    @Override
    public void save(KYC kyc) {
        read();
        myMedium.add(kyc);
        write();
    }

    @Override
    public KYC findById(int id) {
        read();
        return myMedium.stream().filter(each->each.getNumber()==id).findFirst().orElse(null);
    }

    @Override
    public List<KYC> findAll() {
        read();
        return myMedium;
    }

    @Override
    public void update(KYC kyc) {
        read();
//        int index=myMedium.indexOf(kyc);
//        if(index!=-1)
//            myMedium.set(index,kyc);
        KYC kyc1=myMedium.stream().filter(each->each.getNumber()==kyc.getNumber()).findFirst().orElse(null);
        if(kyc1!=null) {
            int index=myMedium.indexOf(kyc1);
            myMedium.set(index, kyc);
            System.out.println(myMedium.get(index));
        }
        else
            System.out.println("Invalid Number");
        write();
    }

    @Override
    public void delete(int id) {
        read();
        myMedium.removeIf(v->v.getNumber()==id);
        write();
    }
}
