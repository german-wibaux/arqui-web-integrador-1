package primer.practico.dao;

public class DAOFactory {

    public static final int MYSQL_JDBC = 1;

    public static Object getDAOFactory(int whichFactory) {

        switch(whichFactory) {
            case MYSQL_JDBC : return new MySqlJDBCDAOFactory();
            default: return null;
        }
    }
}
