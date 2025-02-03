package org.example.utils;

public interface schemaDB {
    String TAB_AUTORES = "autores";
    String COL_F_NACIMIENTO = "fecha_nacimiento";
    String TAB_EDITORIALES = "editoriales";
    String TAB_LIBRERIAS = "librerias";
    String TAB_LIBROS = "libros";
    String TAB_LIBRS_LIB = "librerias_libros";
    String COL_EDITORIALID = "id_editorial";
    String COL_AUTORID = "id_autor";
    String COL_LIBRERIAID = "id_libreria";
    String COL_LIBROID = "id_libro";
    String FK_LIB_ED = "libros_editoriales_FK";
    String FK_LIB_AU = "libros_autores_FK";
    String FK_LIBS_LIB = "librerias_libros_librerias_FK";
    String FK_LIB_LIBS = "librerias_libros_libros_FK";
}
