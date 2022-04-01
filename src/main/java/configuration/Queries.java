package configuration;

public class Queries {
    public static final String INSERT_INPUT_DATA_QUERY = "INSERT INTO input_data (target_lang, source_lang, text, query_datetime, request_ip) "
            + "VALUES"
            + " (?, ?, ?, CURRENT_TIMESTAMP, ?)";

    public static final String INSERT_TRANSLATED_DATA_QUERY = "INSERT INTO translated_data (query_id, text) VALUES (?, ?)";
    public static final String GET_ID_QUERY = "SELECT TOP 1 id FROM INPUT_DATA WHERE text=? ORDER BY query_datetime DESC";
    public static final String GET_TRANSLATED_TEXT = "SELECT text FROM TRANSLATED_DATA WHERE query_id = ? ORDER BY ID ";
}
