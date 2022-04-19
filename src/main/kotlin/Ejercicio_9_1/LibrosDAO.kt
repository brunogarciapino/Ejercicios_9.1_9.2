package Ejercicio_9_1

import java.sql.DriverManager
import java.util.*


data class Mybook(val id: String,
                  var author: String,
                  val title: String,
                  val genre: String,
                  val price: Double,
                  val publish_date: Date,
                  val description: String
)
fun main(){
    val jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"

        // get the connection
    val connection = DriverManager
            .getConnection(jdbcUrl, "PROGRAMACION", "PROGRAMACION")

    println(connection.isValid(0))
// the query is only prepared not executed
val query = connection.prepareStatement("SELECT * FROM BOOKS")

// the query is executed and results are fetched
val result = query.executeQuery()

// an empty list for holding the results
val books = mutableListOf<Mybook>()

while (result.next()) {

    // getting the value of the id column
    val id = result.getString("id")
    // getting the value of the name column
    val author = result.getString("author")
    // getting the value of the name column
    val title = result.getString("title")
    // getting the value of the name column
    val genre = result.getString("genre")
    // getting the value of the name column
    val price = result.getDouble("price")
    // getting the value of the name column
    val publish_date = result.getDate("publish_date")
    // getting the value of the name column
    val description = result.getString("description")

    /*
    constructing a User object and
    putting data into the list
     */
    books.add(Mybook(id,author,title,genre,price,publish_date,description))
}

println(books)

}

