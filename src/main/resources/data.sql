CREATE TABLE input_data (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            target_lang VARCHAR(3) NOT NULL,
                            source_lang VARCHAR(3) NOT NULL,
                            text VARCHAR(10000) NOT NULL,
                            query_datetime TIMESTAMP NOT NULL,
                            request_ip VARCHAR(15) NOT NULL
);
CREATE TABLE translated_data (
                                 id INT AUTO_INCREMENT PRIMARY KEY,
                                 query_id INT NOT NULL,
                                 text NCHAR(1000) NOT NULL,
                                 FOREIGN KEY (query_id) REFERENCES input_data (id)
);


