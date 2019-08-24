package com.chee.io;

import com.chee.model.Task;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class IOUtils {

    private static final String DUKE_DATA_DIR = System.getProperty("user.home") + File.separator + "data";
    private static final String DUKE_DATA_PATH = DUKE_DATA_DIR + File.separator + "duke.txt";

    public static void writeTasks(List<Task> taskList) {
        Writer writer = getBufferedWriter();
        if(writer == null) return;
        try {
            for(Task task : taskList) {
                writer.write(task.getSaveString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Task> readTasks() {
        BufferedReader reader = getBufferedReader();
        DataParser dataParser = new DataParser();
        List<Task> storedData = new ArrayList<>();
        if(reader == null) return storedData;
        try {
            String line = reader.readLine();
            while(line != null) {
                Task task = dataParser.parseTask(line);
                if(task != null) {
                    storedData.add(task);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return storedData;
    }

    public static boolean doesStorageExist() {
        return Paths.get(DUKE_DATA_PATH).toFile().exists();
    }

    public static void createDataStorage() {
        try {
            Files.createDirectory(Paths.get(DUKE_DATA_DIR));
            Files.createFile(Paths.get(DUKE_DATA_PATH));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Writer getBufferedWriter() {
        Path dukePath = Paths.get(DUKE_DATA_PATH);
        try {
            return Files.newBufferedWriter(dukePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static BufferedReader getBufferedReader() {
        Path dukePath = Paths.get(DUKE_DATA_PATH);
        try {
            return Files.newBufferedReader(dukePath);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
