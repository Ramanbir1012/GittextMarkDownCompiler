/**
  * Created by RamanbirSehdev1 on 11/9/16.
  */

package edu.towson.cosc.cosc455.rsehde1.project1

import com.sun.org.apache.xalan.internal.xsltc.compiler.CompilerException


class MyLexicalAnalyzer(private var source: String) extends LexicalAnalyzer
{

  private var lexeme: Array[Char] = new Array [Char](99)
  private var length: Int =0
  private var next: Char = _

  override def addChar(): Unit = ???



  // override def lookup(): Boolean = ???

  override def getNextToken(): Unit =

  {
    if(currentPos >= source.length) Compiler.currentToken =
      if(TEXT.legal(String.valueOf(next)))
        {
          addChar()
          addText()
        }
      else if(next == '$')
        {
          addChar()
          getChar
          addVar()
        }

    //This method gets characters in order to be put in the parse tree
     def getChar(): Unit =
    {
      next= source.charAt(currentPos)
      val d = " " + next
      if(isSpace(d))
      {
        currentPos += 1
        getChar
      }
    }

    //This method adds characters in the parse tree

    def addChar(): Unit =
    {
      lexeme(length) = next
      length +1
      currentPos +=1
    }













    val c  = getChar()
  }

  override def getChar(): Char = ???


}