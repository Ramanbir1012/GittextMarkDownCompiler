/**
  * Created by RamanbirSehdev1 on 11/9/16.
  */
package edu.towson.cosc.cosc455.rsehde1.project1

trait LexicalAnalyzer
{
  def addChar() : Unit
  def getChar() : Char
  def getNextToken() : Unit
  def lookup() : Boolean =
  {
    println("this is lookup implementation!")
  }
}