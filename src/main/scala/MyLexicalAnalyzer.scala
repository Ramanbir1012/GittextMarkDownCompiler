/**
  * Created by RamanbirSehdev1 on 11/9/16.
  */

package edu.towson.cosc.cosc455.rsehde1.project1
import edu.towson.cosc.cosc455.rsehde1.project1.CONSTANTS.RTEXT


class MyLexicalAnalyzer extends LexicalAnalyzer
{
  //Variable Declarations
  var nextCharacter: String = ""
  private var length: Int = 0
  override var currentPosition: Int =0
  private var next: Char = _
  private var lexical: Array[Char] = new Array[Char](100)

  getNextToken()

  //Method is used for getting the next token in order to parse it + use in stack
  override def getNextToken(): Unit =
  {
    try
    {
      //Find the current position and then look the next token
      if(currentPosition >=source.length)Compiler.currentToken =
        if(RTEXT.legal(String.valueOf(nextChar)))
          {
            addChar()
            addText
          }
          //Add heading to the stack
        else if(next =='#')
          {
            addChar()
            getChar()

          }
          //Bold token  to be lexemed and added
        else if (next=='*')
          {
            addChar()
            getChar()

          }
          //Listitem token  lexemed and added
        else if(next =='+')
          {
            addChar()
            getChar()
          }
          //Bracket token lexemed and added
        else if (next==']')
          {
            addChar()
            getChar()
          }
          //This line throws an error and exception if no characters are avaible to added
        else
          {
            throw new CompilerException("No characters available to add")
          }
      catch
      {
        println("ERROR ERROR ERROR")
        System.exit(0)
      }
    }
    setCurrentToken()
    getChar()
  }

  //This method allows the tokens to be added by looking at there current position
  def addChar()
  {
    lexical(length) = next
    length +=1
    currentPosition += 1
  }

  //This method allows the text be to added by looking at there current position
  def addText(): Unit =
  {
    var b = source(currentPosition)
    while(RTEXT.legal(String.valueOf(b)))
      next =b
    addChar()
    b=source.charAt(currentPosition)
    while(isSpace(String.valueOf(b)))
    {
      next-b
      b=source.charAt(currentPosition)
    }
  }

  //This method sets the current token checking the length
  def setCurrentToken(): Unit =
  {
    var txt = " "
    for (d <- 0 until length )
      {
        txt=txt + lexical(d)
      }
    Compiler.currentToken=txt
    lexical=Array[Char](100)
    length=0
  }

  //This method is used to get the character and put in the current position
  override def getChar(): Char =
  {
    next =source.charAt(currentPosition)
    val g = " " + next
    if(isSpace(a))
      {
        currentPosition +=1
        getChar()
      }
  }

  //This method checks the spaces available and return boolean values
  def isSpace(c: String): Boolean =
  {
    if (c== " ")
      return false
  }

  //This method is used to look up the token in order to be lexemed using an array of characters
   def lookupToken(): Boolean =
   {
     val lookup = "" + next
     val token = Array("*", "**", "+", "]", "#")
     for (k <- token if lookup ==k)
       return true
   }
}