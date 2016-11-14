/**
  * Created by RamanbirSehdev1 on 11/9/16.
  */
package edu.towson.cosc.cosc455.rsehde1.project1
import scala.collection.mutable.Stack

class MySyntaxAnalyzer extends SyntaxAnalyzer
{

  //Declartions for the stack/parser tree
  var valid: Boolean = false

  val parse = Stack[String]()


  //This method is used for get the current token from the BNF File
  override def gittex(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.DOCB))
    {

      // add to parse tree / stack
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("Error")
      System.exit(1)
    }
  }


    override def paragraph(): Unit =
    {
      //Get current token for the paragraph and parse it
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.PARAB))
      {
        parse.push(CONSTANTS.PARAB)
        Compiler.Scanner.getNextToken()
      }
      else
      //throws an error if syntax is wrong
      {
        println("ERROR...Wrong Format")
        System.exit(1)
      }
    }

    //This method adds items tokens which are being called from the  or else throws an error
    override def innerItem(): Unit =

      //Look at current token ignores the case if its not link
      if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LINKB))
      {
        link()
        innerItem()
      }

      //Look at current token ignores the case if its not italics
      else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ITALICS))
      {
      italics()
      innerItem()
      }


    else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.USEB))
      {
        variableUse()
        innerItem()
      }
      //Look at current token ignores the case if its not bold
      else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BOLD))
      {
          bold()
          innerItem()
      }
      else
      {
        //Else throws an error looking at boolean value
        println("ERROR")
        valid =false
      }



  //This method checks if the actual text is following syntax rules and checks the current token
  override def innerText(): Unit =
  {

    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.PARAE))
      {
      if(parse.Contains(CONSTANTS.PARAB))
        parse()
      }
    else
      {
        println("ERROR")
        System.exit(1)
      }
  }
  if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.HEADING))
    {
      heading()
      innerText()
    }
  else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.USEB))

    {
      variableUse()
      innerText()
    }

  else if(Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BOLD))
  {
  bold()
  innerText()
  }
  else if(Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ITALICS))
  {
    italics()
    innerText()
  }
  else if(Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LISTITEM))
  {
    listItem()
    innerText()
  }
  else if(Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LINKB))
  {
    link()
    innerText()
  }
  else if(Compiler.currentToken.equalsIgnoreCase(CONSTANTS.IMAGEB))
  {
    image()
    innerText()
  }
  else if(Compiler.currentToken.equalsIgnoreCase(CONSTANTS.NEWLINE))
  {
    newline()
    innerText()
  }


//This method links the different parts of tokens
  override def link(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LINKB))
    {
      link()
      parse()
    }
    else
    {
      println("Please add start of link tag ")
    }
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.RTEXT))
    {
      parse()
      innerText()
    }
    else
    {
      println("PLEASE ADD TEXT")
    }
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ADDRESSB))
    {
      parse()
    }
    else
    {
      println("Missing Adress")
    }
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ADDRESSE)
    {
      parse
    }
    else
    {
      println("Please add end of the address tag)
    }
  }

  //This method checks the entire paragraph tokens and makes sure the BNF follows all the legal grammar
  override def body(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.PARAB))
      {
        paragraph()
        body()
      }
    else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.DOCE))
    {
      paragraph()
      body()
    }

    else
      {
        innerText()
        body()
      }
  }

  //Bold Method which is then called by method bolded
  override def bold(): Unit =
  {
    bolded()
  }

  ////This method checks if the token in bold and check its syntax
  def bolded(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.BOLD))
    {
      parse.push(CONSTANTS.BOLD)
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("ERROR...Wrong Format..MISSING **")
      System.exit(1)
    }
  }


  //Italics method which calls the ital method to check the grammar
  override def italics(): Unit =
  {
    ital()
  }

  //This method checks if the token is italics
  def ital(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.ITALICS))
    {
      parse.push(CONSTANTS.ITALICS)
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("ERROR...Wrong Format..MISSING *")
      System.exit(1)
    }
  }

  ////This method checks for new line and pushes into the stack to be used in parse tree
  override def newline(): Unit =
  {
    if(Compiler.currentToken.equalsIgnoreCase(CONSTANTS.NEWLINE))
      {
        parse.CONSTANTS.NEWLINE
        Compiler.Scanner.getNextToken()

      }
    else
      {
        println("Unable to go to next line...Syntactical ERROR")
      }
  }

  //This method is used to check the validity of the titles and gittex
  override def title(): Unit =
  {
    titles()
    innerText()
    body()
  }

  //This method pushes the title token into the stack to be used in parse tree
  def titles(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.TITLEB))
    {
      parse.push(CONSTANTS.TITLEB)
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("ERROR...Wrong Forma..MISSING \\TITLE")
      System.exit(1)
    }
  }


  //This method is being called by DOCB
  def doc(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.DOCB))
    {
      parse.push(CONSTANTS.DOCB)
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("ERROR...Wrong Format)
      System.exit(1)
    }
  }

  //This method to check the grammar of the variables that are defined
  override def variableDefine(): Unit =

  {
    if(Compiler.currentToken.equalsIgnoreCase(CONSTANTS.DEFB)
      {
        defb()
      }
    else if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.EQSIGN))
      {
        equalsSign()
      }
  }

  //This Method Checks for the legal grammer for an image
  override def image(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.IMAGEB))
      {
        parse.push(CONSTANTS.IMAGEB)
        Compiler.Scanner.getNextToken()
      }
    else
      {
        println("ERROR...Wrong Fromat..MISSING ![")
        System.exit(1)
      }
  }

  //This method is used to check the legal grammer for the variables used
  override def variableUse(): Unit =
  {
    Use()
    innerItem()

  }

  def Use(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.USEB))
    {
      parse.push(CONSTANTS.USEB)
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("ERROR...Wrong Format")
      System.exit(1)
    }
  }

  //This method is used and called by link in order to link the tokens
  def link(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.LINKB))
    {
      parse.push(CONSTANTS.LINKB)
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("ERROR...Wrong Format..MISSING [")
      System.exit(1)
    }
  }


  //Heading Method calls the method head in order to check for the Syntax to be correct
  override def heading(): Unit =
  {
    heading()
    innerItem()
  }

  //This method is used to check the heading annotations
   def head(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.HEADING))
    {
      parse.push(CONSTANTS.HEADING)
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("ERROR... Missing # ")
      System.exit(1)
    }
  }

  //This method is used to list the items correctly
  override def listItem(): Unit =
  {
    listItem()
    innerItem()
  }

  //This method pushes the italics into the stack to be used in parse tree and verified the correct syntax
  def equalsSign(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.EQSIGN))
    {
      parse.push(CONSTANTS.EQSIGN)
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("ERROR...Wrong Format..MISSING = ")
      System.exit(1)
    }
  }

  //This method is used to define the grammar and its being called by DEFB
  def defb(): Unit =
  {
    if (Compiler.currentToken.equalsIgnoreCase(CONSTANTS.DEFB))
    {
      parse.push(CONSTANTS.DEFB)
      Compiler.Scanner.getNextToken()
    }
    else
    {
      println("ERROR...Wrong Format")
      System.exit(1)
    }
  }
}