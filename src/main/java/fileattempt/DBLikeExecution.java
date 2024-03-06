package fileattempt;

//import app.KYC;

import java.io.IOException;

public class DBLikeExecution {
    public static void main(String[] args) {
        KYC kyc1=new KYC(923,"Razak Mohamed S",2323.4);
        KYC kyc2=new KYC(23,"Rasheedha R Mohamed",2323.4);
        KYC kyc3=new KYC(283,"Rajiya R Mohamed",2323.4);

        DBLikeFile dbLikeFile=new DBLikeFile();

        try{
//            System.out.println(dbLikeFile.save(kyc1));
//            System.out.println(dbLikeFile.save(kyc2));
//            System.out.println(dbLikeFile.save(kyc3));
//            System.out.println(dbLikeFile.findAll());;
//            dbLikeFile.findAll().forEach(System.out::println);
            System.out.println(dbLikeFile.findById(23));
            //System.out.println(dbLikeFile.findAll());
        }
        catch (IOException ioException){
            ioException.printStackTrace();
        }
    }
}
