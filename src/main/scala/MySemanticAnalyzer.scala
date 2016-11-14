/**
  * Created by RamanbirSehdev1 on 11/9/16.
  */

package edu.towson.cosc.cosc455.rsehde1.project1

import edu.towson.cosc.cosc455.rsehde1.project1.CONSTANTS
class MySemanticAnalyzer
{

  //Variable declarations in order to push into stack
  private var html: Stack[String] = new Stack[String]()
  private var parse: Stack[String] =

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

  //This method creates the HTML file
  def createFile(sourceFile: String) {
    val r = Compiler.fileName + ".html"
    val file = new File(t)
    if (file.exists()) file.createNewFile()
    openHTMLFileInBrowser(t)
  }



}
