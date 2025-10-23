package com.example.TestCase1.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.TestCase1.model.NumberModel;

@Service
public class NumberService {
    private final List<NumberModel> dataList = new ArrayList<>();

    public void addNumber(int value) {
        String words = convertToWords(value);
        dataList.add(new NumberModel(value, words));
    }

    public List<NumberModel> getAllNumbers() {
        return dataList;
    }

    public void clearAll() {
        dataList.clear();
    }

    public boolean deleteByValue(int value) {
        return dataList.removeIf(data -> data.getAngka() == value);
    }

    public String convertToWords(int a) {
        String[] bilangan = {
                "", "satu", "dua", "tiga", "empat", "lima",
                "enam", "tujuh", "delapan", "sembilan", "sepuluh", "sebelas"
        };

        String kalimat;

        // 1 - 11
        if (a < 12) {
            kalimat = bilangan[a];
        }
        // 12 - 19
        else if (a < 20) {
            kalimat = bilangan[a - 10] + " belas";
        }
        // 20 - 99
        else if (a < 100) {
            int utama = a / 10;
            int belakang = a % 10;
            kalimat = bilangan[utama] + " puluh " + bilangan[belakang];
        }
        // 100 - 199
        else if (a < 200) {
            kalimat = "seratus " + convertToWords(a - 100);
        }
        // 200 - 999
        else if (a < 1000) {
            int utama = a / 100;
            int belakang = a % 100;
            kalimat = bilangan[utama] + " ratus " + convertToWords(belakang);
        }
        // 1,000 - 1,999
        else if (a < 2000) {
            kalimat = "seribu " + convertToWords(a - 1000);
        }
        // 2,000 - 9,999
        else if (a < 10000) {
            int utama = a / 1000;
            int belakang = a % 1000;
            kalimat = bilangan[utama] + " ribu " + convertToWords(belakang);
        } else {
            kalimat = "Angka terlalu besar";
        }

        return kalimat.trim().replaceAll("\\s+", " ");
    }
}
