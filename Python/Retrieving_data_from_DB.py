import mysql.connector

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="muskan",
  auth_plugin="mysql_native_password"
) # to connect

mycursor = mydb.cursor()
mycursor.execute("CREATE DATABASE movies") #Create_Database
mycursor.close()

mydb = mysql.connector.connect(
  host="localhost",
  user="root",
  password="muskan",
  auth_plugin="mysql_native_password",
  database = "movies"
) #connect

mycursor = mydb.cursor()


mycursor.execute("CREATE TABLE movies_table (name VARCHAR(30), actor VARCHAR(20), actress VARCHAR(20), director VARCHAR(20), yor INTEGER)"); #Create_table
sql = "INSERT INTO movies_table (name, actor, actress, director, yor) VALUES (%s, %s, %s, %s, %s)" #insert_in_table

val = ("Yeh Jawanni Hai Deewani","Ranbir Kapoor","Deepika Padukone","Ayan Mukerji",2013)
mycursor.execute(sql, val)

val = ("Kissing Booth","Jacob Elordi","Joey King","Vince Marcello",2018)
mycursor.execute(sql, val)

val = ("ABCD 2","Varun Dhawan","Shraddha Kapoor","Remo DSouza",2015)
mycursor.execute(sql, val)

val = ("Chennai Express","ShahRukh Khan","Deepika Padukone","Rohit Shetty",2013)
mycursor.execute(sql, val)

val = ("DDLJ","ShahRukh Khan","Kajol","Aditya Chopra",1995)
mycursor.execute(sql, val)

val = ("Om Shanti Om","ShahRukh Khan","Deepika Padukone","Farah Khan",2007)
mycursor.execute(sql, val)

val = ("Jagga Jasoos","Ranbir Kapoor","Katrina Kaif","Anurag basu",2017)
mycursor.execute(sql, val)

val = ("Ajab Prem Ki Gajab Kahani","Ranbir Kapoor","Katrina Kaif","RajKumar S",2009)
mycursor.execute(sql, val)

val = ("Titanic","Leonardo","Kate Winslet","James F C",1997)
mycursor.execute(sql, val)

val = ("Twilight","Kristen Stewart","Robert Pattison","Catherine",2008)
mycursor.execute(sql, val)
mydb.commit() #insert_values

mycursor.execute("SELECT * FROM movies_table")
myresult = mycursor.fetchall()
for i in myresult:
  print(i) #Print_Values


mycursor.execute("SELECT name FROM movies_table where yor < 2000")
myresult = mycursor.fetchall()
for i in myresult:
  print(i[0]) #Print_values(with parameter)
