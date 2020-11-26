package io;

import java.io.File;
import java.io.FilenameFilter;

public class JPGFileNameFilter implements FilenameFilter {

    @Override
    public boolean accept(File file, String fileName) {
        if (fileName.endsWith(".jpg")) return true;
        return false;
    }
}
