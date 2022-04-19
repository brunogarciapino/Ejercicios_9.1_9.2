import java.util.logging.Level
import java.util.logging.LogManager

internal val l = LogManager.getLogManager().getLogger("").apply { level = Level.ALL }
internal fun i(tag: String, msg: String) {
    l.info("[$tag] - $msg")
}


fun main() {
    var portatil = "C:\\Users\\bruno\\IdeaProjects\\9_1\\src\\main\\kotlin\\Catalog.xml"

    val gestorDeLibros = gestionLibros(CatalogoLibrosXML(portatil),BookManagementIU())
    gestorDeLibros.preguntarPorUnLibro()
    gestorDeLibros.mostrarInfoDeUnLibro()

}

interface GestionLibrosIU{
    fun preguntarPorID():String
    fun mostrarInfoDeLibro(infoLibro:Map<String,Any>)
    fun existenciaLibro(boolean: Boolean, idLibro: String)
}

class GestionLibrosIUES:GestionLibrosIU {
    override fun preguntarPorID(): String {
        println("Introduzca un ID: ")
        return readln()
    }

    override fun mostrarInfoDeLibro(infoLibro:Map<String,Any>) {
        if (infoLibro.isNotEmpty())
            println("La información sobre el libro es la siguiente\n$infoLibro")
        else
            println("No se encontró información sobre el libro")
    }

    override fun existenciaLibro(boolean: Boolean, idLibro: String) {
        if(boolean) println("El libro $idLibro existe!")
        else println("El libro $idLibro NO existe!")
    }

}

class BookManagementIU():GestionLibrosIU{
    override fun preguntarPorID(): String {
        println("Enter the ID: ")
        return readln()
    }

    override fun mostrarInfoDeLibro(infoLibro: Map<String, Any>) {
        if (infoLibro.isNotEmpty())
            println("The information about the book is the following:\n$infoLibro")
        else
            println("There is no information about this book.")
    }

    override fun existenciaLibro(boolean: Boolean, idLibro: String) {
        if(boolean) println("The book $idLibro exists!")
        else println("The book $idLibro does not exist!")
    }

}

interface CatalogoLibros{
    fun existeLibro(idLibro:String):Boolean
    fun infoLibro(idLibro: String):Map<String, Any>
}

class gestionLibros(catalogoLibros: CatalogoLibros, gestionLibrosIU: GestionLibrosIU)
{
    var cat:CatalogoLibros = catalogoLibros
    val iu:GestionLibrosIU =  gestionLibrosIU

    fun preguntarPorUnLibro() {

        val idLibro = iu.preguntarPorID()
        iu.existenciaLibro(cat.existeLibro(idLibro),idLibro)
    }

    fun mostrarInfoDeUnLibro()
    {
        var idLibro = iu.preguntarPorID()
        var infoLibro = cat.infoLibro(idLibro)
        iu.mostrarInfoDeLibro(infoLibro)
    }

}