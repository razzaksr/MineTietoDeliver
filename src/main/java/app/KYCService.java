package app;

import java.util.List;

public class KYCService {
    private KYCRemote kycRemote;
    public KYCService(StorageStrategy storageStrategy){
        this.kycRemote= storageStrategy.getKycRemote();
    }
    public KYC findById(int id) {
        return kycRemote.findById(id);
    }

    public List<KYC> findAll() {
        return kycRemote.findAll();
    }

    public void save(KYC user) {
        kycRemote.save(user);
    }

    public void update(KYC user) {
        kycRemote.update(user);
    }

    public void delete(int id) {
        kycRemote.delete(id);
    }
}
