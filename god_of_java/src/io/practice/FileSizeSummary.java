package io.practice;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class FileSizeSummary {
    public static void main(String[] args) {
        FileSizeSummary sample = new FileSizeSummary();
        String path = "C:\\godofjava";
        long sum = sample.printFileSize(path);
        System.out.println("\n" + path + "'s total size=" + sample.converFileLength(sum));
    }

    public long printFileSize(String dirName) {
        long sum = 0;
        File dir = new File(dirName);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                String tempFileName = file.getAbsolutePath();
                long fileLength = file.length();
                //System.out.println(tempFileName + "=" + converFileLength(fileLength));
                sum += fileLength;
            } else {
                String tempDirName = file.getAbsolutePath();
                long fileLength = printFileSize(tempDirName);
                System.out.println("[" + tempDirName + "]=" + converFileLength(fileLength));
                sum += fileLength;
            }
        }
        return sum;
    }

    private String converFileLength(long fileLength) {
        double length = (double)fileLength;
        String[] tun = new String[]{"b", "kb", "mb", "gb"};
        int tunIdx = 0;

        for (int i = 0; i < 3; ++i) {
            if (length >= 1024) {
                length /= 1024;
                tunIdx++;
            } else break;
        }
        BigDecimal decimal = new BigDecimal(length).setScale(2, RoundingMode.CEILING);

        return decimal + tun[tunIdx];
    }
}