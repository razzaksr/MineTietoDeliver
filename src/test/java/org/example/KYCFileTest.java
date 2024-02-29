package org.example;
import app.KYC;
import app.KYCFileRemote;
import app.KYCRemote;
import org.junit.Before;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.*;

public class KYCFileTest {
    private KYCRemote kycRemote;
    private final String testFilePath = "test_users.txt";

    @Before
    public void setUp() throws IOException {
        // Create a test file with some initial data
//        Files.write(Path.of(testFilePath), List.of("1,user1,user1@example.com", "2,user2,user2@example.com"));
        List<KYC> list = Stream.of(new KYC(12,"Razak Mohamed S",98.2),new KYC(98,"Rajiya R",928.3)).collect(Collectors.toList());
        new ObjectOutputStream(new FileOutputStream(testFilePath)).writeObject(list);
        kycRemote = new KYCFileRemote(testFilePath);
    }

    @Test
    public void findById_ValidId_ReturnsUser() {
        KYC kyc=kycRemote.findById(12);//User user = userRepository.findById(1);
        assertNotNull(kyc);//assertNotNull(user);
        assertEquals(12,kyc.getNumber());//assertEquals(1, user.getId());
        assertEquals("Razak Mohamed S",kyc.getName());//assertEquals("user1", user.getUsername());
        assertEquals(Optional.of(98.2), Optional.ofNullable(kyc.getBalance()));//assertEquals("user1@example.com", user.getEmail());
    }

    @Test
    public void findById_InvalidId_ReturnsNull() {
//        KYC kyc=kycRemote.findById(98);
        KYC kyc=kycRemote.findById(97);
        assertNull(kyc);
        //User user = userRepository.findById(100);
        //assertNull(user);
    }

    @Test
    public void findAll_ReturnsAll() {
        List<KYC> kycs = kycRemote.findAll();
        assertEquals(2, kycs.size());
        assertEquals(12, kycs.get(0).getNumber());
        assertEquals("Razak Mohamed S", kycs.get(0).getName());
        assertEquals(Optional.of(98.2), Optional.ofNullable(kycs.get(0).getBalance()));
        assertEquals(98, kycs.get(1).getNumber());
        assertEquals("Rajiya R", kycs.get(1).getName());
        assertEquals(Optional.of(928.3), Optional.ofNullable(kycs.get(1).getBalance()));
    }

    @Test
    public void save_AddsNewUser() {
        KYC kyc=new KYC(33,"Rasheedha R",345.6);
        kycRemote.save(kyc);
        List<KYC> kycs = kycRemote.findAll();
        assertEquals(3, kycs.size());
        assertEquals(kyc.toString(), kycs.get(2).toString());
    }

    @Test
    public void update_ModifiesUser() {
//        System.out.println(kycRemote.findAll());
        KYC kyc=new KYC(98,"Razak Mohamed S",98.2);
        kycRemote.update(kyc);
        KYC kyc1=kycRemote.findById(98);
        System.out.println(kyc1);
        assertEquals(kyc1.getName(), kyc.getName());
        assertEquals(kyc1.getBalance(),kyc.getBalance());
    }

    @Test
    public void delete_RemovesUser() {
        kycRemote.delete(12);
        assertNull(kycRemote.findById(1));
        assertEquals(1, kycRemote.findAll().size());
    }
}

