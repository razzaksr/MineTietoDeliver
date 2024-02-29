package app;

public class App {
    public static void main(String[] args) {
        StorageStrategy storageStrategy= new DatabaseStorageStrategy();
        KYCService kycService=new KYCService(storageStrategy);
        KYC kyc=new KYC();kyc.setName("Annamalai S");kyc.setBalance(1233.3);
        kycService.save(kyc);
    }
//    public static void main(String[] args) {
//        StorageStrategy storageStrategy=new FileStorageStrategy();
//        KYCService kycService=new KYCService(storageStrategy);
////        System.out.println(kycService.findAll());
//        //kycService.save(new KYC(12,"Razak Mohamed S",23.4));
//        System.out.println(kycService.findAll());
////        kycService.delete(12);
//        kycService.update(new KYC(12,"Razak Mohamed S",99.4));
//        System.out.println(kycService.findAll());
//    }
}
