EveIris
=======
Eve Online static database access

Provides access to a local database containing the Eve Online static data. 
Therefore you have to currently manually install a database like MySql and load the static datadump into this database.

Using the library
=======
Simply get an instance of the DataCore class by calling DataCore.getInstance();

The DataCore contains functions, like findStation(int id) with that you can get an Object representing the Station of which you have provided the actual id; 

Setup for a MySql Installation
=======
I. Download these resources:
  1. http://dev.mysql.com/downloads/mysql/ (Community Version, free)
  2. http://evedump.icyone.net/rubicon-1.0-93082/ (original.sql, free)
 
II. Use the Mysql Workbench to add the datadump to a fresh database.

III. Configure the hibernate.cfg.xml with the database's name, user and password.

Now you can use the library.
