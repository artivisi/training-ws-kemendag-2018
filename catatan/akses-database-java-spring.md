# Akses Database #

Berbagai metode akses database:

* [JDBC : Java DataBase Connectivity](#jdbc)
* [ORM](#orm-object-relational-mapping)
* [Managed Connection / Transaction](#connection-transaction-management)
* [Spring Data JPA](#spring-data-jpa)


## JDBC ##

1. Load library
2. Connect
3. Begin Transaction
4. Konversi input/parameter menjadi SQL parameter
5. Execute SQL
6. Commit / Rollback
7. ResultSet
8. Konversi ke Object
9. Disconnect

Contoh yang salah

```java
String username = request.getParameter("username");
String password = request.getParameter("password");

String sql = "select * from t_user where ";
sql += "username = '"+username+"' ";
sql += "and password = '"+password+"'";

ResultSet rs = dbConnection.createStatement(sql).executeQuery();
```

Jangan sambung SQL seperti di atas, karena rawan SQL Injection.
Misalnya, username diisi nilai `1';delete from t_user;`

Hasilnya :
* `select * from t_user where username = '1';delete from t_user;' and password = '123';`
* no record, hapus tabel t_user, error

Contoh yang benar, menggunakan PreparedStatement

```java
String username = request.getParameter("username");
String password = request.getParameter("password");

String sql = "select * from t_user where ";
sql += "username = ? ";
sql += "and password = ?";

PreparedStatement psLogin = dbConnection.prepareStatement(sql);
psLogin.setString(1, username);
psLogin.setString(2, password);

ResultSet rs = psLogin.executeQuery();
```

Keuntungan menggunakan PreparedStatement:

* Menghindari SQL Injection
* Lebih optimal, karena SQL bisa dicompile dan di-cache oleh library database ataupun database server.

## ORM : Object Relational Mapping ##

Fungsi utama :

* Mapping antara tabel dan class
* Konversi dari ResultSet menjadi Object
* Generate SQL untuk tiap merek/versi database

Fungsi tambahan :

* Optimasi eksekusi SQL
* Cache

Beberapa produk ORM populer:

* Hibernate : tadinya opensource independen, kemudian jadi punya JBoss (Redhat)
* Toplink (berbayar) : Oracle
* EclipseLink (open source/gratis) : tadinya Toplink Essential (versi community)

Mitos ORM :

* Lebih lambat : tidak signifikan, masih acceptable
* SQL tidak optimal : belum tentu, karena programmer ORM lebih paham database daripada rata-rata programmer pengguna database

## Connection & Transaction Management ##

Fungsi utama:

* Connection pooling

    * minimum idle : jumlah minimum yang tetap connect walaupun sedang idle
    * max active : jumlah maksimum koneksi yang boleh dibuat
    * idle timeout : waktu idle maksimal sebelum disconnect
    * max wait : batas waktu menunggu koneksi tersedia, default unlimited. Kalau lewat max wait belum dapat koneksi, maka akan error.

* Transaction Management

   * Programmatic
   * Declarative : pakai annotation di method. Seluruh isi method dijalankan dalam satu scope transaction.
   * Managed transaction : transaction dikelola oleh Transaction Service.

Fitur Managed Transaction

* Distributed / XA Transaction / Two Phase Commit : transaction lintas database (lebih dari satu database)
* Transaction Propagation

    * REQUIRED : kalau belum ada transaction, start. Kalau sudah ada, ikut.
    * REQUIRES_NEW : kalau sudah ada, pause, jalan di transaction baru. Setelah selesai resume transaction sebelumnya
    * MANDATORY : kalau sudah ada, ikut. Kalau belum ada, error
    * SUPPORTS : kalau sudah ada, ikut. Kalau belum ada, jalan tanpa transaction
    * NOT SUPPORTED : kalau sudah ada, pause. Kalau belum ada, jalan tanpa transaction
    * NEVER : kalau sudah ada, error. Kalau belum ada, jalan tanpa transaction


[![Transaction Propagation Required](img/15-transaction-propagation-required.png)](img/15-transaction-propagation-required.png)

[![Transaction Propagation Requires New](img/16-transaction-propagation-requires_new.png)](img/16-transaction-propagation-requires_new.png)


## Spring Data JPA ##

Fitur :

* tidak perlu menulis kode program untuk CRUD.
* query method : nama method otomatis dikonversi jadi query.

    Contoh : `List<User> findByNamaContaining(String nama)`
    akan menghasilkan SQL : `select * from t_user where nama like %nama%`

* pagination
* integrasi dengan aplikasi web untuk:

    * konversi id ke object. `http://localhost/user?id=1`
    * param untuk paging dan sorting. Param `page`, `rows`, `sort` otomatis dikenali

## Referensi ##

* [Java Transaction Design Strategies](https://www.infoq.com/minibooks/JTDS)