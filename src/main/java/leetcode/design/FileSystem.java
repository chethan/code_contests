package leetcode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


//https://leetcode.com/problems/design-file-system/
public class FileSystem {

    private final Directory root;

    public FileSystem() {
        root = new Directory(-1);
    }

    public boolean createPath(String path, int value) {
        String[] paths = getPathSegments(path);
        if (paths == null) {
            return false;
        }
        Directory current = root;
        for (int i = 0; i < paths.length - 1; i++) {
            Optional<Directory> temp = current.getPath(paths[i]);
            if (temp.isEmpty()) {
                return false;
            }
            current = temp.get();
        }
        return current.addPath(paths[paths.length - 1], value).isPresent();

    }

    public int get(String path) {
        String[] paths = getPathSegments(path);
        if (paths == null) {
            return -1;
        }
        Directory current = root;
        for (String pathSegment : paths) {
            Optional<Directory> temp = current.getPath(pathSegment);
            if (temp.isEmpty()) {
                return -1;
            }
            current = temp.get();
        }
        return current.getValue();

    }

    String[] getPathSegments(String path) {
        if (path == null || path.equals("/") || !path.startsWith("/")) {
            return null;
        }
        return path.replaceFirst("/", "").split("/");

    }

    private static class Directory {

        private final int value;
        private final Map<String, Directory> paths;

        Optional<Directory> getPath(String path) {
            return Optional.ofNullable(paths.get(path));
        }

        Directory(int value) {
            paths = new HashMap<>();
            this.value = value;
        }

        int getValue() {
            return value;
        }

        Optional<Directory> addPath(String path, int value) {
            if (paths.containsKey(path)) {
                return Optional.empty();
            }
            Directory newDir = new Directory(value);
            paths.put(path, newDir);
            return Optional.of(newDir);
        }
    }
}
