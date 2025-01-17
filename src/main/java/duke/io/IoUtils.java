package duke.io;

import duke.asserts.Asserter;
import duke.exceptions.CorruptDataException;
import duke.parser.DataParser;
import duke.model.Task;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class IoUtils {

    private static final String DUKE_DATA_DIR = System.getProperty("user.home") + File.separator + "data";
    private static final String DUKE_DATA_PATH = DUKE_DATA_DIR + File.separator + "duke.txt";
    private static final String CORRUPT_DATA_MESSAGE = "uWu, your data seems to be corrupted and is not readable";

    private BufferedReader bufferedReader;

    /**
     * Represents IO operations for Duke.
     */
    public IoUtils() {
        if (!doesStorageExist()) {
            createDataStorage();
        }
        bufferedReader = getBufferedReader();
    }

    /**
     * Writes a list of task to user's storage.
     * @param taskList The list of task to save
     */
    public void writeTasks(List<Task> taskList) {
        Asserter.assertNonNullList(taskList);

        Writer writer = getBufferedWriter();
        if (!doesWriterExist(writer)) {
            return;
        }
        writeToFile(writer, taskList);

    }

    /**
     * Reads a list of task from user's storage.
     * @return The list of tasks read from storage
     */
    public List<Task> readTasks() throws CorruptDataException {
        List<Task> storedData = new ArrayList<>();
        if (!doesReaderExist()) {
            return storedData;
        }
        return readFromFile(storedData);

    }

    private List<Task> readFromFile(List<Task> storedData) {
        DataParser dataParser = new DataParser();
        try {
            String line = bufferedReader.readLine();
            while (line != null) {
                Task task = dataParser.parseTask(line);
                if (task != null) {
                    storedData.add(task);
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            throw new CorruptDataException(CORRUPT_DATA_MESSAGE);
        }
        return storedData;
    }

    private boolean doesReaderExist() {
        return bufferedReader != null;
    }

    private static boolean doesStorageExist() {
        return Paths.get(DUKE_DATA_PATH).toFile().exists();
    }

    private static void createDataStorage() {
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

    private void writeToFile(Writer writer, List<Task> taskList) {
        try {
            for (Task task : taskList) {
                writer.write(task.getSaveString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean doesWriterExist(Writer writer) {
        return writer != null;
    }

}
