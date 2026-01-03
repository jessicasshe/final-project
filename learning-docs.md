# LEARNING LOG - NETBEANS/SQLite

## 2026-01-02
- Connected Github repo to Netbeans so we can commit directly instead of copy/pasting 
--> Click on the main project folder -> go to 'Install Git Repository' -> repeat and click on 'Git' -> connect account -> create an access token -> push code to repo

- Connected SQL database in order to finish & test the login form
Tutorial Used: https://www.youtube.com/watch?v=mcR1vDPMKP4

Simple queries: 
SELECT * from DATABASE NAME;

(optional: WHERE user_id = 2;)

Important packages for queries:
https://www.w3schools.com/sql/sql_syntax.asp
https://docs.oracle.com/javase/8/docs/api/java/sql/ResultSet.html
Statement: Object used to tell the database what to do (Select, Update, Insert, Delete)
ResultSet: A table you get back with selected after the statement's SELECT query which you can loop through
-> Flow: Statement -> ResultSet -> Loop through ResultSet to manipulate / view the data 
