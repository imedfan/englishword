
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LineIterator implements Iterator {
    private final BufferedReader bufferedReader;
    private String cachedLine;
    private boolean finished = false;
    private BufferedReader reader;

    public LineIterator(final BufferedReader reader) throws IllegalAccessException {
        if (reader == null) {
            throw new IllegalArgumentException("reader must not be null");
        }

        this.reader = reader;

        if (reader instanceof BufferedReader) {
            bufferedReader = (BufferedReader) reader;
        } else {
            bufferedReader = new BufferedReader(reader);
        }

    }

    public boolean hasNext() {
        if (cachedLine != null) {
            return true;
        } else if (finished) {
            return false;
        } else {
            try {
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        finished = true;
                        return false;
                    } else if (isValidLine(line)) {
                        cachedLine = line;
                        return true;
                    }
                }

            } catch (IOException e) {
                close();
                throw new IllegalStateException(e.toString());
            }
        }
    }

    public boolean isValidLine(String line) {
        return true;
    }

    public Object next() {
        return nextLine();
    }

    public String nextLine() {
        if (!hasNext()) {
            throw new NoSuchElementException("No next line");
        }
        String currentLine = cachedLine;
        cachedLine = null;
        return currentLine;
    }

    public void close() {
        finished = true;
        cachedLine = null;
    }

    public void remove() {
        throw new UnsupportedOperationException("Remove unsupported on LineIttertor");
    }

}
