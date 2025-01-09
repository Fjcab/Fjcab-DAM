package database;

public interface SchemaDB {
    String HOST = "127.0.0.1";
    String PORT = "3306";
    String DBNAME = "almacen";
    String TAB_PROD = "productos";
    String TAB_EMP = "empleados";
    String TAB_PED = "pedidos";
    String TAB_PRODFAV = "productos_fav";
    String COL_ID = "id";
    String COL_NAME = "nombre";
    String COL_DESCRP = "descripcion";
    String COL_QTY = "cantidad";
    String COL_PRICE = "precio";
    String COL_SURNM = "apellidos";
    String COL_MAIL = "correo";
    String COL_ID_PROD = "id_producto";
    String COL_T_PRICE = "precio_total";
}
