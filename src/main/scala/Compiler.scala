import scala.io.Source._
import java.awt.Desktop
import java.io.{File, IOException}

import edu.towson.cosc.cosc455.rsehde1.project1.{MyLexicalAnalyzer, MySemanticAnalyzer, MySyntaxAnalyzer}

object Compiler
{
  //Variable Declarations
  var currentToken : String = ""
  var fileContents : String = ""

  //Declarations for the class to be used in the compiler
  val Scanner = new MyLexicalAnalyzer
  val Parser = new MySyntaxAnalyzer
  val semantic = new MySemanticAnalyzer
  val SemanticAnalyzer = new MySyntaxAnalyzer

  //Main Method To check if file is being read and its arguments
  def main(args: Array[String]): Unit =
  {

    //Check HTML file arguments
    checkFile(args)
    readFile(args(0))

    print(fileContents)

    Scanner.getNextToken()
    parser.gittex
    openHTMLFileInBrowser(String)
    Scanner.begin(fileContents)
  }

  //This method is use to read the HTML file
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
}