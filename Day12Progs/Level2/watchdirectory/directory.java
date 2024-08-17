package Day12Progs.Level2.watchdirectory;

import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;

public class directory {
    public static void main(String[] args) {
        Path dir = Paths.get("watchdirectory");

        try (WatchService watchService = FileSystems.getDefault().newWatchService()) {
            dir.register(watchService, ENTRY_CREATE, ENTRY_MODIFY);

            System.out.println("Watching directory: " + dir);

            while (true) {
                WatchKey key;
                try {
                    key = watchService.take();
                } catch (InterruptedException e) {
                    System.out.println("Watch service interrupted");
                    return;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    if (kind == OVERFLOW) {
                        continue;
                    }

                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path fileName = ev.context();
                    Path filePath = dir.resolve(fileName);

                    if (kind == ENTRY_CREATE) {
                        System.out.println("File created: " + filePath);
                    } else if (kind == ENTRY_MODIFY) {
                        System.out.println("File modified: " + filePath);
                    }
                }

                boolean valid = key.reset();
                if (!valid) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Error setting up watch service: " + e.getMessage());
        }
    }
}