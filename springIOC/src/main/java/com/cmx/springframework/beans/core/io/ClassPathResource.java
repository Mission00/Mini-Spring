package com.cmx.springframework.beans.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource{
    private final String classPath;
    private ClassLoader classLoader;

    public ClassPathResource(String classPath) {
        this.classPath = classPath;
    }


    @Override
    public InputStream getInputStream() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(this.classPath);
        if (is == null) {
            throw new FileNotFoundException(this.classPath + " cannot be opened because it does not exist");
        }
        return is;
    }
}
