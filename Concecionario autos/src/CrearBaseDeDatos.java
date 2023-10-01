import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

public class CrearBaseDeDatos {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:h2:file:./Concecionarioautos";
        ConnectionSource con = new JdbcConnectionSource(url);
        Dao<Inventario,String> tablaInventario =
                DaoManager.createDao(con,Inventario.class);
        TableUtils.createTable(tablaInventario);
        System.out.println("Tabla creada exitosamente!");
    }
}
