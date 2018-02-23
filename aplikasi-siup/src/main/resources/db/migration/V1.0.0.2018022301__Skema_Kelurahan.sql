create table kelurahan (
  id INT PRIMARY KEY AUTO_INCREMENT,
  kode VARCHAR(10) NOT NULL UNIQUE,
  nama VARCHAR(255) NOT NULL, 
  kodepos VARCHAR(10) NOT NULL
);
