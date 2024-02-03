import csv
from dbconn import mysqlDbConnection, mysqlDbClose

def insertDB(query):
    dbConn = mysqlDbConnection('root', '0000', '127.0.0.1', 3306, 'birth_db')
    cursor = dbConn.cursor()

    file = open('./crawled_news.csv','r', encoding='UTF8')
    fReader = csv.reader(file)
    next(fReader)

    for line in fReader:
        query = "INSERT INTO news (Title, Link, Content, Date) VALUES (%s, %s, %s, %s)"
        data = (line[1], line[2], line[3],line[4])
        cursor.execute(query, data)
    file.close()

    dbConn.commit() 
    cursor.close()
    mysqlDbClose(dbConn)
    
    
    if __name__ == "__main__":
        insertDB()