import com.google.common.collect.Lists;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.List;

public final class FileUtils {

    private FileUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Prefix for absolute file path
     */
    public static final String FILE_PREFIX = "file:";
    /**
     * Prefix for file path in classpath
     */
    public static final String CLASS_PATH_PREFIX = "classpath:";

    /**
     * Get absolute files paths
     *
     * @param filePathnames files Pathnames
     * @return list of absolute file paths.
     */
    public static List<String> getFileAbsolutPaths(List<String> filePathnames) {
        final List<String> absoluteFilePathnames = Lists.newArrayList();
        for (String filePathname : filePathnames) {
            absoluteFilePathnames.add(getFileAbsolutePath(filePathname));
        }
        return absoluteFilePathnames;
    }

    /**
     * Get absolute file paths
     *
     * @param filePathname file Pathnames
     * @return absolute file paths.
     */
    public static String getFileAbsolutePath(String filePathname) {
        try {
            if (filePathname.startsWith(FILE_PREFIX)) {
                final String path = filePathname.substring(FILE_PREFIX.length());
                if (new File(path).exists()) {
                    return path;
                }
            } else if ((filePathname.startsWith(CLASS_PATH_PREFIX))) {
                final String path = filePathname.substring(CLASS_PATH_PREFIX.length());
                final ClassPathResource classPathResource = new ClassPathResource(path);
                if (classPathResource.exists()) {
                    return classPathResource.getFile().getPath();
                }
            } else {
                final ClassPathResource classPathResource = new ClassPathResource(filePathname);
                if (classPathResource.exists()) {
                    return classPathResource.getFile().getPath();
                } else {
                    if (new File(filePathname).exists()) {
                        return filePathname;
                    }
                }
            }
            throw new IllegalStateException("Cannot find file in neither in classpath and not in classpath "
                    + filePathname);
        } catch (IOException e) {
            throw new IllegalStateException("Exception occurred while finding file by path " + filePathname);
        }
    }

    /**
     * Deletes directories recursively
     *
     * @param file file
     * @throws java.io.IOException exception
     */
    public static void deleteRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                deleteRecursively(child);
            }
        }
        file.delete();
    }
}
