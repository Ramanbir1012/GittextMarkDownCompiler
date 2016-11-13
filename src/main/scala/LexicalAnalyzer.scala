/**
  * Created by RamanbirSehdev1 on 11/9/16.
  */
package edu.towson.cosc.cosc455.rsehde1.project1

trait LexicalAnalyzer
{
  var nextChar: String = ""
  def isSpace(c: String): Boolean
  def addChar() : Unit
  def getChar() : Char
  def getNextToken() : Unit
  def lookup() : Boolean
  var currentPos: Int =0;
  {
    println("this is lookup implementation!")
  }
}