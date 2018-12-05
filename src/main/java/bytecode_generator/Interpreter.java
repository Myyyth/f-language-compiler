package bytecode_generator;

import java.io.*;
import java.net.URLClassLoader;

public class Interpreter extends ClassLoader {

    public void run(String name) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
//        //Class<?> cl = Class.forName(name);
//        URLClassLoader apploader = (URLClassLoader) getClass().getClassLoader();
//        ClassLoader loader = new URLClassLoader(apploader.getURLs(), apploader.getParent());
//        Class<?> c = loader.loadClass(name);
//        Runnable r = (Runnable) c.newInstance();
//        r.run();
        Class <?> clazz = findClass(name);
        Runnable r = ((Runnable)clazz.newInstance());
        if (r != null) {
            System.out.println("Running: " + name);
            System.out.println("-----------------------------------------");
            r.run();
        }
    }

    @Override
    public Class findClass(String name) {
        byte[] b = new byte[0];
        try {
            b = loadClassFromFile(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(name, b, 0, b.length);
    }

    private byte[] loadClassFromFile(String fileName) throws IOException {

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("src" + File.separatorChar + fileName.replace('.', File.separatorChar) + ".class");
        byte[] buffer;
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        int nextValue = 0;
        while ( (nextValue = inputStream.read()) != -1 ) {
            byteStream.write(nextValue);
        }
        buffer = byteStream.toByteArray();
        return buffer;
    }
}
