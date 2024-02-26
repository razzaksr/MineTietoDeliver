package app;

import java.util.List;

public interface KYCRemote {
    void save(KYC kyc);
    KYC findById(int id);
    List<KYC> findAll();
    void update(KYC kyc);
    void delete(int id);
}
