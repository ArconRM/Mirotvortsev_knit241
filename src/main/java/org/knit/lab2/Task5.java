package org.knit.lab2;

import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public interface FileSystemComponent {
        String getName();

        double getSize();

        void add(FileSystemComponent component);

        void remove(FileSystemComponent component);

        void display(String indent);
    }

    public class File implements FileSystemComponent {
        String name;
        double size;

        File(String name, int size) {
            this.name = name;
            this.size = size;
        }

        public String getName() {
            return name;
        }

        public double getSize() {
            return size;
        }

        public void add(FileSystemComponent component) {
            System.out.println("File не может хранить в себе другие файлы.");
        }

        public void remove(FileSystemComponent component) {
            System.out.println("File не хранит в себе другие файлы.");
        }

        public void display(String indent) {
            System.out.println(indent + getName() + " (" + getSize() + " bytes)");
        }
    }

    public class Folder implements FileSystemComponent {
        String name;
        List<FileSystemComponent> files;

        Folder(String name) {
            this.name = name;
            files = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public double getSize() {
            double result = 0;
            for (FileSystemComponent file : files) {
                result += file.getSize();
            }
            return result;
        }

        public void add(FileSystemComponent component) {
            files.add(component);
        }

        public void remove(FileSystemComponent component) {
            files.remove(component);
        }

        public void display(String indent) {
            indent = indent.isEmpty() ? " " : indent;
            System.out.println(indent + getName() + " (" + getSize() + " bytes)");
            for (FileSystemComponent file: files) {
                file.display(indent + indent);
            }
        }
    }

    public void execute() {
        FileSystemComponent file1 = new File("file1.txt", 100);
        FileSystemComponent file2 = new File("file2.txt", 200);
        FileSystemComponent file3 = new File("file3.txt", 300);

        // Создаем папки
        FileSystemComponent folder1 = new Folder("Folder1");
        FileSystemComponent folder2 = new Folder("Folder2");

        // Добавляем файлы в папки
        folder1.add(file1);
        folder1.add(file2);

        folder2.add(file3);
        folder2.add(folder1); // Вложенная папка

        // Выводим структуру файловой системы
        folder2.display("-");

        // Выводим общий размер папки 2
        System.out.println("Total size of Folder2: " + folder2.getSize() + " bytes");

        System.out.println();
        folder2.remove(folder1);
        folder2.display("-");
        System.out.println("Total size of Folder2: " + folder2.getSize() + " bytes");
    }
}
