package org.knit.lab11;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public interface FileDAO {
    void saveFile(File file) throws SQLException, IOException;
}
