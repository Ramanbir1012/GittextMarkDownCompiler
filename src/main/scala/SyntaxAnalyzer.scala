/**
  * Created by RamanbirSehdev1 on 11/9/16.
  */
package edu.towson.cosc.cosc455.rsehde1.project1


//Methods used for the  my syntax analyzer in order to check for correct grammar
trait SyntaxAnalyzer
{
  def gittex() : Unit
  def title() : Unit
  def body() : Unit
  def paragraph() : Unit
  def innerText() : Unit
  def heading() : Unit
  def variableDefine() : Unit
  def variableUse() : Unit
  def bold() : Unit
  def italics() : Unit
  def listItem() : Unit
  def innerItem() : Unit
  def link() : Unit
  def image() : Unit
  def newline() : Unit
}