import scala.io.Source._
import java.awt.Desktop
import java.io.{File, IOException}

import edu.towson.cosc.cosc455.rsehde1.project1.{MyLexicalAnalyzer, MySemanticAnalyzer, MySyntaxAnalyzer}

object Compiler
{


  //Variable Declarations
  var currentToken : String = ""
  var fileContents : String = ""

  val Scanner = new MyLexicalAnalyzer
  val Parser = new MySyntaxAnalyzer
  val semantic = new MySemanticAnalyzer
  val SemanticAnalyzer = new MySyntaxAnalyzer

  def main(args: Array[String]): Unit =
  {

    checkFile(args)
    readFile(args(0))

    print(fileContents)

    Scanner.getNextToken()
    parser.gittex
    openHTMLFileInBrowser(String)


    Scanner.begin(fileContents)

    while(Scanner.filePos < Scanner.filesize)

  }

  def readFile(file : String) =
  {
    val source = scala.io.Source.fromFile(file)
    fileContents = try source.mkString finally source.close()

  }

  //This method is use to determine how many arguments are in the file
  def checkFile(args : Array[String]) =
  {
    if (args.length != 1)
    {
      println("USAGE ERROR: wrong number of args fool!")
      System.exit(1)
    }
    else if (! args(0).endsWith(".mkd"))
    {
      println("USAGE ERROR: wrong extension fool!")
      System.exit(1)
    }

  }

  //Method is used to put the file in HTML format
  def openHTMLFileInBrowser(htmlFileStr : String) =
  {
    val file : File = new File(htmlFileStr.trim)
    println(file.getAbsolutePath)
    if (!file.exists())
      sys.error("File " + htmlFileStr + " does not exist.")

    try
    {
      Desktop.getDesktop.browse(file.toURI)
    }
    catch
      {
      case ioe: IOException => sys.error("Failed to open file:  " + htmlFileStr)
      case e: Exception => sys.error("He's dead, Jim!")
    }
  }
}