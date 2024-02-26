package app;

import java.util.Date;

public class FileStorageStrategy implements StorageStrategy {
    @Override
    public KYCRemote getKycRemote() {
        return new KYCFileRemote("minemodule.txt");
    }
}
