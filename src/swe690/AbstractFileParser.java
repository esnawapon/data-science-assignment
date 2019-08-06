package swe690;

import java.io.RandomAccessFile;
import java.util.Collection;

public abstract class AbstractFileParser<M extends Comparable<M>> {
    protected abstract String getDataFilePath();
    protected abstract M parseLineToModel(String line);

    public <C extends Collection<M>> C parseFileToCollection(C collection) throws Exception {
        return parseFileToCollection(collection, false);
    }
    public <C extends Collection<M>> C parseFileToCollection(C collection, boolean skipFirstRow) throws Exception {
        long start = System.currentTimeMillis();
        RandomAccessFile raf = new RandomAccessFile(getDataFilePath(), "r");
        String line;
        if (skipFirstRow) raf.readLine();
        while ((line = raf.readLine()) != null) {
            M model = parseLineToModel(line);
            collection.add(model);
        }
        long end = System.currentTimeMillis();
        System.out.println("[" + collection.getClass() + "]Duration: " + (end - start) + "ms");
        return collection;
    }
}
