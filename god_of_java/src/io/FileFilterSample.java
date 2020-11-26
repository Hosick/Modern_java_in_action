package io;

import java.io.File;
import java.io.FilenameFilter;

public class FileFilterSample {
    public static void main(String[] args) {
        FileFilterSample sample = new FileFilterSample();
        String pathName = File.separator + "godofjava" + File.separator + "text";
        sample.checkList(pathName);
    }

    public void checkList(String pathName) {
        File file;

        try {
            file = new File(pathName);
            //File[] mainFileList = file.listFiles();
            File[] mainFileList = file.listFiles(new JPGFileFilter());
            for (File tempFile : mainFileList) {
                System.out.println(tempFile.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
