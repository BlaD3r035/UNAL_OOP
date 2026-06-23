package Dir;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Directory {
    File directoryFile;

    public record Contact(String name, String phone) {}

    public Directory() {
        directoryFile = new File("Directory.txt");
        createDirectoryFile();
    }

    public Directory(String fileName) {
        directoryFile = new File(fileName);
        createDirectoryFile();
    }

    public void createDirectoryFile() {
        if (!directoryFile.exists()) {
            try {
                directoryFile.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Could not create directory file: " + e.getMessage());
            }
        }
    }

    public boolean contactExistsByName(String name) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(directoryFile, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.isBlank()) continue;
                String[] parts = line.split("!");
                if (parts[0].equalsIgnoreCase(name)) return true;
            }
        }
        return false;
    }

    public boolean contactExistsByPhone(String phone) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(directoryFile, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.isBlank()) continue;
                String[] parts = line.split("!");
                if (parts[1].equals(phone)) return true;
            }
        }
        return false;
    }

    public boolean createContact(String name, String phone) throws IOException, IllegalArgumentException {
        if (contactExistsByName(name)) {
            throw new IllegalArgumentException("A contact with the name '" + name + "' already exists.");
        }
        if(contactExistsByPhone(phone)){
            throw new IllegalArgumentException("A contact with the phone number '" + phone + "' already exists.");

        }
        try (RandomAccessFile raf = new RandomAccessFile(directoryFile, "rw")) {
            raf.seek(raf.length());
            raf.writeBytes(name + "!" + phone + "\n");
            return true;
        }
    }

    public Contact readContactName(String name) throws IOException, IllegalArgumentException {
        try (RandomAccessFile raf = new RandomAccessFile(directoryFile, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.isBlank()) continue;
                String[] parts = line.split("!");
                if (parts[0].equalsIgnoreCase(name)) {
                    return new Contact(parts[0], parts[1]);
                }
            }
        }
        throw new IllegalArgumentException("Contact not found: " + name);
    }
    public Contact readContactPhone(String name) throws IOException, IllegalArgumentException {
        try (RandomAccessFile raf = new RandomAccessFile(directoryFile, "r")) {
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.isBlank()) continue;
                String[] parts = line.split("!");
                if (parts[1].equals(name)) {
                    return new Contact(parts[0], parts[1]);
                }
            }
        }
        throw new IllegalArgumentException("Contact not found: " + name);
    }

    public boolean updateContact(String name, String newPhone) throws IOException, IllegalArgumentException {
        StringBuilder fileContent = new StringBuilder();
        boolean updated = false;

        try (RandomAccessFile raf = new RandomAccessFile(directoryFile, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.isBlank()) continue;
                String[] parts = line.split("!");
                if (parts[0].equalsIgnoreCase(name)) {
                    fileContent.append(parts[0]).append("!").append(newPhone).append("\n");
                    updated = true;
                } else {
                    fileContent.append(line).append("\n");
                }
            }

            if (!updated) {
                throw new IllegalArgumentException("Contact not found: " + name);
            }

            raf.seek(0);
            raf.setLength(0);
            raf.writeBytes(fileContent.toString());
            return true;
        }
    }

    public boolean deleteContact(String name) throws IOException, IllegalArgumentException {
        StringBuilder fileContent = new StringBuilder();
        boolean deleted = false;

        try (RandomAccessFile raf = new RandomAccessFile(directoryFile, "rw")) {
            while (raf.getFilePointer() < raf.length()) {
                String line = raf.readLine();
                if (line == null || line.isBlank()) continue;
                String[] parts = line.split("!");
                if (parts[0].equalsIgnoreCase(name)) {
                    deleted = true;
                } else {
                    fileContent.append(line).append("\n");
                }
            }

            if (!deleted) {
                throw new IllegalArgumentException("Contact not found: " + name);
            }

            raf.seek(0);
            raf.setLength(0);
            raf.writeBytes(fileContent.toString());
            return true;
        }
    }
    public static boolean isValidInteger(String str){
        if(str == null || str.isEmpty()){
            return false;
        }
        try{
            Integer.parseInt(str);
            return true;
        }catch (NumberFormatException e ){
            return  false;
        }
    }
}