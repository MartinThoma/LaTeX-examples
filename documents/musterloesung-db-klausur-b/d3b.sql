CREATE TABLE Kunden2Berater (
    kunden_id INTEGER,
    berater_id INTEGER,
    PRIMARY KEY (kunden_id, berater_id),
    FOREIGN KEY (berater_id) REFERENCES Berater (berater_id),
    FOREIGN KEY (kunden_id) REFERENCES Kunden (kunden_id)
);

ALTER TABLE Kunden 
    DROP COLUMN berater_id;
