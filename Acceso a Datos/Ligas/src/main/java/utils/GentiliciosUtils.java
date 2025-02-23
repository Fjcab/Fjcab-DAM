package utils;

import java.util.HashMap;
import java.util.Map;

public class GentiliciosUtils {

    private static final Map<String, String> MAPA_GENTILICIOS = new HashMap<>();

    static {
        MAPA_GENTILICIOS.put("Afganistán", "afgano");
        MAPA_GENTILICIOS.put("Albania", "albanés");
        MAPA_GENTILICIOS.put("Alemania", "alemán");
        MAPA_GENTILICIOS.put("Andorra", "andorrano");
        MAPA_GENTILICIOS.put("Angola", "angoleño");
        MAPA_GENTILICIOS.put("Antigua y Barbuda", "antiguano");
        MAPA_GENTILICIOS.put("Arabia Saudita", "saudí");
        MAPA_GENTILICIOS.put("Argelia", "argelino");
        MAPA_GENTILICIOS.put("Argentina", "argentino");
        MAPA_GENTILICIOS.put("Armenia", "armenio");
        MAPA_GENTILICIOS.put("Australia", "australiano");
        MAPA_GENTILICIOS.put("Austria", "austriaco");
        MAPA_GENTILICIOS.put("Azerbaiyán", "azerbaiyano");
        MAPA_GENTILICIOS.put("Bahamas", "bahameño");
        MAPA_GENTILICIOS.put("Bangladés", "bangladesí");
        MAPA_GENTILICIOS.put("Barbados", "barbadense");
        MAPA_GENTILICIOS.put("Baréin", "bareiní");
        MAPA_GENTILICIOS.put("Bélgica", "belga");
        MAPA_GENTILICIOS.put("Belice", "beliceño");
        MAPA_GENTILICIOS.put("Benín", "beninés");
        MAPA_GENTILICIOS.put("Bielorrusia", "bielorruso");
        MAPA_GENTILICIOS.put("Birmania (Myanmar)", "birmano");
        MAPA_GENTILICIOS.put("Bolivia", "boliviano");
        MAPA_GENTILICIOS.put("Bosnia y Herzegovina", "bosnio-herzegovino");
        MAPA_GENTILICIOS.put("Botsuana", "botsuano");
        MAPA_GENTILICIOS.put("Brasil", "brasileño");
        MAPA_GENTILICIOS.put("Brunéi", "bruneano");
        MAPA_GENTILICIOS.put("Bulgaria", "búlgaro");
        MAPA_GENTILICIOS.put("Burkina Faso", "burkinés");
        MAPA_GENTILICIOS.put("Burundi", "burundés");
        MAPA_GENTILICIOS.put("Bután", "butanés");
        MAPA_GENTILICIOS.put("Cabo Verde", "caboverdiano");
        MAPA_GENTILICIOS.put("Camboya", "camboyano");
        MAPA_GENTILICIOS.put("Camerún", "camerunés");
        MAPA_GENTILICIOS.put("Canadá", "canadiense");
        MAPA_GENTILICIOS.put("Catar", "catarí");
        MAPA_GENTILICIOS.put("Chad", "chadiano");
        MAPA_GENTILICIOS.put("Chile", "chileno");
        MAPA_GENTILICIOS.put("China", "chino");
        MAPA_GENTILICIOS.put("Chipre", "chipriota");
        MAPA_GENTILICIOS.put("Colombia", "colombiano");
        MAPA_GENTILICIOS.put("Comoras", "comorense");
        MAPA_GENTILICIOS.put("Corea del Norte", "norcoreano");
        MAPA_GENTILICIOS.put("Corea del Sur", "surcoreano");
        MAPA_GENTILICIOS.put("Costa de Marfil", "marfileño");
        MAPA_GENTILICIOS.put("Costa Rica", "costarricense");
        MAPA_GENTILICIOS.put("Croacia", "croata");
        MAPA_GENTILICIOS.put("Cuba", "cubano");
        MAPA_GENTILICIOS.put("Dinamarca", "danés");
        MAPA_GENTILICIOS.put("Dominica", "dominicense");
        MAPA_GENTILICIOS.put("Ecuador", "ecuatoriano");
        MAPA_GENTILICIOS.put("Egipto", "egipcio");
        MAPA_GENTILICIOS.put("El Salvador", "salvadoreño");
        MAPA_GENTILICIOS.put("Emiratos Árabes Unidos", "emiratí");
        MAPA_GENTILICIOS.put("Eritrea", "eritreano");
        MAPA_GENTILICIOS.put("Eslovaquia", "eslovaco");
        MAPA_GENTILICIOS.put("Eslovenia", "esloveno");
        MAPA_GENTILICIOS.put("España", "español");
        MAPA_GENTILICIOS.put("Estados Unidos", "estadounidense");
        MAPA_GENTILICIOS.put("Estonia", "estonio");
        MAPA_GENTILICIOS.put("Esuatini", "suazi");
        MAPA_GENTILICIOS.put("Etiopía", "etíope");
        MAPA_GENTILICIOS.put("Filipinas", "filipino");
        MAPA_GENTILICIOS.put("Finlandia", "finlandés");
        MAPA_GENTILICIOS.put("Fiyi", "fiyiano");
        MAPA_GENTILICIOS.put("Francia", "francés");
        MAPA_GENTILICIOS.put("Gabón", "gabonés");
        MAPA_GENTILICIOS.put("Gambia", "gambiano");
        MAPA_GENTILICIOS.put("Georgia", "georgiano");
        MAPA_GENTILICIOS.put("Ghana", "ghanés");
        MAPA_GENTILICIOS.put("Granada", "granadino");
        MAPA_GENTILICIOS.put("Grecia", "griego");
        MAPA_GENTILICIOS.put("Guatemala", "guatemalteco");
        MAPA_GENTILICIOS.put("Guinea", "guineano");
        MAPA_GENTILICIOS.put("Guinea-Bisáu", "bisauguineano");
        MAPA_GENTILICIOS.put("Guinea Ecuatorial", "ecuatoguineano");
        MAPA_GENTILICIOS.put("Guyana", "guyanés");
        MAPA_GENTILICIOS.put("Haití", "haitiano");
        MAPA_GENTILICIOS.put("Honduras", "hondureño");
        MAPA_GENTILICIOS.put("Hungría", "húngaro");
        MAPA_GENTILICIOS.put("India", "indio");
        MAPA_GENTILICIOS.put("Indonesia", "indonesio");
        MAPA_GENTILICIOS.put("Irak", "irakí");
        MAPA_GENTILICIOS.put("Irán", "iraní");
        MAPA_GENTILICIOS.put("Irlanda", "irlandés");
        MAPA_GENTILICIOS.put("Islandia", "islandés");
        MAPA_GENTILICIOS.put("Islas Marshall", "marshallés");
        MAPA_GENTILICIOS.put("Islas Salomón", "salomonense");
        MAPA_GENTILICIOS.put("Israel", "israelí");
        MAPA_GENTILICIOS.put("Italia", "italiano");
        MAPA_GENTILICIOS.put("Jamaica", "jamaiquino");
        MAPA_GENTILICIOS.put("Japón", "japonés");
        MAPA_GENTILICIOS.put("Jordania", "jordano");
        MAPA_GENTILICIOS.put("Kazajistán", "kazajo");
        MAPA_GENTILICIOS.put("Kenia", "keniano");
        MAPA_GENTILICIOS.put("Kirguistán", "kirguís");
        MAPA_GENTILICIOS.put("Kiribati", "kiribatiano");
        MAPA_GENTILICIOS.put("Kuwait", "kuwaití");
        MAPA_GENTILICIOS.put("Laos", "laosiano");
        MAPA_GENTILICIOS.put("Lesoto", "lesotense");
        MAPA_GENTILICIOS.put("Letonia", "letón");
        MAPA_GENTILICIOS.put("Líbano", "libanés");
        MAPA_GENTILICIOS.put("Liberia", "liberio");
        MAPA_GENTILICIOS.put("Libia", "libio");
        MAPA_GENTILICIOS.put("Liechtenstein", "liechtensteiniano");
        MAPA_GENTILICIOS.put("Lituania", "lituano");
        MAPA_GENTILICIOS.put("Luxemburgo", "luxemburgués");
        MAPA_GENTILICIOS.put("Madagascar", "malgache");
        MAPA_GENTILICIOS.put("Malasia", "malasio");
        MAPA_GENTILICIOS.put("Malaui", "malauí");
        MAPA_GENTILICIOS.put("Maldivas", "maldivo");
        MAPA_GENTILICIOS.put("Malí", "maliense");
        MAPA_GENTILICIOS.put("Malta", "maltés");
        MAPA_GENTILICIOS.put("Marruecos", "marroquí");
        MAPA_GENTILICIOS.put("Mauricio", "mauriciano");
        MAPA_GENTILICIOS.put("Mauritania", "mauritano");
        MAPA_GENTILICIOS.put("México", "mexicano");
        MAPA_GENTILICIOS.put("Micronesia", "micronesio");
        MAPA_GENTILICIOS.put("Moldavia", "moldavo");
        MAPA_GENTILICIOS.put("Mónaco", "monegascos");
        MAPA_GENTILICIOS.put("Mongolia", "mongol");
        MAPA_GENTILICIOS.put("Montenegro", "montenegrino");
        MAPA_GENTILICIOS.put("Mozambique", "mozambiqueño");
        MAPA_GENTILICIOS.put("Namibia", "namibio");
        MAPA_GENTILICIOS.put("Nauru", "nauriano");
        MAPA_GENTILICIOS.put("Nepal", "nepalí");
        MAPA_GENTILICIOS.put("Nicaragua", "nicaragüense");
        MAPA_GENTILICIOS.put("Níger", "nigerino");
        MAPA_GENTILICIOS.put("Nigeria", "nigeriano");
        MAPA_GENTILICIOS.put("Noruega", "noruego");
        MAPA_GENTILICIOS.put("Nueva Zelanda", "neozelandés");
        MAPA_GENTILICIOS.put("Omán", "omaní");
        MAPA_GENTILICIOS.put("Países Bajos", "neerlandés");
        MAPA_GENTILICIOS.put("Pakistán", "pakistaní");
        MAPA_GENTILICIOS.put("Palaos", "palauano");
        MAPA_GENTILICIOS.put("Panamá", "panameño");
        MAPA_GENTILICIOS.put("Papúa Nueva Guinea", "papú");
        MAPA_GENTILICIOS.put("Paraguay", "paraguayo");
        MAPA_GENTILICIOS.put("Perú", "peruano");
        MAPA_GENTILICIOS.put("Polonia", "polaco");
        MAPA_GENTILICIOS.put("Portugal", "portugués");
        MAPA_GENTILICIOS.put("Reino Unido", "británico");
        MAPA_GENTILICIOS.put("República Centroafricana", "centroafricano");
        MAPA_GENTILICIOS.put("República Checa", "checo");
        MAPA_GENTILICIOS.put("República del Congo", "congolés");
        MAPA_GENTILICIOS.put("República Democrática del Congo", "congolés");
        MAPA_GENTILICIOS.put("República Dominicana", "dominicano");
        MAPA_GENTILICIOS.put("Ruanda", "ruandés");
        MAPA_GENTILICIOS.put("Rumania", "rumano");
        MAPA_GENTILICIOS.put("Rusia", "ruso");
        MAPA_GENTILICIOS.put("Samoa", "samoano");
        MAPA_GENTILICIOS.put("San Cristóbal y Nieves", "cristobalense");
        MAPA_GENTILICIOS.put("San Marino", "sanmarinense");
        MAPA_GENTILICIOS.put("San Vicente y las Granadinas", "vincentino");
        MAPA_GENTILICIOS.put("Santa Lucía", "santalucense");
        MAPA_GENTILICIOS.put("Santo Tomé y Príncipe", "santomense");
        MAPA_GENTILICIOS.put("Senegal", "senegalés");
        MAPA_GENTILICIOS.put("Serbia", "serbio");
        MAPA_GENTILICIOS.put("Seychelles", "seychellense");
        MAPA_GENTILICIOS.put("Sierra Leona", "sierra leonesa");
        MAPA_GENTILICIOS.put("Singapur", "singapurense");
        MAPA_GENTILICIOS.put("Siria", "sirio");
        MAPA_GENTILICIOS.put("Somalia", "somalí");
        MAPA_GENTILICIOS.put("Sri Lanka", "srilanqués");
        MAPA_GENTILICIOS.put("Sudáfrica", "sudafricano");
        MAPA_GENTILICIOS.put("Sudán", "sudanés");
        MAPA_GENTILICIOS.put("Sudán del Sur", "sursudanés");
        MAPA_GENTILICIOS.put("Suecia", "sueco");
        MAPA_GENTILICIOS.put("Suiza", "suizo");
        MAPA_GENTILICIOS.put("Surinam", "surinamés");
        MAPA_GENTILICIOS.put("Tailandia", "tailandés");
        MAPA_GENTILICIOS.put("Tanzania", "tanzano");
        MAPA_GENTILICIOS.put("Tayikistán", "tayiko");
        MAPA_GENTILICIOS.put("Timor Oriental", "timorense");
        MAPA_GENTILICIOS.put("Togo", "togolés");
        MAPA_GENTILICIOS.put("Tonga", "tongano");
        MAPA_GENTILICIOS.put("Trinidad y Tobago", "trinitense");
        MAPA_GENTILICIOS.put("Túnez", "tunecino");
        MAPA_GENTILICIOS.put("Turkmenistán", "turcomano");
        MAPA_GENTILICIOS.put("Turquía", "turco");
        MAPA_GENTILICIOS.put("Tuvalu", "tuvaluano");
        MAPA_GENTILICIOS.put("Ucrania", "ucraniano");
        MAPA_GENTILICIOS.put("Uganda", "ugandés");
        MAPA_GENTILICIOS.put("Uruguay", "uruguayo");
        MAPA_GENTILICIOS.put("Uzbekistán", "uzbeko");
        MAPA_GENTILICIOS.put("Vanuatu", "vanuatense");
        MAPA_GENTILICIOS.put("Vaticano", "vaticano");
        MAPA_GENTILICIOS.put("Venezuela", "venezolano");
        MAPA_GENTILICIOS.put("Vietnam", "vietnamita");
        MAPA_GENTILICIOS.put("Yemen", "yemení");
        MAPA_GENTILICIOS.put("Yibuti", "yibutiano");
        MAPA_GENTILICIOS.put("Zambia", "zambiano");
        MAPA_GENTILICIOS.put("Zimbabue", "zimbabuense");
    }

    /**
     * @param pais el nombre del país
     * @return el gentilicio o "Desconocido" si no se encuentra
     */
    public static String getGentilicio(String pais) {
        return MAPA_GENTILICIOS.getOrDefault(pais, "Desconocido");
    }

    /**
     * @param gentilicio el gentilicio
     * @return el país o "Desconocido" si no se encuentra
     */
    public static String getPais(String gentilicio) {
        for (Map.Entry<String, String> entry : MAPA_GENTILICIOS.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(gentilicio)) {
                return entry.getKey();
            }
        }
        return "Desconocido";
    }

    public static String[] getPaises() {
        return MAPA_GENTILICIOS.keySet().stream()
                .sorted()
                .toArray(String[]::new);
    }

}

